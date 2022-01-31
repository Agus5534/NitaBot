package com.nitasorteadora.bot.cartas.config.rng.season1;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.embeds.epicas.season1.*;
import com.nitasorteadora.bot.cartas.embeds.epicas.season2.ConnG;
import com.nitasorteadora.bot.cartas.embeds.epicas.season2.Rufk;

public class EpicasS1 {
    public static void EpicS1(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 64 + 1);
        if(random < 7){
            Nita.Nt(commandEvent);
        } else {
            if(random < 14) {
                TheBoyPanda.Panda(commandEvent);
            } else {
                if (random < 21) {
                    SubXaso.Sub(commandEvent);
                } else {
                    if (random < 28) {
                        AugusImperial.Augus(commandEvent);
                    } else {
                        if (random < 35) {
                            LuquiMC.Luqui(commandEvent);
                        } else {
                            if (random < 42) {
                                Ivoo.Ivo(commandEvent);
                            } else {
                                if (random < 49) {
                                    Iki.Ik(commandEvent);
                                } else {
                                    if (random < 56) {
                                        ConnG.Conn(commandEvent);
                                } else {
                                        if(random < 63) {
                                            Rufk.ruf(commandEvent);
                                        } else {
                                            LegendariasS1.LegS1(commandEvent);
                                        }
                               }
                           }
                        }
                      }
                     }
                   }
                }
            }
        }
    }