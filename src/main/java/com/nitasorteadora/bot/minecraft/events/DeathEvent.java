package com.nitasorteadora.bot.minecraft.events;

import io.github.agus5534.uhcweekendlistener.events.player.PlayerGiveTokensEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
@EventHandler
    public void onDeath(PlayerDeathEvent event) {
   if(event.getEntity().getKiller() instanceof Player) {
       Player player = event.getEntity().getKiller();
       PlayerGiveTokensEvent pgvt = new PlayerGiveTokensEvent(player, 2, "§aRecibiste 2 tokens por tu kill!");
       Bukkit.getPluginManager().callEvent(pgvt);
   }
}

}
