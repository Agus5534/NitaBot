package com.nitasorteadora.bot.commands.extra;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.Main;
import com.nitasorteadora.bot.utils.sql.BlacklistManager;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeToS4 extends Command {
    private Main plugin;
    public TimeToS4(Main plugin) {
        this.plugin = plugin;
        this.name = "season4";
        this.aliases = new String[] {"s4", "tts4"};
        this.help = "¿¿¿???";
    }
    protected void execute(CommandEvent commandEvent) {
        BlacklistManager blacklistManager = new BlacklistManager(plugin.getConn(), commandEvent.getAuthor().getIdLong());
        try{
            if(blacklistManager.isBlacklisted()) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("No se pudo completar la acción");
                eb.setDescription("¡Estás en la lista negra!");
                eb.addField("Razón:", blacklistManager.getReason(), false);
                eb.addField("Desde:",String.valueOf(blacklistManager.getDate()),false);
                eb.addField("Autor:", blacklistManager.getAuthor(),false);
                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                return;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime s4 = LocalDateTime.of(2022,1,12,0,0, 0);
        LocalDateTime tempDateTime = LocalDateTime.from(now);
        long dias = tempDateTime.until(s4, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays(dias);
        long horas = tempDateTime.until(s4, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours(horas);
        long minutos = tempDateTime.until(s4, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes(minutos);
        long segundos = tempDateTime.until(s4, ChronoUnit.SECONDS);

        if(now.isAfter(s4)) {
            return;
        } else {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Season 4:");
            eb.setDescription(String.format("Faltan %s días %s horas %s minutos %s segundos",dias,horas,minutos,segundos));
            eb.setColor(Color.RED);
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
        }

    }
}
