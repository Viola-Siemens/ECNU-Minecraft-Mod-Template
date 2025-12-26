package org.ecnumc.ecnu.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.ecnumc.ecnu.client.ECNULayerLocations;
import org.ecnumc.ecnu.client.models.NullsetModel;
import org.ecnumc.ecnu.common.entities.NullsetEntity;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Nullset Renderer
 * @author liudongyu
 */
@OnlyIn(Dist.CLIENT)
public class NullsetRenderer extends MobRenderer<NullsetEntity, NullsetModel<NullsetEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/entity/nullset/nullset.png");

	public NullsetRenderer(EntityRendererProvider.Context manager) {
		super(manager, new NullsetModel<>(manager.bakeLayer(ECNULayerLocations.NULLSET)), 0.5F);
	}

	/**
	 * Get texture for a nullset entity
	 * @param entity	the nullset entity
	 * @return a texture
	 */
	@Override
	public ResourceLocation getTextureLocation(NullsetEntity entity) {
		return TEXTURE;
	}
}
