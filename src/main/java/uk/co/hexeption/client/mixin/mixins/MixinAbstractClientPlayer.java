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

package uk.co.hexeption.client.mixin.mixins;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.co.hexeption.capeapi.CapesAPI;

import javax.annotation.Nullable;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer {

    @Shadow
    @Nullable
    protected abstract NetworkPlayerInfo getPlayerInfo();

    @Inject(method = "<init>", at = @At("RETURN"))
    private void AbstractPlayer(World worldIn, GameProfile playerProfile, CallbackInfo callbackInfo) {

        CapesAPI.loadCape(playerProfile.getId());
    }

    /**
     * @author
     */
    @Overwrite
    @Nullable
    public ResourceLocation getLocationCape() {

        if (CapesAPI.hasCape(getPlayerInfo().getGameProfile().getId())) {
            return CapesAPI.getCape(getPlayerInfo().getGameProfile().getId());
        } else {
            NetworkPlayerInfo networkplayerinfo = this.getPlayerInfo();
            return networkplayerinfo == null ? null : networkplayerinfo.getLocationCape();
        }
    }
}
