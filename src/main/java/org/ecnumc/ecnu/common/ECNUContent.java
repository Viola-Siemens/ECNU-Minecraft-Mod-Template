package org.ecnumc.ecnu.common;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.ecnumc.ecnu.common.entities.NullsetEntity;
import org.ecnumc.ecnu.common.registries.ECNUCreativeModeTabs;
import org.ecnumc.ecnu.common.registries.ECNUEntityTypes;
import org.ecnumc.ecnu.common.registries.ECNUItems;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Content
 * @author liudongyu
 */
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ECNUContent {
	/**
	 * Called on mod constructing.
	 * @param modBus	the mod bus
	 */
	public static void modConstruction(IEventBus modBus) {
		ECNUEntityTypes.init(modBus);
		ECNUItems.init(modBus);
		ECNUCreativeModeTabs.init(modBus);
	}

	private ECNUContent() {
	}

	@SubscribeEvent
	public static void onAttributeCreate(EntityAttributeCreationEvent event) {
		 event.put(ECNUEntityTypes.NULLSET.get(), NullsetEntity.createAttributes().build());
	}
}
