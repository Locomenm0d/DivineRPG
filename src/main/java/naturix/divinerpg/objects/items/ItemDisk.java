package naturix.divinerpg.objects.items;

import naturix.divinerpg.objects.items.vethia.ItemVethianDisk;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDisk extends ItemVethianDisk {
	public ItemDisk(int par1, String name) {
		super(par1, name);
	}

	@Override
	public void shoot(ItemStack var1, World var2, EntityPlayer var3) {
		// if (var1.getItem() == VetheaItems.teakerDisk) {
		// var2.spawnEntityInWorld(new EntityTeakerDisk(var2, var3, dam, this));
		// }
		if (var1.getItem() == ModItems.amthirmisDisk) {
			// var2.spawnEntityInWorld(new EntityAmthirmisDisk(var2, var3, dam, this));
		}
		// if (var1.getItem() == VetheaItems.darvenDisk) {
		// var2.spawnEntityInWorld(new EntityDarvenDisk(var2, var3, dam, this));
		// }
		// if (var1.getItem() == VetheaItems.cermileDisk) {
		// var2.spawnEntityInWorld(new EntityCermileDisk(var2, var3, dam, this));
		// }
		// if (var1.getItem() == VetheaItems.pardimalDisk) {
		// var2.spawnEntityInWorld(new EntityPardimalDisk(var2, var3, dam, this));
		// }
		// if (var1.getItem() == VetheaItems.quadroticDisk) {
		// var2.spawnEntityInWorld(new EntityQuadroticDisk(var2, var3, dam, this));
		// }
		// if (var1.getItem() == VetheaItems.karosDisk) {
		// var2.spawnEntityInWorld(new EntityKarosDisk(var2, var3, dam, this));
		// }
		// if (var1.getItem() == VetheaItems.heliosisDisk) {
		// var2.spawnEntityInWorld(new EntityHeliosisDisk(var2, var3, dam, this));
		// }
		// if (var1.getItem() == VetheaItems.arksianeDisk) {
		// var2.spawnEntityInWorld(new EntityArksianeDisk(var2, var3, dam, this));
		// }
	}
}
