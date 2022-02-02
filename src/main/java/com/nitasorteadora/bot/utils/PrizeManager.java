package com.nitasorteadora.bot.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.io.IOException;

import static com.nitasorteadora.bot.Main.*;

public class PrizeManager {


    public boolean checkInGame() throws NullPointerException{
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective inGame = board.getObjective("inGame");
        Score inGameScore = inGame.getScore("values");
        Objective th = board.getObjective("th");
        Score thScore = th.getScore("values");
        if(inGameScore.getScore() == 1 && thScore.getScore() >= 0 && thScore.getScore() <= 3){
            return true;
        } else{
            return false;
        }
    }

    public String getID(Player player) {
        String id = "0";
        id = (String) accountsconfig.get("Accounts.Minecraft."+player.getUniqueId(),id);
        return id;
    }
    public boolean checkPlayer(Player player) {
        if(player.getGameMode() == GameMode.SURVIVAL) {
            return true;
        } else {
            return false;
        }
    }
    private void save(){
        try {
            cartasconfig.save(cartas);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void giveTokens(Player player, int award){
        try {
            if(checkInGame() && checkPlayer(player)) {
                if(!getID(player).equalsIgnoreCase("0")){
                  int tokens = 0;
                  tokens = (int) cartasconfig.get("Tokens."+getID(player),tokens);
                  tokens = tokens + award;
                  cartasconfig.set("Tokens."+getID(player),tokens);
                  player.sendMessage(ChatColor.RED + "[Nita Bot]" + ChatColor.GOLD + " Recibiste "+award+" tokens");
                  save();
                }
            }
        } catch(NullPointerException e) {
            return;
        }
    }
}
