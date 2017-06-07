package Tamaized.Tomes.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityThunder extends ProjectileBase {

	public EntityThunder(World worldIn) {
		super(worldIn);
		setDamageRangeSpeed(4, 32, 0);
	}

	public EntityThunder(World world, EntityPlayer caster) {
		super(world, caster, caster.posX, caster.posY, caster.posZ);
	}

	@Override
	protected boolean canHitEntity(Entity entity) {
		return entity != shootingEntity;
	}

	@Override
	protected DamageSource getDamageSource() {
		return DamageSource.MAGIC;
	}

	@Override
	protected float getDamageAmp(double damage, Entity shooter, Entity target) {
		return (float) damage;
	}

	@Override
	protected void arrowHit(EntityLivingBase entity) {

	}
}
