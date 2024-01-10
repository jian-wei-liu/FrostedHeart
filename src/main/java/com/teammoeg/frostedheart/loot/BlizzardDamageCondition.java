/*
 * Copyright (c) 2022 TeamMoeg
 *
 * This file is part of Frosted Heart.
 *
 * Frosted Heart is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * Frosted Heart is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Frosted Heart. If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.teammoeg.frostedheart.loot;

import javax.annotation.Nonnull;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.teammoeg.frostedheart.FHDamageSources;

import blusunrize.immersiveengineering.common.util.Utils;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class BlizzardDamageCondition implements ILootCondition {
    public static LootConditionType TYPE;

    public BlizzardDamageCondition() {
    }

    @SuppressWarnings("resource")
    @Override
    public boolean test(LootContext t) {
    	if(t.getLootTable(t.getQueriedLootTableId()).getParameterSet()==LootParameterSets.ENTITY) {
    		if(t.get(LootParameters.DAMAGE_SOURCE)==FHDamageSources.BLIZZARD) {
    			return true;
    		}
    	}
        return false;
    }

    @Override
    public LootConditionType getConditionType() {
        return TYPE;
    }

    public static class Serializer implements ILootSerializer<BlizzardDamageCondition> {

        @Override
        public void serialize(JsonObject jsonObject, BlizzardDamageCondition matchTagCondition, JsonSerializationContext serializationContext) {
        }

        @Nonnull
        @Override
        public BlizzardDamageCondition deserialize(JsonObject jsonObject, JsonDeserializationContext context) {
            return new BlizzardDamageCondition();
        }
    }
}
