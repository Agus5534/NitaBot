package com.nitasorteadora.bot.cartas.config.rng.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.rng.season1.EpicasS1;
import com.nitasorteadora.bot.cartas.embeds.raras.season2.JungleFocus;
import com.nitasorteadora.bot.cartas.embeds.raras.season2.PatoLand;
import com.nitasorteadora.bot.cartas.embeds.raras.season2.Rufk;
import com.nitasorteadora.bot.cartas.embeds.raras.season2.Salvador;

public class RarasS2 {
    public static void RarS2(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 28 + 1);
        if (random < 7) {
            Salvador.Salvi(commandEvent);
        } else {
            if (random < 14) {
                Rufk.ruf(commandEvent);
            } else {
                if (random < 21) {
                    PatoLand.Pato(commandEvent);
                } else {
                    if(random < 28) {
                        JungleFocus.Jungle(commandEvent);
                    } else {
                        EpicasS1.EpicS1(commandEvent);
                    }
                }
            }
        }

    }
}
