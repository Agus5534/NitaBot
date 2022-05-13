package com.nitasorteadora.bot.minecraft.events;

import com.nitasorteadora.bot.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    Main plugin;
    public JoinEvent(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
      /*  if(!accountsconfig.contains("Accounts.Minecraft."+player.getUniqueId().toString())) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,0.5f);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c[Nita Bot] &bNo estás verificado! Para verificar ve a comandos en el discord y pon &6w!link " + player.getName()));
            }, 1200L);
        }*/
    }
}
