package com.nitasorteadora.bot.cartas.config.rng.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.embeds.raras.Carmened;
import com.nitasorteadora.bot.cartas.embeds.raras.Fabo;
import com.nitasorteadora.bot.cartas.embeds.raras.season3.*;

public class RarasS3 {
    public static void RarS3(CommandEvent commandEvent){
        int random = (int) (Math.random() * 337 + 1);
        if(random < 48) {
            Heis.Hs(commandEvent);
        } else {
            if(random < 96) {
               Infernal.Infer(commandEvent);
            } else {
                if(random < 144) {
                    Azgalord.Azga(commandEvent);
                } else {
                    if(random < 192) {
                        Yuri.Yur(commandEvent);
                    } else {
                        if(random < 240) {
                            Mario.Mari(commandEvent);
                        } else {
                            if(random < 288) {
                                Fabo.Fabo(commandEvent);
                            } else if(random < 336) {
                                Carmened.Carmened(commandEvent);
                            } else {
                                LegendariasS3.LegS3(commandEvent);

                            }
                        }
                    }
                }
            }
        }
    }
}
