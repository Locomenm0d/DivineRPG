package naturix.divinerpg.objects.items;


import naturix.divinerpg.DivineRPG;
import net.minecraft.item.ItemPickaxe;

public class PickaxeBase extends ItemPickaxe {

	private String name;

	public PickaxeBase(ToolMaterial material, String name, float damage, float speed) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPG.ToolsTab);
		this.name = name;
	}
	
	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

}