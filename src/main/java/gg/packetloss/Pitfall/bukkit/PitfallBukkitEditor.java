/*
 * Copyright (c) 2019 Wyatt Childers.
 *
 * This file is part of Pitfall.
 *
 * Pitfall is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Pitfall is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Pitfall.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package gg.packetloss.Pitfall.bukkit;

import gg.packetloss.Pitfall.PitfallEditor;
import gg.packetloss.Pitfall.Point;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.util.LinkedList;
import java.util.List;

public class PitfallBukkitEditor extends PitfallEditor<World, Material> {

    private List<BlockState> oldStates = new LinkedList<BlockState>();

    public PitfallBukkitEditor(World world) {
        super(world);
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getMaxY() {
        return getWorld().getMaxHeight();
    }

    @Override
    public boolean edit(Point pt, Material newType) {
        Block block = getWorld().getBlockAt(pt.getX(), pt.getY(), pt.getZ());
        oldStates.add(block.getState());
        block.setType(newType, true);
        return true;
    }

    @Override
    public Material getAt(Point pt) {
        Block block = getWorld().getBlockAt(pt.getX(), pt.getY(), pt.getZ());
        return block.getType();
    }

    @Override
    public void revertAll() {
        for (BlockState state : oldStates) {
            state.update(true);
        }
    }
}
