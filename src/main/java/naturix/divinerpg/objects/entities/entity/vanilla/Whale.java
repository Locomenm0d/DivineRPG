package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGSwimming;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Whale extends EntityDivineRPGSwimming {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/whale");

    public Whale(World worldIn) {
        super(worldIn);
        this.setSize(4F, 2f);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.WHALE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.WHALE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.WHALE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}
