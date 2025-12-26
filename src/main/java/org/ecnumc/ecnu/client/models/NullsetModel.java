package org.ecnumc.ecnu.client.models;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.ecnumc.ecnu.common.entities.NullsetEntity;

/**
 * Entity Model for Nullset
 * @author liudongyu
 */
@OnlyIn(Dist.CLIENT)
public class NullsetModel<T extends NullsetEntity> extends PlayerModel<T> {
	private static final boolean SLIM = true;

	public NullsetModel(ModelPart root) {
		super(root, SLIM);
	}

	/**
	 * Create the body layer
	 * @return the body layer
	 */
	public static LayerDefinition createBodyLayer() {
		return LayerDefinition.create(createMesh(CubeDeformation.NONE, SLIM), 64, 64);
	}
}
