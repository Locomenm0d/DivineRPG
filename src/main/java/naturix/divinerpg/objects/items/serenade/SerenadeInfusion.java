package naturix.divinerpg.objects.items.serenade;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.ItemBase;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SerenadeInfusion extends ItemBase {

	public SerenadeInfusion(String name) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		setMaxDamage(15);
		setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Gives the user Regeneration");
		tooltip.add(stack.getMaxDamage() - stack.getItemDamage() + " uses left");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {

		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);

		entity.getHeldItem(hand).damageItem(1, entity);
		world.playSound(entity, entity.getPosition(), ModSounds.HEAL, SoundCategory.MASTER, 1, 1);
		entity.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 2, true, false));
		return ar;
	}
}