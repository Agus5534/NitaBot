package com.nitasorteadora.bot.cartas.config.rng.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.embeds.comunes.season3.*;

public class ComunesS3 {
    public static void ComS3(CommandEvent commandEvent){
        int random = (int) (Math.random() * 56 + 1);
        if(random < 5) {
            TatuRC.Tatu(commandEvent);
        } else {
            if(random < 10) {
                CharlyDavid.Charly(commandEvent);
            } else {
                if(random < 15) {
                    MrComeGatos.ComeGatos(commandEvent);
                } else {
                    if(random < 20) {
                        Spiker.Spik(commandEvent);
                    } else {
                        if(random < 25){
                            StarrFallz.Starr(commandEvent);
                        } else {
                            if(random < 30) {
                                Flowii.Flowi(commandEvent);
                            } else {
                                if(random < 35) {
                                    Juuzo.Juzo(commandEvent);
                                } else {
                                    if(random < 40) {
                                        Gogeta1956.Goge(commandEvent);
                                    } else {
                                        if(random < 45) {
                                            Giantek.Gian(commandEvent);
                                        } else {
                                            if(random < 50) {
                                                SrLexan.Lexan(commandEvent);
                                            } else {
                                                if(random < 55) {
                                                    Ayden.Ayden(commandEvent);
                                                } else {
                                                    RarasS3.RarS3(commandEvent);
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
    }
}
