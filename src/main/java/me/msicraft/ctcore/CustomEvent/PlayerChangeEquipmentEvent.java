package me.msicraft.ctcore.CustomEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlayerChangeEquipmentEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Player player;
    private final EquipmentSlot equipmentSlot;
    private final ItemStack beforeItemStack;
    private final ItemStack afterItemStack;

    public PlayerChangeEquipmentEvent(Player player, EquipmentSlot equipmentSlot, ItemStack beforeItemStack, ItemStack afterItemStack) {
        this.player = player;
        this.equipmentSlot = equipmentSlot;
        this.beforeItemStack = beforeItemStack;
        this.afterItemStack = afterItemStack;
    }

    public Player getPlayer() {
        return player;
    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

    public ItemStack getBeforeItemStack() {
        return beforeItemStack;
    }

    public ItemStack getAfterItemStack() {
        return afterItemStack;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

}
