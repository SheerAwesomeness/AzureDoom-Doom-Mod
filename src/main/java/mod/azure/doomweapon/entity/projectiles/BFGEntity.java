package mod.azure.doomweapon.entity.projectiles;

import java.util.List;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BFGEntity extends AbstractArrowEntity {

	private final Item referenceItem;
	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	@SuppressWarnings("unchecked")
	public BFGEntity(EntityType<?> type, World world) {
		super((EntityType<? extends AbstractArrowEntity>) type, world);
		this.referenceItem = null;
	}

	public BFGEntity(LivingEntity shooter, World world, Item referenceItemIn) {
		super(ModEntityTypes.BFG_CELL.get(), shooter, world);
		this.referenceItem = referenceItemIn;
	}

	protected void func_225516_i_() {
		++this.ticksInAir;
		if (this.ticksExisted >= 40) {
			this.remove();
		}
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		super.shoot(x, y, z, velocity, inaccuracy);
		this.ticksInAir = 0;
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putShort("life", (short) this.ticksInAir);
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.ticksInAir = compound.getShort("life");
	}

	@SuppressWarnings("deprecation")
	public void tick() {
		super.tick();
		boolean flag = this.getNoClip();
		Vector3d vector3d = this.getMotion();
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt(horizontalMag(vector3d));
			this.rotationYaw = (float) (MathHelper.atan2(vector3d.x, vector3d.z) * (double) (180F / (float) Math.PI));
			this.rotationPitch = (float) (MathHelper.atan2(vector3d.y, (double) f) * (double) (180F / (float) Math.PI));
			this.prevRotationYaw = this.rotationYaw;
			this.prevRotationPitch = this.rotationPitch;
		}

		if (this.ticksExisted >= 600) {
			this.remove();
		}

		if (this.inAir && !flag) {
			this.func_225516_i_();

			++this.timeInAir;
		} else {
			this.timeInAir = 0;
			Vector3d vector3d2 = this.getPositionVec();
			Vector3d vector3d3 = vector3d2.add(vector3d);
			RayTraceResult raytraceresult = this.world.rayTraceBlocks(new RayTraceContext(vector3d2, vector3d3,
					RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this));
			if (raytraceresult.getType() != RayTraceResult.Type.MISS) {
				vector3d3 = raytraceresult.getHitVec();
			}
			while (!this.removed) {
				EntityRayTraceResult entityraytraceresult = this.rayTraceEntities(vector3d2, vector3d3);
				if (entityraytraceresult != null) {
					raytraceresult = entityraytraceresult;
				}
				if (raytraceresult != null && raytraceresult.getType() == RayTraceResult.Type.ENTITY) {
					Entity entity = ((EntityRayTraceResult) raytraceresult).getEntity();
					Entity entity1 = this.func_234616_v_();
					if (entity instanceof PlayerEntity && entity1 instanceof PlayerEntity
							&& !((PlayerEntity) entity1).canAttackPlayer((PlayerEntity) entity)) {
						raytraceresult = null;
						entityraytraceresult = null;
					}
				}
				if (raytraceresult != null && raytraceresult.getType() != RayTraceResult.Type.MISS && !flag
						&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
					this.onImpact(raytraceresult);
					this.isAirBorne = true;
				}
				if (entityraytraceresult == null || this.getPierceLevel() <= 0) {
					break;
				}
				raytraceresult = null;
			}
			vector3d = this.getMotion();
			double d3 = vector3d.x;
			double d4 = vector3d.y;
			double d0 = vector3d.z;
			if (this.getIsCritical()) {
				for (int i = 0; i < 4; ++i) {
					this.world.addParticle(ParticleTypes.CRIT, this.getPosX() + d3 * (double) i / 4.0D,
							this.getPosY() + d4 * (double) i / 4.0D, this.getPosZ() + d0 * (double) i / 4.0D, -d3,
							-d4 + 0.2D, -d0);
				}
			}
			double d5 = this.getPosX() + d3;
			double d1 = this.getPosY() + d4;
			double d2 = this.getPosZ() + d0;
			float f1 = MathHelper.sqrt(horizontalMag(vector3d));
			if (flag) {
				this.rotationYaw = (float) (MathHelper.atan2(-d3, -d0) * (double) (180F / (float) Math.PI));
			} else {
				this.rotationYaw = (float) (MathHelper.atan2(d3, d0) * (double) (180F / (float) Math.PI));
			}
			this.rotationPitch = (float) (MathHelper.atan2(d4, (double) f1) * (double) (180F / (float) Math.PI));
			this.rotationPitch = func_234614_e_(this.prevRotationPitch, this.rotationPitch);
			this.rotationYaw = func_234614_e_(this.prevRotationYaw, this.rotationYaw);
			float f2 = 0.99F;
			this.setMotion(vector3d.scale((double) f2));
			if (!this.hasNoGravity() && !flag) {
				Vector3d vector3d4 = this.getMotion();
				this.setMotion(vector3d4.x, vector3d4.y - (double) 0.05F, vector3d4.z);
			}
			this.setPosition(d5, d1, d2);
			this.doBlockCollisions();
		}
	}

	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(this.referenceItem);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean hasNoGravity() {
		if (this.isInWater()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isPushedByWater() {
		return false;
	}

	protected IParticleData getParticle() {
		return ParticleTypes.TOTEM_OF_UNDYING;
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		Entity entity = this.func_234616_v_();
		if (p_213868_1_.getType() != RayTraceResult.Type.ENTITY
				|| !((EntityRayTraceResult) p_213868_1_).getEntity().isEntityEqual(entity)) {
			if (!this.world.isRemote) {
				List<LivingEntity> list = this.world.getEntitiesWithinAABB(LivingEntity.class,
						this.getBoundingBox().grow(4.0D, 2.0D, 4.0D));
				AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(),
						this.getPosY(), this.getPosZ());
				if (entity instanceof LivingEntity) {
					areaeffectcloudentity.setOwner((LivingEntity) entity);
				}

				areaeffectcloudentity.setParticleData(ParticleTypes.TOTEM_OF_UNDYING);
				areaeffectcloudentity.setRadius(1.0F);
				areaeffectcloudentity.setDuration(10);
				areaeffectcloudentity.setRadiusPerTick(
						(7.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
				areaeffectcloudentity.addEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1));
				if (!list.isEmpty()) {
					for (LivingEntity livingentity : list) {
						double d0 = this.getDistanceSq(livingentity);
						if (d0 < 16.0D) {
							areaeffectcloudentity.setPosition(livingentity.getPosX(), livingentity.getPosY(),
									livingentity.getPosZ());
							break;
						}
					}
				}

				this.world.playEvent(2006, this.getPosition(), this.isSilent() ? -1 : 1);
				this.world.addEntity(areaeffectcloudentity);
				this.explode();
				this.remove();
			}

		}
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		Entity entity = this.func_234616_v_();
		if (result.getType() != RayTraceResult.Type.ENTITY
				|| !((EntityRayTraceResult) result).getEntity().isEntityEqual(entity)) {
			if (!this.world.isRemote) {
				List<LivingEntity> list = this.world.getEntitiesWithinAABB(LivingEntity.class,
						this.getBoundingBox().grow(4.0D, 2.0D, 4.0D));
				AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(),
						this.getPosY(), this.getPosZ());
				if (entity instanceof LivingEntity) {
					areaeffectcloudentity.setOwner((LivingEntity) entity);
				}

				areaeffectcloudentity.setParticleData(ParticleTypes.TOTEM_OF_UNDYING);
				areaeffectcloudentity.setRadius(1.0F);
				areaeffectcloudentity.setDuration(10);
				areaeffectcloudentity.setRadiusPerTick(
						(7.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
				areaeffectcloudentity.addEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1));
				if (!list.isEmpty()) {
					for (LivingEntity livingentity : list) {
						double d0 = this.getDistanceSq(livingentity);
						if (d0 < 16.0D) {
							areaeffectcloudentity.setPosition(livingentity.getPosX(), livingentity.getPosY(),
									livingentity.getPosZ());
							break;
						}
					}
				}

				this.world.playEvent(2006, this.getPosition(), this.isSilent() ? -1 : 1);
				this.world.addEntity(areaeffectcloudentity);
				this.explode();
				this.remove();
			}
			this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
		}
	}

	protected void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 12.0F,
				Explosion.Mode.NONE);
	}
}