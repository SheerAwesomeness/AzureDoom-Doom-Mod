package mod.azure.doomweapon.item.weapons;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.util.registry.DoomItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class DoomBlade extends Item {

	public DoomBlade() {
		super(new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag context) {
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "A modification to the Praetor suit,"));
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "the arm-mounted Doomblade is designed"));
		tooltip.add(new StringTextComponent(
				"\u00A7c" + "\u00A7o" + "to increase the Slayer's short-range striking power."));
		super.addInformation(stack, world, tooltip, context);
	}
	
	@Override
	public ICapabilityProvider initCapabilities(final ItemStack stack, CompoundNBT unused) {
		ICurio curio = new ICurio() {
			@Override
			public boolean canRightClickEquip() {
				return true;
			}

			@Override
			public void onEquip(String identifier, int index, LivingEntity livingEntity) {
				if (livingEntity instanceof PlayerEntity) {
					startPowers((PlayerEntity) livingEntity);
				}
			}

			@Override
			public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
				if (livingEntity instanceof PlayerEntity) {
					stopPowers((PlayerEntity) livingEntity);
				}
			}

			private void startPowers(PlayerEntity player) {
				player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 10000000, 0));
			}

			private void stopPowers(PlayerEntity player) {
				player.removePotionEffect(Effects.STRENGTH);
			}

			@Override
			public void curioTick(String identifier, int index, LivingEntity livingEntity) {
				if (livingEntity instanceof PlayerEntity) {
					PlayerEntity player = ((PlayerEntity) livingEntity);
					startPowers(player);
				}
			}

			@Override
			public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
				return !CuriosApi.getCuriosHelper().findEquippedCurio(DoomItems.DOOM_BLADE.get(), entityLivingBase)
						.isPresent();
			}
		};

		return new ICapabilityProvider() {
			private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);

			@Nonnull
			@Override
			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {

				return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
			}
		};
	}

	public static boolean isBraceletInCuriosSlot(ItemStack belt, LivingEntity player) {
		return CuriosApi.getCuriosHelper().findEquippedCurio(belt.getItem(), player).isPresent();
	}
	
}