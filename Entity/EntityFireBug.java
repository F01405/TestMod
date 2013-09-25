package f01405.TestMod.Entity;

import f01405.TestMod.testMod;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityFireBug extends EntityMob {

	public EntityFireBug(World par1World) {
		super(par1World);
		this.experienceValue = 10;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.6D, false));
        this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

}
	protected boolean isAIEnabled() {
		return true;
	}
	
	  protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.23000000417232513D);
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.0D);
	    }
	
	protected String getHurtSound() {
		return "mob.zombie.hurt";
	}
	
	protected String getDeathSound() {
		return "mob.zombie.death";
	}
	
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.zombie.step", 0.15F, 1.0F);
	}
	
	protected int getDropItemId() {
		return testMod.chilli.itemID;
	}
	
	protected void dropRareDrop(int par1) {
		switch (this.rand.nextInt(3)) {
		case 0:
			this.dropItem(testMod.cupCake.itemID, 2);
			break;
		}
	}
	
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}
}
