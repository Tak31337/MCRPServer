/*
 *  Copyright (C) 2010 Furyhunter
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mcrpserver.packet.server;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import mcrpserver.packet.OpCode;
import mcrpserver.packet.Packet;

/**
 *
 * @author Furyhunter
 */
public class ServerPlayerTeleport extends Packet {

    private byte playerid;
    private short xpos;
    private short ypos;
    private short zpos;
    private byte heading;
    private byte pitch;

    public ServerPlayerTeleport(byte playerid, short x, short y, short z,
            byte heading, byte pitch) {
        this.id = OpCode.SERVER_PLAYER_TELEPORT;
        this.playerid = playerid;
        this.xpos = x;
        this.ypos = y;
        this.zpos = z;
        this.heading = heading;
        this.pitch = pitch;
    }

    @Override
    public byte[] build() {
        ByteBuffer pkt = ByteBuffer.allocate(10);
        pkt.order(ByteOrder.BIG_ENDIAN);

        // put id
        pkt.put((byte) id.id);

        // put player id
        pkt.put(playerid);

        // put x y z
        pkt.putShort(xpos);
        pkt.putShort(ypos);
        pkt.putShort(zpos);

        // put heading, pitch
        pkt.put(heading);
        pkt.put(pitch);

        return pkt.array();
    }
}
