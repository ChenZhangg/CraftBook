/*
 * CraftBook Copyright (C) me4502 <https://matthewmiller.dev/>
 * CraftBook Copyright (C) EngineHub and Contributors <https://enginehub.org/>
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

package org.enginehub.craftbook.util;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.enginehub.craftbook.CraftBook;
import org.enginehub.craftbook.bukkit.CraftBookPlugin;

/**
 * Decorates bukkit's directional block power queries with a three-valued logic that differenciates
 * between the
 * wiring that is unpowered and the
 * absense of wiring.
 *
 * @author hash
 */
public final class RedstoneUtil {

    private RedstoneUtil() {
    }

    /**
     * Represents the power input state of a mechanism.
     */
    public enum Power {
        /**
         * No potential power source is connected. (This may cause a mechanism to either default to
         * its ON or OFF
         * behavior or do something else
         * entirely; it depends on the mechanism.
         */
        NA,
        /**
         * At least one potential power source is connected, and at least power source is on.
         */
        ON,
        /**
         * At least one potential power source is connected, but zero are on.
         */
        OFF
    }

    /**
     * @param mech
     * @param face
     * @return Power.ON if the block on mech's face is a potential power source and is powered;
     *     Power.Off if the
     *     block on mech's face is a potential
     *     power source but it is not providing power; Power.NA if there is no potential power
     *     source at the
     *     given face.
     */
    public static Power isPowered(Block mech, BlockFace face) {

        Block pow = mech.getRelative(face);

        if (CraftBookPlugin.isDebugFlagEnabled("redstone"))
            debug(pow);

        if (isPotentialPowerSource(mech, pow)) {
            if (pow.isBlockPowered() || pow.isBlockIndirectlyPowered()) return Power.ON;
            return Power.OFF;
        }
        return Power.NA;
    }

    /**
     * @return true if the pow block is a power conductor (in CraftBook, at this time we only
     *     consider this to be
     *     wires).
     */
    public static boolean isPotentialPowerSource(Material typeId) {

        return typeId == Material.REDSTONE_WIRE
            || typeId == Material.REPEATER
            || typeId == Material.LEVER
            || typeId == Material.REDSTONE_TORCH
            || typeId == Material.REDSTONE_WALL_TORCH
            || Tag.WOODEN_PRESSURE_PLATES.isTagged(typeId)
            || typeId == Material.STONE_PRESSURE_PLATE
            || typeId == Material.HEAVY_WEIGHTED_PRESSURE_PLATE
            || typeId == Material.LIGHT_WEIGHTED_PRESSURE_PLATE
            || typeId == Material.COMPARATOR
            || typeId == Material.REDSTONE_BLOCK;
    }

    public static boolean isPotentialPowerSource(Block pow) {

        return isPotentialPowerSource(pow.getType());
    }

    /**
     * @param mech
     * @param pow
     * @return true if a mechanism in the mech block is able to receive power from the pow block
     *     (i.e. if it's a
     *     power conductor and if it has a sense
     *     of directionality it is also pointing at mech).
     */
    public static boolean isPotentialPowerSource(Block mech, Block pow) {

        return isPotentialPowerSource(pow);
    }

    public static void debug(Block block) {

        CraftBook.logger.info("block " + block + " power debug:");
        CraftBook.logger.info("\tblock.isBlockPowered() : " + block.isBlockPowered());
        CraftBook.logger.info("\tblock.isBlockIndirectlyPowered() : " + block.isBlockIndirectlyPowered());
        for (BlockFace bf : BlockFace.values()) {
            CraftBook.logger.info("\tblock.isBlockFacePowered(" + bf + ") : " + block.isBlockFacePowered(bf));
            CraftBook.logger.info("\tblock.getFace(" + bf + ").isBlockPowered() : " + block.getRelative(bf)
                .isBlockPowered());
            CraftBook.logger.info("\tblock.isBlockFaceIndirectlyPowered(" + bf + ") : " + block
                .isBlockFaceIndirectlyPowered(bf));
            CraftBook.logger.info("\tblock.getFace(" + bf + ").isBlockIndirectlyPowered(" + bf + ") : "
                + block.getRelative(bf).isBlockIndirectlyPowered());
        }
        CraftBook.logger.info("");
    }
}