package mod.azure.doom.client;

import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.lwjgl.glfw.GLFW;

import mod.azure.doom.DoomMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * 
 * @credit to https://github.com/Tfarcenim/LockOn/tree/1.16.x/src/main/java/tfar/lockon
 *
 */
public class LockOnHandler {
	public static KeyBinding LOCK_ON;
	public static KeyBinding TAB;

	public static List<LivingEntity> list = new ArrayList<>();

	private static final Minecraft mc = Minecraft.getInstance();

	public static void client(FMLClientSetupEvent e) {
		LOCK_ON = new KeyBinding("key." + DoomMod.MODID + ".lock_on", GLFW.GLFW_KEY_O, "key.categories." + DoomMod.MODID);
		TAB = new KeyBinding("key." + DoomMod.MODID + ".tab", GLFW.GLFW_KEY_LEFT_ALT, "key.categories." + DoomMod.MODID);
		ClientRegistry.registerKeyBinding(LOCK_ON);
		ClientRegistry.registerKeyBinding(TAB);
		EVENT_BUS.addListener(LockOnHandler::handleKeyPress);
	}

	public static boolean lockedOn;
	private static Entity targetted;

	private static void handleKeyPress(TickEvent.RenderTickEvent e) {
		PlayerEntity player = mc.player;
		if (e.phase == TickEvent.Phase.START && mc.player != null && !mc.isGamePaused()) {
			tickLockedOn();
			while (LOCK_ON.isPressed()) {
				if (lockedOn) {
					leaveLockOn();
				} else {
					attemptEnterLockOn(player);
				}
			}

			while (TAB.isPressed()) {
				tabToNextEnemy(player);
			}

			if (targetted != null) {
				Vector3d targetPos = targetted.getPositionVec();
				Vector3d directionVec = targetPos.subtract(mc.player.getPositionVec()).normalize();
				double angle = Math.atan2(-directionVec.x, directionVec.z) * 180 / Math.PI;

				float adjustedPrevYaw = mc.player.prevRotationYaw;
				if (Math.abs(angle - adjustedPrevYaw) > 180) {
					if (adjustedPrevYaw > angle) {
						angle += 360;
					} else if (adjustedPrevYaw < angle) {
						angle -= 360;
					}
				}

				double newDelta = MathHelper.lerp(e.renderTickTime, adjustedPrevYaw, angle);
				if (newDelta > 180) {
					newDelta -= 360;
				}
				if (newDelta < -180) {
					newDelta += 360;
				}
				mc.player.rotationYaw = (float) newDelta;
			}
		}
	}

	private static void attemptEnterLockOn(PlayerEntity player) {
		tabToNextEnemy(player);
		if (targetted != null) {
			lockedOn = true;
		}
	}

	private static void tickLockedOn() {
		list.removeIf(livingEntity -> mc.player == null || !livingEntity.isAlive());
		if (targetted != null && !targetted.isAlive()) {
			targetted = null;
			lockedOn = false;
		}
	}

	private static final Predicate<LivingEntity> ENTITY_PREDICATE = entity -> entity.isAlive() && entity.attackable();
	private static final EntityPredicate ENEMY_CONDITION = new EntityPredicate().setDistance(20.0D)
			.setCustomPredicate(ENTITY_PREDICATE);

	private static int cycle = -1;

	public static Entity findNearby(PlayerEntity player) {
		List<LivingEntity> entities = player.world.getTargettableEntitiesWithinAABB(LivingEntity.class, ENEMY_CONDITION,
				player, player.getBoundingBox().grow(10.0D, 2.0D, 10.0D));
		if (lockedOn) {
			cycle++;
			for (LivingEntity entity : entities) {
				if (!list.contains(entity)) {
					list.add(entity);
					return entity;
				}
			}

			// cycle existing entity
			if (cycle >= list.size()) {
				cycle = 0;
			}
			return list.get(cycle);
		} else {
			if (!entities.isEmpty()) {
				LivingEntity first = entities.get(0);
				list.add(first);
				return entities.get(0);
			} else {
				return null;
			}
		}
	}

	private static void tabToNextEnemy(PlayerEntity player) {
		targetted = findNearby(player);
	}

	private static void leaveLockOn() {
		targetted = null;
		lockedOn = false;
		list.clear();
	}
}