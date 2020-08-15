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

package org.enginehub.craftbook.mechanics.ic.gates.logic;

import org.bukkit.Server;
import org.enginehub.craftbook.ChangedSign;
import org.enginehub.craftbook.mechanics.ic.AbstractIC;
import org.enginehub.craftbook.mechanics.ic.ChipState;
import org.enginehub.craftbook.mechanics.ic.ICFactory;

public abstract class SimpleTwoInputLogicGate extends AbstractIC {

    public SimpleTwoInputLogicGate(Server server, ChangedSign sign, ICFactory factory) {

        super(server, sign, factory);
    }

    @Override
    public void trigger(ChipState chip) {

        Boolean a = null;
        Boolean b = null;

        // New input handling: any/first two valid inputs discovered. Moar flexibility!
        for (short i = 0; i < chip.getInputCount(); i++) {
            if (chip.isValid(i)) {
                boolean pinval = chip.getInput(i);
                // Got pin value, assign to first free variable, break if got both.
                if (a == null) {
                    a = pinval;
                } else if (b == null) {
                    b = pinval;
                } else {
                    break;
                }
            }
        }

        if (a == null || b == null) return;

        chip.setOutput(0, getResult(a, b));
    }

    protected abstract boolean getResult(boolean a, boolean b);
}
