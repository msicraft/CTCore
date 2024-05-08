package me.msicraft.ctcore.Utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EntityUtil {

    public static int getPlayerEmptySlot(Player player) {
        int slot = -1;
        int size = 36;
        for (int a = 0; a<size; a++) {
            ItemStack itemStack = player.getInventory().getItem(a);
            if (itemStack == null) {
                slot = a;
                break;
            }

        }
        return slot;
    }

}
