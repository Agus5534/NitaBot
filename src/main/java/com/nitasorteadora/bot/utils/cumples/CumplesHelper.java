package com.nitasorteadora.bot.utils.cumples;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CumplesHelper {
    final LocalDateTime now = LocalDateTime.now();
    private LocalDateTime cumple;
    private int dia;
    private int mes;
    private int year;
    private Color embedcolor;
    private String name;
    public CumplesHelper() {
        super();
    }
    public CumplesHelper fecha(int _dia, int _mes, int _year) {
        if(_dia > 31 || _dia <= 0) {
            throw new DateTimeException(String.format("No existe el día %s", _dia));
        } else if(_mes > 12 || mes <= 0) {
            throw new DateTimeException(String.format("No existe el mes %s", _mes));
        } else {
            year = _year;
            mes = _mes;
            dia = _dia;
        }
        return this;
    }
    public CumplesHelper nombre(String _name) {
        name = _name;
        return this;
    }
    public CumplesHelper embedColor(Color _embedcolor) {
        embedcolor = _embedcolor;
        return this;
    }
    public CumplesHelper build(CommandEvent commandEvent) {
            cumple = LocalDateTime.of(year,mes,dia,0,0, 0);
            if(now.isAfter(cumple)) {
                cumple = LocalDateTime.of(year + 1, mes, dia, 0, 0, 0);
            }
        LocalDateTime tempDateTime = LocalDateTime.from(now);
        long meses = tempDateTime.until(cumple, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths(meses);
        long dias = tempDateTime.until(cumple, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays(dias);
        long horas = tempDateTime.until(cumple, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours(horas);
        long minutos = tempDateTime.until(cumple, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes(minutos);
        long segundos = tempDateTime.until(cumple, ChronoUnit.SECONDS);


        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Cumples de "+ name);
        eb.setDescription(String.format("Faltan %s meses %s días %s horas %s minutos %s segundos",meses,dias,horas,minutos,segundos));
        eb.setColor(embedcolor);
        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();

        return this;
    }

}
