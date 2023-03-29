package com.person98.rocketjump.commands;

import com.person98.rocketjump.Rocketjump;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleRocketDamageCommand implements CommandExecutor {

    private final Rocketjump plugin;

    public ToggleRocketDamageCommand(Rocketjump plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("fireworkknockback.togglerocketdamage")) {
                player.sendMessage("§cYou don't have permission to use this command.");
                return true;
            }
        }

        boolean currentStatus = plugin.getConfig().getBoolean("disable-rocket-damage");
        plugin.getConfig().set("disable-rocket-damage", !currentStatus);
        plugin.saveConfig();
        sender.sendMessage("§aRocket damage is now " + (!currentStatus ? "§cdisabled" : "§aenabled") + "§a.");
        return true;
    }
}