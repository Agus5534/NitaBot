package com.nitasorteadora.bot.cumples.octubre;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SubXaso {
    public static void Sub(CommandEvent commandEvent){
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime tb = LocalDateTime.of(2021,10,15,0,0, 0);
        LocalDateTime tempDateTime = LocalDateTime.from(now);
        long meses = tempDateTime.until(tb, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths(meses);
        long dias = tempDateTime.until(tb, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays(dias);
        long horas = tempDateTime.until(tb, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours(horas);
        long minutos = tempDateTime.until(tb, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes(minutos);
        long segundos = tempDateTime.until(tb, ChronoUnit.SECONDS);

        if(now.isAfter(tb)) {
            final LocalDateTime now2 = LocalDateTime.now();
            final LocalDateTime tb2 = LocalDateTime.of(2022,10,15,0,0, 0);
            LocalDateTime tempDateTime2 = LocalDateTime.from(now2);
            long meses2 = tempDateTime2.until(tb2, ChronoUnit.MONTHS);
            tempDateTime2 = tempDateTime2.plusMonths(meses2);
            long dias2 = tempDateTime2.until(tb2, ChronoUnit.DAYS);
            tempDateTime2 = tempDateTime2.plusDays(dias2);
            long horas2 = tempDateTime2.until(tb2, ChronoUnit.HOURS);
            tempDateTime2 = tempDateTime2.plusHours(horas2);
            long minutos2 = tempDateTime2.until(tb2, ChronoUnit.MINUTES);
            tempDateTime2 = tempDateTime2.plusMinutes(minutos2);
            long segundos2 = tempDateTime2.until(tb2, ChronoUnit.SECONDS);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Cumples de Sub:");
            eb.setDescription(String.format("Faltan %s meses %s días %s horas %s minutos %s segundos",meses2,dias2,horas2,minutos2,segundos2));
            eb.setColor(Color.white);
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
        } else {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Cumples de Sub:");
            eb.setDescription(String.format("Faltan %s meses %s días %s horas %s minutos %s segundos",meses,dias,horas,minutos,segundos));
            eb.setColor(Color.white);
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
}
