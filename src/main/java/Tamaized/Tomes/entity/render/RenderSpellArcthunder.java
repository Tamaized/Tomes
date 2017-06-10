package Tamaized.Tomes.entity.render;

import Tamaized.Tomes.entity.EntityArcthunder;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class RenderSpellArcthunder extends RenderEntity {

	public RenderSpellArcthunder(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		if (entity == null || !(entity instanceof EntityArcthunder))
			return;
		Vec3d pos = new Vec3d(x, y, z);
		if (!((EntityArcthunder) entity).hasHit()) {
			Random rand = new Random();
			Vec3d dir = new Vec3d(0, 1, 0).rotatePitch((float) Math.toRadians(entity.prevRotationPitch + 90)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw)).scale(2.5f);
			RenderSpellThunder.renderBoltBetween(pos, pos.add(dir), 0.05f, 0.35f, 4, 0xFFFF004C);
			for (int i = 0; i < 5; i++) {
				RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(0, 1, 0).rotatePitch(rand.nextInt(360)).rotateYaw(rand.nextInt(360))), 0.05f, 0.35f, 8, 0xFFFF004C);
			}
		} else {
			RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(-1, 1, 0)), 0.05f, 0.35f, 10, 0xFFFF004C);
			RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(1, 1, 0)), 0.05f, 0.35f, 10, 0xFFFF004C);
			RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(0, 1, -1)), 0.05f, 0.35f, 10, 0xFFFF004C);
			RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(0, 1, 1)), 0.05f, 0.35f, 10, 0xFFFF004C);
			RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(-1, -1, 0)), 0.05f, 0.35f, 10, 0xFFFF004C);
			RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(1, -1, 0)), 0.05f, 0.35f, 10, 0xFFFF004C);
			RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(0, -1, -1)), 0.05f, 0.35f, 10, 0xFFFF004C);
			RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(0, -1, 1)), 0.05f, 0.35f, 10, 0xFFFF004C);
		}
	}
}
