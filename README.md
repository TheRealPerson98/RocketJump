## RocketJump
RocketJump is a Minecraft Bukkit/Spigot plugin that adds knockback to players when they are near firework explosions. It also provides commands to customize the knockback intensity and toggle damage from firework explosions.

# Features
Adds knockback to players when they are near firework explosions
Configurable knockback intensity
Command to set the knockback intensity
Command to toggle damage from firework explosions
Permissions support for commands
# Installation
Download the latest version of the RocketJump plugin.
Place the downloaded .jar file into your server's plugins folder.
Restart your server to load the plugin and generate the configuration file.
Optionally, customize the configuration file config.yml in the plugins/RocketJump folder.
Commands
/setknockback <intensity>: Sets the knockback intensity for firework explosions. Requires the rocketjump.setknockback permission (default: op).
/togglerocketdamage: Toggles damage from rocket explosions. Requires the rocketjump.togglerocketdamage permission (default: op).
# Configuration
The configuration file config.yml contains the following options:

knockback-intensity: The intensity of the knockback effect when players are near firework explosions (default: 1.5).
disable-rocket-damage: Whether to disable damage from rocket explosions (default: false).
# Permissions
rocketjump.setknockback: Allows setting the knockback intensity (default: op).
rocketjump.togglerocketdamage: Allows toggling rocket explosion damage (default: op).
#Compatibility
This plugin is compatible with Bukkit/Spigot servers for Minecraft 1.19 and above.