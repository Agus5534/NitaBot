package com.nitasorteadora.bot.cartas.config.rng.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.embeds.comunes.season1.*;

public class ComunesS1 {
    public static void ComS1(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 330 + 1);
        if(random < 55) {
            Magic.Magia(commandEvent);
        } else {
            if (random < 110) {
                Maurito.Mauri(commandEvent);
            } else {
                if (random < 165) {
                    Zijhyan.Zij(commandEvent);
                } else {
                    if (random < 220) {
                        Evil.Evl(commandEvent);
                    } else {
                        RarasS1.RarS1(commandEvent);
                        }
                    }
                }
            }
        }
    }
