package com.nitasorteadora.bot.minecraft.events;

import com.nitasorteadora.bot.utils.PrizeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
@EventHandler
    public void onDeath(PlayerDeathEvent event) {
   if(event.getEntity().getKiller() instanceof Player) {
       Player player = event.getEntity().getKiller();
        new PrizeManager().giveTokens(player, 3);
   }
}

}
