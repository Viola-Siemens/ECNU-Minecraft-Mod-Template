package org.ecnumc.ecnu.common.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.ecnumc.ecnu.common.registries.ECNUEntityTypes;

/**
 * Nullset Entity
 * @author liudongyu
 */
public class NullsetEntity extends PathfinderMob {
	/**
	 * Simple constructor
	 * @param level	the client/server level
	 */
	public NullsetEntity(Level level) {
		super(ECNUEntityTypes.NULLSET.get(), level);
	}
	/**
	 * Constructor
	 * @param level	the client/server level
	 */
	public NullsetEntity(EntityType<? extends NullsetEntity> entityType, Level level) {
		super(entityType, level);
	}

	/**
	 * Register goals for nullset entities.
	 */
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}

	/**
	 * Create attributes for nullset entities.
	 * @return	the attributes
	 */
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 50.0D).add(Attributes.MOVEMENT_SPEED, 0.3D);
	}
}
