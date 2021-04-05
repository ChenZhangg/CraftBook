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

package org.enginehub.craftbook;

import java.util.HashMap;

@Deprecated
public class LanguageManager {

    public static final HashMap<String, String> defaultMessages = new HashMap<String, String>(32, 1.0f) {{
        put("area.permissions", "You don't have permissions to do that in this area!");
        put("area.use-permissions", "You don't have permissions to use that in this area!");
        put("area.break-permissions", "You don't have permissions to break that in this area!");


        put("mech.create-permission", "You don't have permission to create this mechanic.");
        put("mech.use-permission", "You don't have permission to use this mechanic.");
        put("mech.restock-permission", "You don't have permission to restock this mechanic.");
        put("mech.not-enough-blocks", "Not enough blocks to trigger mechanic!");
        put("mech.group", "You are not in the required group!");
        put("mech.restock", "Mechanism Restocked!");

        put("mech.anchor.create", "Chunk Anchor Created!");
        put("mech.anchor.already-anchored", "This chunk is already anchored!");

        put("mech.area.create", "Toggle Area Created!");
        put("mech.area.missing", "The area or namespace does not exist.");

        put("mech.bridge.create", "Bridge Created!");
        put("mech.bridge.toggle", "Bridge Toggled!");
        put("mech.bridge.end-create", "Bridge End Created!");
        put("mech.bridge.unusable", "Material not usable for a bridge!");
        put("mech.bridge.material", "Bridge must be made entirely out of the same material!");
        put("mech.bridge.other-sign", "Bridge sign required on other side (or it was too far away).");

        put("mech.cauldron.create", "Cauldron Created!");
        put("mech.cauldron.too-small", "Cauldron is too small!");
        put("mech.cauldron.leaky", "Cauldron has a leak!");
        put("mech.cauldron.no-lava", "Cauldron lacks lava!");
        put("mech.cauldron.legacy-not-a-recipe", "Hmm, this doesn't make anything...");
        put("mech.cauldron.legacy-not-in-group", "Doesn't seem as if you have the ability...");
        put("mech.cauldron.legacy-create", "In a poof of smoke, you've made");
        put("mech.cauldron.stir", "You stir the cauldron but nothing happens.");
        put("mech.cauldron.permissions", "You dont have permission to cook this recipe.");
        put("mech.cauldron.cook", "You have cooked the recipe:");

        put("mech.command.create", "Command Sign Created!");

        put("mech.command-items.out-of-sync", "Inventory became out of sync during usage of command-items!");
        put("mech.command-items.wait", "You have to wait %time% seconds to use this again!");
        put("mech.command-items.need", "You need %item% to use this command!");

        put("mech.cook.create", "Cooking Pot Created!");
        put("mech.cook.ouch", "Ouch! That was hot!");
        put("mech.cook.add-fuel", "You put fuel into the cooking pot, and watch as the fire roars!");

        put("mech.custom-crafting.recipe-permission", "You do not have permission to craft this recipe.");

        put("mech.door.create", "Door Created!");
        put("mech.door.toggle", "Door Toggled!");
        put("mech.door.other-sign", "Door sign required on other side (or it was too far away).");
        put("mech.door.unusable", "Material not usable for a door!");
        put("mech.door.material", "Door must be made entirely out of the same material!");

        put("mech.gate.create", "Gate Created!");
        put("mech.gate.toggle", "Gate Toggled!");
        put("mech.gate.not-found", "Failed to find a gate!");
        put("mech.gate.valid-item", "Line 1 needs to be a valid block id.");
        put("mech.dgate.create", "Small Gate Created!");

        put("mech.hiddenswitch.key", "The key did not fit!");
        put("mech.hiddenswitch.toggle", "You hear the muffled click of a switch!");

        put("mech.map.create", "Map Changer Created!");
        put("mech.map.invalid", "Invalid Map ID!");

        put("mech.pay.create", "Pay Created!");
        put("mech.pay.success", "Payment Successful! You paid: ");
        put("mech.pay.not-enough-money", "Payment Failed! You don't have enough money.");
        put("mech.pay.failed-to-pay", "Payment Failed! The money failed to be exchanged.");

        put("mech.pistons.crush.created", "Piston Crush Mechanic Created!");
        put("mech.pistons.supersticky.created", "Piston Super-Sticky Mechanic Created!");
        put("mech.pistons.bounce.created", "Piston Bounce Mechanic Created!");
        put("mech.pistons.superpush.created", "Piston Super-Push Mechanic Created!");

        put("mech.teleport.create", "Teleporter Created!");
        put("mech.teleport.alert", "You Teleported!");
        put("mech.teleport.range", "Out of Range!");
        put("mech.teleport.sign", "There is no Sign at your Destination!");
        put("mech.teleport.arriveonly", "You can only arrive at this teleporter!");
        put("mech.teleport.invalidcoords", "The entered coordinates are invalid!");
        put("mech.teleport.obstruct", "Your destination is obstructed!");

        put("mech.xp-storer.create", "XP Storer Created!");
        put("mech.xp-storer.bottle", "You need a bottle to perform this mechanic!");
        put("mech.xp-storer.success", "You package your experience into a bottle!");
        put("mech.xp-storer.not-enough-xp", "You do not have enough experience to fill a bottle!");


        put("circuits.pipes.create", "Pipe created!");
        put("circuits.pipes.pipe-not-found", "Failed to find pipe!");

        put("worldedit.ic.unsupported", "WorldEdit selection type currently unsupported for IC's!");
        put("worldedit.ic.notfound", "WorldEdit not found!");
        put("worldedit.ic.noselection", "No selection was found!");
    }};
}