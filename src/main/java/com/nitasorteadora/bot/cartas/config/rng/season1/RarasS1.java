package com.nitasorteadora.bot.cartas.config.rng.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.embeds.raras.season1.Cuchi;
import com.nitasorteadora.bot.cartas.embeds.raras.season1.Uimpi;
import com.nitasorteadora.bot.cartas.embeds.raras.season2.PatoLand;
import com.nitasorteadora.bot.cartas.embeds.raras.season2.Salvador;

public class RarasS1 {
    public static void RarS1(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 192 + 1);
        if (random < 48) {
            Cuchi.Cuc(commandEvent);
        } else {
            if (random < 96) {
                Uimpi.Uim(commandEvent);
            } else if (random < 144){
                Salvador.Salvi(commandEvent);
            } else if(random < 192) {
                PatoLand.Pato(commandEvent);
            } else {
                EpicasS1.EpicS1(commandEvent);
            }
        }
    }
}
