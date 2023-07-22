package me.rexe0.admincheatprevention;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class CommandBroadcaster implements Listener {
    private String[] whitelistedCommands = {
            "/me", "/list", "/msg", "/tell", "/w", "/teammsg", "/tm", "/say"
    };

    @EventHandler
    public void onSendCommand(PlayerCommandPreprocessEvent e) {
        if (e.isCancelled()) return;
        if (!e.getPlayer().isOp()) return;
        String command = e.getMessage();

        // Check for whitelisted commands. Whitelisted commands shouldn't be broadcasted to everyone
        for (String str : whitelistedCommands)
            if (command.startsWith(str)) return;

        AdminCheatPrevention.broadcastMessage(e.getPlayer().getName()+" used the command: "+e.getMessage());
    }

    @EventHandler
    public void onSendCommand(ServerCommandEvent e) {
        if (e.isCancelled()) return;
        if (e.getSender() instanceof ConsoleCommandSender)
            AdminCheatPrevention.broadcastMessage("CONSOLE used the command: "+e.getCommand());
    }


    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e) {
        if (e.isCancelled()) return;
        if (e.getBlock().getType().toString().contains("COMMAND"))
            AdminCheatPrevention.broadcastMessage(e.getPlayer().getName()+" placed a command block.");
    }
}
