package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Smelter extends EntityDivineRPGTameable {

    public Smelter(World worldIn, EntityPlayer player) {
        this(worldIn);
        setTamed(true);
        setOwnerId(player.getUniqueID());
    }

    public Smelter(World worldIn) {
        super(worldIn);
        this.setSize(1.3F, 2.5F);
        this.isImmuneToFire = true;
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (stack != null) {
                if (stack.getItem() instanceof ItemFood) {
                    ItemFood food = (ItemFood) stack.getItem();

                    if (food == Items.FLINT && this.getHealth() < this.getMaxHealth()) {
                        if (!player.capabilities.isCreativeMode) {
                            stack.setCount(stack.getCount() - 1);
                        }

                        this.heal(food.getHealAmount(stack));

                        if (stack.getCount() <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
                        }

                        return true;
                    }
                }
            }
        } else {
            this.setTamed(true);
            this.setOwnerId(player.getUniqueID());
        }

        return super.processInteract(player, hand);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 7.0F);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.EHU;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.EHU_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.EHU_HURT;
    }
}
