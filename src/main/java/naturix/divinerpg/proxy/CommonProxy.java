package naturix.divinerpg.proxy;

import java.io.File;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.events.EventArmorSet;
import naturix.divinerpg.events.EventClientLogin;
import naturix.divinerpg.events.EventLightning;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.registry.ModEntities;
import naturix.divinerpg.registry.ModLiquids;
import naturix.divinerpg.utils.DRPGParticleTypes;
import naturix.divinerpg.utils.ListAllObjs;
import naturix.divinerpg.world.ModWorldGen;
import naturix.divinerpg.world.structures.WorldGenCustomStructures;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	public static Configuration config;

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {

	}

	public static void registerEvent(Object event) {
		FMLCommonHandler.instance().bus().register(event);
		MinecraftForge.EVENT_BUS.register(event);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
	}

	public EntityPlayer getPlayer() {
		return null;
	}

	public void init(FMLInitializationEvent e) {
	}

	public void postInit(FMLPostInitializationEvent e) {
		if (config.hasChanged()) {
			config.save();
		}

		ModEntities.initSpawns();
	}

	public void preInit(FMLPreInitializationEvent e) {
		File directory = e.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "DivineRPG/divinerpg.cfg"));
		Config.readConfig();
		ModDimensions.init();
		ModEntities.init();
		ModEntities.initLoot();
		ModLiquids.init();
		ListAllObjs.listobjs();
		DivineRPG.registerEvent(new EventArmorSet());
		DivineRPG.registerEvent(new EventClientLogin());
		DivineRPG.registerEvent(new EventLightning());

		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
	}

	public void registerItemRenderer(Item itemBlock, int i, String name) {

	}

	public void updateClientArcana(float amount) {
	}

	public void spawnParticle(World world, DRPGParticleTypes particle, double x, double y, double z, double velX, double velY, double velZ) {
	}
}