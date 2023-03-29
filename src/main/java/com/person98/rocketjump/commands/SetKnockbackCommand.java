package com.person98.rocketjump.commands;

import com.person98.rocketjump.Rocketjump;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetKnockbackCommand implements CommandExecutor {

    private final Rocketjump plugin;

    public SetKnockbackCommand(Rocketjump plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("fireworkknockback.setknockback")) {
                player.sendMessage("§cYou don't have permission to use this command.");
                return true;
            }
        }

        if (args.length != 1) {
            sender.sendMessage("§cUsage: /setknockback <intensity>");
            return true;
        }

        try {
            double intensity = Double.parseDouble(args[0]);
            plugin.getConfig().set("knockback-intensity", intensity);
            plugin.saveConfig();
            sender.sendMessage("§aKnockback intensity set to " + intensity + ".");
        } catch (NumberFormatException e) {
            sender.sendMessage("§cInvalid number format. Please enter a valid number.");
        }

        return true;
    }
}