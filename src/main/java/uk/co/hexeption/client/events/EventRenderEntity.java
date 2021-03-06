/*******************************************************************************
 *     Nitro Client
 *     Copyright (C) 2017  Hexeption (Keir Davis)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package uk.co.hexeption.client.events;

import me.zero.alpine.type.Cancellable;
import net.minecraft.entity.Entity;

public class EventRenderEntity extends Cancellable {

    private final Entity entity;

    private final double x, y, z;

    private final float yaw, ticks;

    public EventRenderEntity(Entity entity, double x, double y, double z, float yaw, float ticks) {

        this.entity = entity;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.ticks = ticks;
    }

    public Entity getEntity() {

        return entity;
    }

    public double getX() {

        return x;
    }

    public double getY() {

        return y;
    }

    public double getZ() {

        return z;
    }

    public float getYaw() {

        return yaw;
    }

    public float getTicks() {

        return ticks;
    }
}
