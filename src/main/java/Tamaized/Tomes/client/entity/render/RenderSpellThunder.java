package tamaized.tomes.client.entity.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

import java.util.Random;

/**
 * Original Code taken from Draconic Evolution with some edits, I don't claim to own this code
 */
public class RenderSpellThunder extends RenderEntity {

	public RenderSpellThunder(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	public static void drawBoltSegment(Tessellator tessellator, Vec3d p1, Vec3d p2, float scale, int color) {
		BufferBuilder buffer = tessellator.getBuffer();

		GlStateManager.pushMatrix();
		GlStateManager.translate(p1.x, p1.y, p1.z);

		double dist = p1.distanceTo(p2);
		float xd = (float) (p1.x - p2.x);
		float yd = (float) (p1.y - p2.y);
		float zd = (float) (p1.z - p2.z);
		double var7 = (double) MathHelper.sqrt((double) (xd * xd + zd * zd));
		float rotYaw = (float) (Math.atan2((double) xd, (double) zd) * 180.0D / 3.141592653589793D);
		float rotPitch = (float) (Math.atan2((double) yd, var7) * 180.0D / 3.141592653589793D);

		GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(180.0F + rotYaw, 0.0F, 0.0F, -1.0F);
		GlStateManager.rotate(rotPitch, 1.0F, 0.0F, 0.0F);
		GlStateManager.disableCull();

		buffer.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		for (int i = 0; i <= 9; i++) {
			float f = (i + 1F) / 9F;
			float verX = MathHelper.sin((float) (i % 3) * (float) Math.PI * 2F / (float) 3) * f * scale;
			float verZ = MathHelper.cos((float) (i % 3) * (float) Math.PI * 2F / (float) 3) * f * scale;

			float r = ((color >> 24) & 0xFF) / 255F;
			float g = ((color >> 16) & 0xFF) / 255F;
			float b = ((color >> 8) & 0xFF) / 255F;
			float a = ((color) & 0xFF) / 255F;
			buffer.pos(verX, dist, verZ).color(r, g, b, a).endVertex();
			buffer.pos(verX, 0, verZ).color(r, g, b, a).endVertex();
		}
		tessellator.draw();

		GlStateManager.enableCull();
		GlStateManager.popMatrix();
	}

	public static void renderBoltBetween(Vec3d point1, Vec3d point2, double scale, double maxDeflection, int maxSegments, int color) {
		Tessellator tessellator = Tessellator.getInstance();
		Random random = new Random();

		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200, 200);
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);

		double distance = point1.distanceTo(point2);
		Vec3d dirVec = new Vec3d(point2.x - point1.x, point2.y - point1.y, point2.z - point1.z);
		Vec3d invDir = new Vec3d(1, 1, 1).subtract(dirVec);

		Vec3d[] vectors = new Vec3d[maxSegments / 2 + random.nextInt(maxSegments / 2)];

		vectors[0] = point1;
		vectors[vectors.length - 1] = point2;

		for (int i = 1; i < vectors.length - 1; i++) {
			double pos = (i / (double) vectors.length) * distance;

			Vec3d point = new Vec3d(point1.x, point1.y, point1.z);
			point = point.add(new Vec3d(dirVec.x, dirVec.y, dirVec.z).scale(pos));

			double randX = (-0.5 + random.nextDouble()) * maxDeflection * invDir.x;
			double randY = (-0.5 + random.nextDouble()) * maxDeflection * invDir.y;
			double randZ = (-0.5 + random.nextDouble()) * maxDeflection * invDir.z;

			point = point.addVector(randX, randY, randZ);

			vectors[i] = point;
		}

		double rScale = scale * (0.5 + (random.nextDouble() * 0.5));
		for (int i = 1; i < vectors.length; i++) {
			drawBoltSegment(tessellator, vectors[i - 1], vectors[i], (float) rScale, color);
		}

		GlStateManager.disableBlend();
		GlStateManager.enableLighting();
		GlStateManager.enableTexture2D();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		Vec3d pos = new Vec3d(x, y, z);
		Vec3d dir = new Vec3d(0, 1, 0).rotatePitch((float) Math.toRadians(entity.prevRotationPitch + 90)).rotateYaw((float) Math.toRadians(entity.prevRotationYaw));
		renderBoltBetween(pos, pos.add(dir), 0.05f, 0.35f, 10, 0x264CFF4C);
	}
}
