package me.rexe0.admincheatprevention;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdminCheatPrevention extends JavaPlugin {
    private static final String PREFIX = ChatColor.GREEN+"[AdminCheatPrevention] "+ChatColor.WHITE;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CommandBroadcaster(), this);
    }


    public static void broadcastMessage(String message) {
        Bukkit.broadcastMessage(PREFIX+message);
    }


}
