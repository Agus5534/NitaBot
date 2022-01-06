package com.nitasorteadora.bot.minecraft.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
@EventHandler
    public void onDeath(PlayerDeathEvent event) {
   /* DiscordWebhook webhook = new DiscordWebhook(webhookURL);
    webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription(event.getDeathMessage()).setColor(Color.RED));
    try {
        webhook.execute();
    } catch (java.io.IOException e) {
        Bukkit.getLogger().severe(e.getStackTrace().toString());
    }*/

}

}
