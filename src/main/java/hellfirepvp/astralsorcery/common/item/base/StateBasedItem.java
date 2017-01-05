/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.common.item.base;

import net.minecraft.item.ItemStack;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: StateBasedItem
 * Created by HellFirePvP
 * Date: 07.05.2016 / 14:31
 */
public interface StateBasedItem {

    public ItemStack createItemFromState(ItemState state);

    public ItemState getState(ItemStack stack);

}
