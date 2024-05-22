package me.msicraft.ctcore.Event;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import me.msicraft.ctcore.CTCore;
import me.msicraft.ctcore.CustomEvent.PlayerChangeEquipmentEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class EquipmentRelatedEvent implements Listener {

    private final CTCore plugin;

    public EquipmentRelatedEvent(CTCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerChangeArmor(PlayerArmorChangeEvent e) {
        Player player = e.getPlayer();
        ItemStack before = e.getOldItem();
        ItemStack after = e.getNewItem();

        EquipmentSlot equipmentSlot = null;

        PlayerArmorChangeEvent.SlotType slotType = e.getSlotType();
        switch (slotType) {
            case HEAD -> equipmentSlot = EquipmentSlot.HEAD;
            case CHEST -> equipmentSlot = EquipmentSlot.CHEST;
            case LEGS -> equipmentSlot = EquipmentSlot.LEGS;
            case FEET -> equipmentSlot = EquipmentSlot.FEET;
        }
        Bukkit.getPluginManager().callEvent(new PlayerChangeEquipmentEvent(player, equipmentSlot, before, after));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerChangeHandSlot(PlayerItemHeldEvent e) {
        Player player = e.getPlayer();

        ItemStack after = player.getInventory().getItem(e.getNewSlot());
        ItemStack before = player.getInventory().getItem(e.getPreviousSlot());

        Bukkit.getPluginManager().callEvent(new PlayerChangeEquipmentEvent(player, EquipmentSlot.HAND, before, after));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerSwapHand(PlayerSwapHandItemsEvent e) {
        Player player = e.getPlayer();

        ItemStack after = e.getOffHandItem();
        ItemStack before = e.getMainHandItem();

        Bukkit.getPluginManager().callEvent(new PlayerChangeEquipmentEvent(player, EquipmentSlot.OFF_HAND, before, after));
    }

}
