package naturix.divinerpg.objects.entities.assets.render.twilight;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelCadillion;
import naturix.divinerpg.objects.entities.entity.arcana.EdenCadillion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderEdenCadillion extends RenderLiving<EdenCadillion> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/eden_cadillion.png");
	private final ModelCadillion ModelCadillion;
    
	public RenderEdenCadillion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCadillion(), 1F);
        ModelCadillion = (ModelCadillion) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EdenCadillion entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EdenCadillion> {

	        @Override
	        public Render<? super EdenCadillion> createRenderFor(RenderManager manager) {
	            return new RenderEdenCadillion(manager, new ModelCadillion(), 0.5F);
	        }
	    }

	}