package com.person98.rocketjump.listeners;


import com.person98.rocketjump.Rocketjump;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class FireworkExplosionListener implements Listener {

    private final Rocketjump plugin;

    public FireworkExplosionListener(Rocketjump plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (plugin.getConfig().getBoolean("disable-rocket-damage") && event.getDamager() instanceof Firework && event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onFireworkHit(ProjectileHitEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Firework) {
            Firework firework = (Firework) entity;
            FireworkMeta fireworkMeta = firework.getFireworkMeta();
            if (fireworkMeta.hasEffects()) {
                for (Entity nearbyEntity : firework.getNearbyEntities(5.0, 5.0, 5.0)) {
                    if (nearbyEntity instanceof Player) {
                        Vector direction = nearbyEntity.getLocation().subtract(firework.getLocation()).toVector();
                        direction.normalize();
                        double knockbackIntensity = plugin.getConfig().getDouble("knockback-intensity");
                        direction.multiply(knockbackIntensity);
                        nearbyEntity.setVelocity(nearbyEntity.getVelocity().add(direction));
                    }
                }
            }
        }
    }
}