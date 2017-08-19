package tamaized.tomes.client.entity.render;

import tamaized.tomes.common.entity.EntityThoron;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class RenderSpellThoron extends RenderEntity {

	public RenderSpellThoron(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		if (!(entity instanceof EntityThoron))
			return;

		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200, 200);
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);

		Vec3d pos = new Vec3d(x, y, z);
		Vec3d dir = new Vec3d(0, MathHelper.clamp(((EntityThoron)entity).getStartingPoint().distanceTo(entity.getPositionVector()), 1, 8), 0).rotatePitch((float) Math.toRadians(entity.prevRotationPitch + 90)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw));
		RenderSpellThunder.drawBoltSegment(Tessellator.getInstance(), pos, pos.add(dir), 0.5f, 0xFFFF004C);

		GlStateManager.disableBlend();
		GlStateManager.enableLighting();
		GlStateManager.enableTexture2D();

		RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(0, 1, -1).rotatePitch((float) Math.toRadians(entity.prevRotationPitch)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw))), 0.05f, 0.35f, 10, 0xFFFF004C);
		RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(1, 1, -1).rotatePitch((float) Math.toRadians(entity.prevRotationPitch)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw))), 0.05f, 0.35f, 10, 0xFFFF004C);
		RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(1, 0, -1).rotatePitch((float) Math.toRadians(entity.prevRotationPitch)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw))), 0.05f, 0.35f, 10, 0xFFFF004C);
		RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(1, -1, -1).rotatePitch((float) Math.toRadians(entity.prevRotationPitch)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw))), 0.05f, 0.35f, 10, 0xFFFF004C);
		RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(0, -1, -1).rotatePitch((float) Math.toRadians(entity.prevRotationPitch)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw))), 0.05f, 0.35f, 10, 0xFFFF004C);
		RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(-1, -1, -1).rotatePitch((float) Math.toRadians(entity.prevRotationPitch)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw))), 0.05f, 0.35f, 10, 0xFFFF004C);
		RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(-1, 0, -1).rotatePitch((float) Math.toRadians(entity.prevRotationPitch)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw))), 0.05f, 0.35f, 10, 0xFFFF004C);
		RenderSpellThunder.renderBoltBetween(pos, pos.add(new Vec3d(-1, 1, -1).rotatePitch((float) Math.toRadians(entity.prevRotationPitch)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw))), 0.05f, 0.35f, 10, 0xFFFF004C);
	}
}
