package mod.azure.doom.client;

import mod.azure.doom.util.registry.DoomItems;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModItemModelsProperties {

	public ModItemModelsProperties() {
		// Crucible
		ItemModelsProperties.registerProperty(DoomItems.CRUCIBLESWORD.get(), new ResourceLocation("broken"),
				(p_210312_0_, p_210312_1_, p_210312_2_) -> {
					return isUsable(p_210312_0_) ? 0.0F : 1.0F;
				});
		// Marauder Axe
		ItemModelsProperties.registerProperty(DoomItems.AXE_OPEN.get(), new ResourceLocation("broken"),
				(p_210312_0_, p_210312_1_, p_210312_2_) -> {
					return isUsable(p_210312_0_) ? 0.0F : 1.0F;
				});
		// Plasma Gun
		ItemModelsProperties.registerProperty(DoomItems.PLASMAGUN.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(DoomItems.PLASMAGUN.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});
	}

	public static boolean isUsable(ItemStack stack) {
		return stack.getDamage() < stack.getMaxDamage() - 1;
	}
}