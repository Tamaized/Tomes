package tamaized.tomes.common.entity;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import tamaized.tammodized.common.helper.MotionHelper;

public class EntityThoron extends ProjectileBase {

	public EntityThoron(World worldIn) {
		super(worldIn);
	}

	public EntityThoron(World world, EntityPlayer caster) {
		super(world, caster, caster.posX, caster.posY, caster.posZ);
		setDamageRangeSpeedGravity(15, 64, 2.25f, 0);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		super.writeSpawnData(buffer);
		buffer.writeDouble(startingPoint.x);
		buffer.writeDouble(startingPoint.y);
		buffer.writeDouble(startingPoint.z);
	}

	@Override
	public void readSpawnData(ByteBuf data) {
		super.readSpawnData(data);
		startingPoint = new Vec3d(data.readDouble(), data.readDouble(), data.readDouble());
	}

	public Vec3d getStartingPoint() {
		return startingPoint;
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
		if (raytraceResultIn.entityHit == null) {
			setDead();
			return;
		}
		raytraceResultIn.entityHit.attackEntityFrom(getDamageSource(), getDamageAmp(getDamage(), shootingEntity, raytraceResultIn.entityHit));
		MotionHelper.addMotion(raytraceResultIn.entityHit, motionX, 1, motionZ);
	}

	@Override
	protected void arrowHit(EntityLivingBase entity) {

	}

}
