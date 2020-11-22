package mod.azure.doom.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

/**
 * 
 * @credit to
 *         https://gitlab.com/modding-legacy/leap/-/blob/1.16.x/src/main/java/com/legacy/leap/
 *
 */
public class LeapingDoomEnchantment extends Enchantment {

	public LeapingDoomEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.ARMOR_FEET, slots);
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return enchantmentLevel * 15;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + 10;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean isTreasureEnchantment() {
		return true;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
	}
}
