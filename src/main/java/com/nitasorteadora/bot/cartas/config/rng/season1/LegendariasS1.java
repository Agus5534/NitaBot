package com.nitasorteadora.bot.cartas.config.rng.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.Season3;
import com.nitasorteadora.bot.cartas.embeds.legendarias.season1.Lucmus;
import com.nitasorteadora.bot.cartas.embeds.legendarias.season1.Nyrem;

public class LegendariasS1 {
    public static void LegS1(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 16 + 1);

        if(random < 8) {
            Lucmus.Luc(commandEvent);
        } else {
        if (random <= 16) {
            Nyrem.Nyr(commandEvent);
            } else {
            Season3.CartasS3(commandEvent);
        }
    }
     }
    }

