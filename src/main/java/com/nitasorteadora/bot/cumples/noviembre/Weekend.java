package com.nitasorteadora.bot.cumples.noviembre;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.utils.cumples.CumplesHelper;

import java.awt.*;

public class Weekend {
    public static void Weekend(CommandEvent commandEvent){
        CumplesHelper weekend = new CumplesHelper();
        weekend.fecha(22,11,2021).nombre("WEEKEND").embedColor(Color.GREEN).build(commandEvent);
    }
}
