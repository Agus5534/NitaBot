package com.nitasorteadora.bot.cartas.config.rng.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.embeds.comunes.season2.Andrew;
import com.nitasorteadora.bot.cartas.embeds.comunes.season2.Gersoon;
import com.nitasorteadora.bot.cartas.embeds.comunes.season2.Tamara1001;
import com.nitasorteadora.bot.cartas.embeds.comunes.season2.Xrayos;

public class ComunesS2 {
    public static void ComS2(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 29 + 1);
        if(random < 7) {
            Gersoon.Ger(commandEvent);
        } else {
            if (random < 14) {
                Tamara1001.Tamara(commandEvent);
            } else {
                if (random < 21) {
                    Andrew.Andr(commandEvent);
                } else {
                    if (random < 28) {
                        Xrayos.Rayos(commandEvent);
                    } else {
                        RarasS2.RarS2(commandEvent);
                    }
                }
            }
        }
    }
}
