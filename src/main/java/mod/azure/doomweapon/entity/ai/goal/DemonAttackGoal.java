package mod.azure.doomweapon.entity.ai.goal;

import mod.azure.doomweapon.entity.DemonEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class DemonAttackGoal extends MeleeAttackGoal {
	private final DemonEntity zombie;
	private int raiseArmTicks;

	public DemonAttackGoal(DemonEntity zombieIn, double speedIn, boolean longMemoryIn) {
		super(zombieIn, speedIn, longMemoryIn);
		this.zombie = zombieIn;
	}

	public void startExecuting() {
		super.startExecuting();
		this.raiseArmTicks = 0;
	}

	public void resetTask() {
		super.resetTask();
		this.zombie.setAggroed(false);
	}

	public void tick() {
		super.tick();
		++this.raiseArmTicks;
		if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
			this.zombie.setAggroed(true);
		} else {
			this.zombie.setAggroed(false);
		}

	}
}