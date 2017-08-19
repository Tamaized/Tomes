package Tamaized.Tomes.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import tamaized.tammodized.common.helper.MotionHelper;

import java.util.List;

public class EntityArcthunder extends ProjectileBase {

	private static final DataParameter<Boolean> DATA_HIT = EntityDataManager.createKey(EntityArcthunder.class, DataSerializers.BOOLEAN);
	private int ticksLeft = 20 * 3;

	public EntityArcthunder(World worldIn) {
		super(worldIn);
	}

	public EntityArcthunder(World world, EntityPlayer caster) {
		super(world, caster, caster.posX, caster.posY, caster.posZ);
		setDamageRangeSpeedGravity(3, 32, 0.5f, 0);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(DATA_HIT, false);
	}

	public boolean hasHit() {
		return dataManager.get(DATA_HIT);
	}

	public void setHit(boolean b) {
		dataManager.set(DATA_HIT, b);
	}

	@Override
	public void onUpdate() {
		if (hasHit()) {
			if (world.isRemote)
				return;
			List<EntityLivingBase> list = world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(getPosition().add(-1, -1, -1), getPosition().add(1, 1, 1)));
			for (EntityLivingBase target : list) {
				if (target == shootingEntity)
					continue;
				MotionHelper.addMotion(target, (posX - target.posX) * 0.25, (posY - target.posY) * 0.25, (posZ - target.posZ) * 0.25);
				target.attackEntityFrom(getDamageSource(), (float) getDamage());
			}
			if (ticksLeft-- <= 0)
				setDead();
		} else
			super.onUpdate();
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
	protected void onHit(RayTraceResult raytraceResultIn) {
		if (world.isRemote)
			return;
		if (raytraceResultIn.entityHit == null) {
			setDead();
			return;
		}
		if (!hasHit())
			setHit(true);
	}

	@Override
	protected void arrowHit(EntityLivingBase entity) {

	}

}
