package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.awt.*;

public class GameStats extends SlashCommand {

    public GameStats() {
        this.name = "gamestats";
        this.help = "Revisa el estado de la partida actual";
    }

    @Override
    public void execute(SlashCommandEvent event) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if(scoreboard.getObjective("inGame") != null) {
            Objective inGame = scoreboard.getObjective("inGame");
            if(inGame.getScore("values").getScore() == 1) {
                int vivos = 0;
                for(Player player : Bukkit.getOnlinePlayers()) {
                    if(player.getGameMode() == GameMode.SURVIVAL) {
                        vivos++;
                    }
                }
                Objective tt = scoreboard.getObjective("tt");
                Objective ts = scoreboard.getObjective("ts");
                Objective tm = scoreboard.getObjective("tm");
                Objective th = scoreboard.getObjective("th");
                Objective totalmins = scoreboard.getObjective("totalmins");
                Score ttScore = tt.getScore("values");
                Score tsScore = ts.getScore("values");
                Score tmScore = tm.getScore("values");
                Score thScore = th.getScore("values");
                Score ttmScore = totalmins.getScore("values");
                String tiempo = String.format("%02d", thScore.getScore()) + ":" + String.format("%02d",tmScore.getScore()) + ":" + String.format("%02d", tsScore.getScore());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("Estadísticas de la partida!");
                eb.addField("Tiempo:",tiempo,true);
                eb.addField("Vivos:", String.valueOf(vivos),true);
                eb.setColor(Color.cyan);
                event.replyEmbeds(eb.build()).queue();
            } else {
                event.reply("No hay una partida en curso!").queue();
            }
        }
    }

}
