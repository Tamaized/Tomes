package Tamaized.Tomes.entity.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class RenderSpellElthunder extends RenderEntity {

	public RenderSpellElthunder(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		Vec3d pos = new Vec3d(x, y, z);
		Vec3d dir = new Vec3d(0, 1, 0).rotatePitch((float) Math.toRadians(entity.prevRotationPitch + 90)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw)).scale(2.5f);
		RenderSpellThunder.renderBoltBetween(pos, pos.add(dir), 0.05f, 0.35f, 4, 0xFFFF004C);
		GlStateManager.pushMatrix();
		{
			GlStateManager.disableTexture2D();
			GlStateManager.disableLighting();
			GlStateManager.enableBlend();
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200, 200);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);

			GlStateManager.translate(x, y, z);
			GlStateManager.color(1, 1, 0, 0.5f);
			GlStateManager.rotate(180.0F - renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate((float) (this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * -this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
			Tessellator tess = Tessellator.getInstance();
			BufferBuilder buffer = tess.getBuffer();
			buffer.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION);
			float scale = 0.2f;
			for (int i = 0; i < 360; i++) {
				buffer.pos(Math.cos(Math.toRadians(i)) * scale, Math.sin(Math.toRadians(i)) * scale, 0).endVertex();
			}
			tess.draw();
		}

		GlStateManager.disableBlend();
		GlStateManager.enableLighting();
		GlStateManager.enableTexture2D();

		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.popMatrix();
	}
}
