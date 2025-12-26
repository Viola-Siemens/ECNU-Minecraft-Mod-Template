package org.ecnumc.ecnu;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.ecnumc.ecnu.common.ECNUContent;

/**
 * Mod Main Class
 * @author liudongyu
 */
@SuppressWarnings("java:S1118")
@Mod(ECNUForge.MODID)
public class ECNUForge {
	public static final String MODID = "ecnu";

	public ECNUForge() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		ECNUContent.modConstruction(modBus);
	}
}
