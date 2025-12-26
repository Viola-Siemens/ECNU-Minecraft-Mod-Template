package org.ecnumc.ecnu.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Layer Locations
 */
@OnlyIn(Dist.CLIENT)
public class ECNULayerLocations {
	public static final ModelLayerLocation NULLSET = new ModelLayerLocation(new ResourceLocation(MODID, "nullset"), "main");

	private ECNULayerLocations() {
	}
}
