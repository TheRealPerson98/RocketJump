package com.person98.rocketjump;

import com.person98.rocketjump.commands.SetKnockbackCommand;
import com.person98.rocketjump.commands.ToggleRocketDamageCommand;
import com.person98.rocketjump.listeners.FireworkExplosionListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rocketjump extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("FireworkKnockback has been enabled.");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new FireworkExplosionListener(this), this);
        getCommand("setknockback").setExecutor(new SetKnockbackCommand(this));
        getCommand("togglerocketdamage").setExecutor(new ToggleRocketDamageCommand(this));

    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
