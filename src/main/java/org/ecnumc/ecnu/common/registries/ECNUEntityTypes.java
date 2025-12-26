package org.ecnumc.ecnu.common.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.ecnumc.ecnu.common.entities.NullsetEntity;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Entity Types
 * @author liudongyu
 */
public final class ECNUEntityTypes {
	private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

	/**
	 * Entity Type for the President of ECNUMC.
	 */
	public static final RegistryObject<EntityType<NullsetEntity>> NULLSET = ENTITY_TYPES.register(
			"nullset", () -> EntityType.Builder.<NullsetEntity>of(NullsetEntity::new, MobCategory.MISC)
					.sized(0.6F, 1.8F)
					.clientTrackingRange(10)
					.build(new ResourceLocation(MODID, "nullset").toString())
	);

	private ECNUEntityTypes() {
	}

	/**
	 * Register the entity types on mod constructing.
	 * @param modBus	the mod bus
	 */
	public static void init(IEventBus modBus) {
		ENTITY_TYPES.register(modBus);
	}
}
