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

package org.enginehub.craftbook.bukkit;

import com.sk89q.bukkit.util.CommandInspector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.extension.platform.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.enginehub.craftbook.util.TextUtil;
import org.enginehub.piston.CommandManager;
import org.enginehub.piston.inject.InjectedValueStore;
import org.enginehub.piston.inject.Key;
import org.enginehub.piston.inject.MapBackedValueStore;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class BukkitCommandInspector implements CommandInspector {
    private static final Logger LOGGER = LogManager.getLogger();

    private final CraftBookPlugin plugin;
    private final CommandManager dispatcher;

    public BukkitCommandInspector(CraftBookPlugin plugin, CommandManager dispatcher) {
        checkNotNull(plugin);
        checkNotNull(dispatcher);
        this.plugin = plugin;
        this.dispatcher = dispatcher;
    }

    @Override
    public String getShortText(Command command) {
        Optional<org.enginehub.piston.Command> mapping = dispatcher.getCommand(command.getName());
        if (mapping.isPresent()) {
            return TextUtil.reduceToText(mapping.get().getDescription(), WorldEdit.getInstance().getConfiguration().defaultLocale);
        } else {
            LOGGER.warn("BukkitCommandInspector doesn't know how about the command '" + command + "'");
            return "Help text not available";
        }
    }

    @Override
    public String getFullText(Command command) {
        Optional<org.enginehub.piston.Command> mapping = dispatcher.getCommand(command.getName());
        if (mapping.isPresent()) {
            return TextUtil.reduceToText(mapping.get().getFullHelp(), WorldEdit.getInstance().getConfiguration().defaultLocale);
        } else {
            LOGGER.warn("BukkitCommandInspector doesn't know how about the command '" + command + "'");
            return "Help text not available";
        }
    }

    @Override
    public boolean testPermission(CommandSender sender, Command command) {
        Optional<org.enginehub.piston.Command> mapping = dispatcher.getCommand(command.getName());
        if (mapping.isPresent()) {
            InjectedValueStore store = MapBackedValueStore.create();
            store.injectValue(Key.of(Actor.class), context -> Optional.of(plugin.wrapCommandSender(sender)));
            return mapping.get().getCondition().satisfied(store);
        } else {
            LOGGER.warn("BukkitCommandInspector doesn't know how about the command '" + command + "'");
            return false;
        }
    }
}
