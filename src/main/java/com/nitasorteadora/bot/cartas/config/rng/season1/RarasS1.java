package com.nitasorteadora.bot.cartas.config.rng.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.embeds.raras.season1.Cneyer;
import com.nitasorteadora.bot.cartas.embeds.raras.season1.Cuchi;
import com.nitasorteadora.bot.cartas.embeds.raras.season1.Uimpi;

public class RarasS1 {
    public static void RarS1(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 96 + 1);
        if (random < 48) {
            Cuchi.Cuc(commandEvent);
        } else {
            if (random < 96) {
                Uimpi.Uim(commandEvent);
            } else {
                EpicasS1.EpicS1(commandEvent);
            }
        }
    }
}
