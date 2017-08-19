package tamaized.tomes.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityThunder extends ProjectileBase {

	public EntityThunder(World worldIn) {
		super(worldIn);
	}

	public EntityThunder(World world, EntityPlayer caster) {
		super(world, caster, caster.posX, caster.posY, caster.posZ);
		setDamageRangeSpeedGravity(4, 10, 1, 0);
	}

	@Override
	protected boolean canHitEntity(Entity entity) {
		return entity != shootingEntity;
	}

	@Override
	protected DamageSource getDamageSource() {
		return DamageSource.causeIndirectMagicDamage(this, shootingEntity);
	}

	@Override
	protected float getDamageAmp(double damage, Entity shooter, Entity target) {
		return (float) damage;
	}

	@Override
	protected void arrowHit(EntityLivingBase entity) {
		entity.knockBack(this, 0.35f, -motionX, -motionZ);
	}
}
