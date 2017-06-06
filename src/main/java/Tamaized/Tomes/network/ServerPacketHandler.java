package Tamaized.Tomes.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.io.IOException;

public class ServerPacketHandler {

	public static int getPacketTypeID(PacketType type) {
		return type.ordinal();
	}

	public static PacketType getPacketTypeFromID(int id) {
		return id < PacketType.values().length ? PacketType.values()[id] : null;
	}

	public static void processPacket(ByteBuf parBB, Side parSide, EntityPlayerMP player) throws IOException {
		if (parSide == Side.SERVER) {
			ByteBufInputStream bbis = new ByteBufInputStream(parBB);
			switch (getPacketTypeFromID(bbis.readInt())) {
				case NULL: {
				}
				break;
				default:
					break;
			}
			bbis.close();
		}
	}

	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent event) {
		EntityPlayerMP player = ((NetHandlerPlayServer) event.getHandler()).playerEntity;
		player.getServer().addScheduledTask(new Runnable() {
			public void run() {
				try {
					processPacket(event.getPacket().payload(), Side.SERVER, player);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static enum PacketType {
		NULL
	}

}
