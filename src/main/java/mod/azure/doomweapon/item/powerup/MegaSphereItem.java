package mod.azure.doomweapon.item.powerup;

import java.util.List;

import mod.azure.doomweapon.DoomMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MegaSphereItem extends Item {

	public MegaSphereItem() {
		super(new Item.Properties().group(DoomMod.DoomItemGroup).maxStackSize(1));
	}

	@Override
	public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (livingEntityIn instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) livingEntityIn;
			if (!worldIn.isRemote)
				livingEntityIn.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 600, 4));
			livingEntityIn.heal(40);
			livingEntityIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 600, 4));
			livingEntityIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 600, 4));
			if (!playerentity.abilities.isCreativeMode) {
				stack.shrink(1);
				if (stack.isEmpty()) {
					playerentity.inventory.deleteStack(stack);
				}
			}
		}
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 7000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.setActiveHand(handIn);
		return ActionResult.resultConsume(itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A7o" + "Makes the Player have 200% Health and 100% Resistance for 30 seconds."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

}