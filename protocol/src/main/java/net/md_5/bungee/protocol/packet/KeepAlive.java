package net.md_5.bungee.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.md_5.bungee.protocol.AbstractPacketHandler;
import net.md_5.bungee.protocol.DefinedPacket;
import net.md_5.bungee.protocol.ProtocolConstants;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class KeepAlive extends DefinedPacket
{

    private long randomId;

    @Override
    public void read(ByteBuf buf, ProtocolConstants.Direction direction, int protocolVersion)
    {
        if ( protocolVersion >= ProtocolConstants.MINECRAFT_1_12_2 )
        {
            randomId = buf.readLong();
        } else if ( protocolVersion >= ProtocolConstants.MINECRAFT_1_8 )
        {
            randomId = readVarInt( buf );
        } else
        {
            randomId = buf.readInt();
        }
    }

    @Override
    public void write(ByteBuf buf, ProtocolConstants.Direction direction, int protocolVersion)
    {
        if ( protocolVersion >= ProtocolConstants.MINECRAFT_1_12_2 )
        {
            buf.writeLong( randomId );
        } else if ( protocolVersion >= ProtocolConstants.MINECRAFT_1_8 )
        {
            writeVarInt( (int) randomId, buf );
        } else
        {
            buf.writeInt( (int) randomId );
        }
    }

    @Override
    public void handle(AbstractPacketHandler handler) throws Exception
    {
        handler.handle( this );
    }
}
