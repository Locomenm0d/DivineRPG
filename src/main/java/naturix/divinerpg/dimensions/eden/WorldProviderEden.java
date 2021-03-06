package naturix.divinerpg.dimensions.eden;

import naturix.divinerpg.dimensions.eden.biome.BiomeProviderEden;
import naturix.divinerpg.dimensions.eden.chunk.ChunkGeneratorEden;
import naturix.divinerpg.registry.ModBiomes;
import naturix.divinerpg.registry.ModDimensions;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class WorldProviderEden extends WorldProvider {
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeProviderSingle(ModBiomes.Eden);
		this.nether = false;
		this.hasSkyLight = true;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorEden(this.world, this.world.getSeed() + this.getDimension());
	}
	
	@Override
    public BiomeProvider getBiomeProvider() {
		return this.biomeProvider = new BiomeProviderEden();
	}
	
    @Override
	public int getMoonPhase(long s) {
        return (int)(s / 24000L % 8L + 8L) % 8;
    }
    
	@Override
    public boolean canRespawnHere() {
        return false;
    }

	@Override
    public boolean isSurfaceWorld() {
        return false;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return 8.0F;
    }

	@Override
    public int getAverageGroundLevel() {
        return 70;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

	@Override
	public DimensionType getDimensionType() {
		return ModDimensions.edenDimension;
	}
	@Nullable
    @Override
	public String getSaveFolder()
    {
        return "Eden";
    }
}