/*
 * CraftBook Copyright (C) 2010-2017 sk89q <http://www.sk89q.com>
 * CraftBook Copyright (C) 2011-2017 me4502 <http://www.me4502.com>
 * CraftBook Copyright (C) Contributors
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package com.sk89q.craftbook.sponge.mechanics.ics.chips.world.miscellaneous;

import com.google.common.collect.Sets;
import com.sk89q.craftbook.sponge.mechanics.ics.IC;
import com.sk89q.craftbook.sponge.mechanics.ics.ICFactory;
import com.sk89q.craftbook.sponge.mechanics.ics.InvalidICException;
import com.sk89q.craftbook.sponge.util.SignUtil;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Set;

public class WirelessTransmitter extends IC {

    public static final Set<Tuple<String, String>> wirelessStates = Sets.newHashSet();

    private String wideband;
    private String shortband;

    private transient Tuple<String, String> cachedTuple;

    public WirelessTransmitter(ICFactory<WirelessTransmitter> icFactory, Location<World> block) {
        super(icFactory, block);
    }

    @Override
    public void create(Player player, List<Text> lines) throws InvalidICException {
        super.create(player, lines);

        if (SignUtil.getTextRaw(lines.get(2)).length() == 0) {
            throw new InvalidICException("A band must be supplied on the 3rd line!");
        }

        shortband = SignUtil.getTextRaw(lines.get(2));
        if (SignUtil.getTextRaw(lines.get(3)).length() == 0) {
            wideband = player.getUniqueId().toString();
        } else {
            wideband = SignUtil.getTextRaw(lines.get(3));
        }
    }

    public void load() {
        cachedTuple = new Tuple<>(shortband, wideband);
    }

    @Override
    public void trigger() {
        boolean enable = getPinSet().getInput(0, this);
        if (enable) {
            wirelessStates.add(cachedTuple);
        } else {
            wirelessStates.remove(cachedTuple);
        }
    }

    public static class Factory extends ICFactory<WirelessTransmitter> {

        @Override
        public WirelessTransmitter createInstance(Location<World> location) {
            return new WirelessTransmitter(this, location);
        }
    }
}
