package org.ecnumc.ecnu.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.ecnumc.ecnu.common.entities.NullsetEntity;
import org.ecnumc.ecnu.common.registries.ECNUEntityTypes;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Item to summon nullsets when right-clicked.
 * @author liudongyu
 */
public class NullsetItem extends Item {
	public NullsetItem(Properties properties) {
		super(properties);
	}

	/**
	 * Called when this item is used when targeting a Block
	 * @param context	interaction context
	 */
	@Override
	public InteractionResult useOn(UseOnContext context) {
		Direction direction = context.getClickedFace();
		if (direction == Direction.DOWN) {
			return InteractionResult.FAIL;
		}
		Level level = context.getLevel();
		BlockPlaceContext blockPlaceContext = new BlockPlaceContext(context);
		BlockPos clickedPos = blockPlaceContext.getClickedPos();
		ItemStack itemInHand = context.getItemInHand();
		Vec3 bottomCenter = Vec3.atBottomCenterOf(clickedPos);
		EntityType<NullsetEntity> nullsetEntityType = ECNUEntityTypes.NULLSET.get();
		AABB aabb = nullsetEntityType.getDimensions().makeBoundingBox(bottomCenter.x(), bottomCenter.y(), bottomCenter.z());
		if (level.noCollision(null, aabb) && level.getEntities(null, aabb).isEmpty()) {
			if (level instanceof ServerLevel serverLevel) {
				NullsetEntity nullsetEntity = nullsetEntityType.create(
						serverLevel, itemInHand.getTag(),
						EntityType.createDefaultStackConfig(serverLevel, itemInHand, context.getPlayer()),
						clickedPos, MobSpawnType.SPAWN_EGG,
						true, true
				);
				if (nullsetEntity == null) {
					return InteractionResult.FAIL;
				}

				float yRot = Mth.wrapDegrees(context.getRotation() - 180.0F);
				nullsetEntity.moveTo(nullsetEntity.getX(), nullsetEntity.getY(), nullsetEntity.getZ(), yRot, 0.0F);
				serverLevel.addFreshEntityWithPassengers(nullsetEntity);
				nullsetEntity.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
			}

			itemInHand.shrink(1);
			return InteractionResult.sidedSuccess(level.isClientSide);
		}

		return InteractionResult.FAIL;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, level, components, isAdvanced);
		components.add(Component.translatable("item.ecnu.nullset.description").withStyle(ChatFormatting.YELLOW));
	}
}
