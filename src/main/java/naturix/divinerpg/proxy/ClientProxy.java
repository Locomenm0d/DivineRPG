package naturix.divinerpg.proxy;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.tile.RenderTiles;
import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.client.ArcanaRenderer;
import naturix.divinerpg.client.ClientTicker;
import naturix.divinerpg.client.TEISRRender;
import naturix.divinerpg.events.EventDevHat;
import naturix.divinerpg.particle.ParticleFrost;
import naturix.divinerpg.registry.ModEntities;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.DRPGParticleTypes;
import naturix.divinerpg.utils.GUIHandler;
import naturix.divinerpg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;


public class ClientProxy extends CommonProxy {
    public static MusicTicker.MusicType Music_Iceika;

	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModEntities.initModels();
        OBJLoader.INSTANCE.addDomain(DivineRPG.modId);
        NetworkRegistry.INSTANCE.registerGuiHandler(DivineRPG.instance, new GUIHandler());

    }
	@Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        RenderTiles.init();
        Utils.setupCapes();
        Utils.updateCapeList();

        Music_Iceika = EnumHelperClient.addMusicType("iceika_music", ModSounds.ICEIKA_MUSIC, 1200, 12000);
    }
	@Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        DivineRPG.registerEvent(new EventDevHat());

        Utils.postFMLEvent(new ArcanaRenderer());
        Utils.postFMLEvent(new ClientTicker());

       }

    @Override
	public EntityPlayer getPlayer() {
		return FMLClientHandler.instance().getClientPlayerEntity();
	}

    public void registerItemRenderer(Item item, int meta, String id) {
    	ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(DivineRPG.modId + ":" + id, "inventory"));

    }
    ArcanaHelper ah;
    public void updateClientArcana(float amount) {
//        ArcanaHelper.getProperties(Minecraft.getMinecraft().player).setBarValue(amount);
    }
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	TEISRRender.init();
    }

    @Override
    public void spawnParticle(World world, DRPGParticleTypes particletype, double x, double y, double z, double velX, double velY, double velZ) {
        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = mc.getRenderViewEntity();

        if (entity != null && mc.effectRenderer != null) {
            int i = mc.gameSettings.particleSetting;

            if (i == 1 && world.rand.nextInt(3) == 0) {
                i = 2;
            }

            double d0 = entity.posX - x;
            double d1 = entity.posY - y;
            double d2 = entity.posZ - z;

            if (d0 * d0 + d1 * d1 + d2 * d2 <= 1024D && i <= 1) {
                Particle particle = null;

                switch (particletype) {
                    case FROST:
                        particle = new ParticleFrost(world, x, y, z, velX, velY, velZ);
                        break;
                }

                if (particle != null) {
                    mc.effectRenderer.addEffect(particle);
                }
            }
        }
    }

}
