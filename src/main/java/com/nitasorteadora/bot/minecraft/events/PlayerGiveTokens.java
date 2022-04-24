package com.nitasorteadora.bot.minecraft.events;

import com.nitasorteadora.bot.utils.PrizeManager;
import io.github.agus5534.uhcweekendlistener.events.player.PlayerGiveTokensEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerGiveTokens implements Listener {

    @EventHandler
    public void onTokens(PlayerGiveTokensEvent event) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if(scoreboard.getObjective("config.tokens").getScore("values").getScore() == 0){
            new PrizeManager().giveTokens(event.getRewarded(), event.getTokens());
            event.getRewarded().sendMessage(event.getReason());
        }
    }
}
