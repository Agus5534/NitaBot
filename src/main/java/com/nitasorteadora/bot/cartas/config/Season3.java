package com.nitasorteadora.bot.cartas.config;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.rng.season2.EpicasS2;
import com.nitasorteadora.bot.cartas.config.rng.season3.ComunesS3;
import com.nitasorteadora.bot.cartas.config.rng.season3.LegendariasS3;
import com.nitasorteadora.bot.cartas.config.rng.season3.RarasS3;
import com.nitasorteadora.bot.cartas.config.rng.season3.SecretasS3;

import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuck;


public class Season3 {
    public static void CartasS3(CommandEvent commandEvent){
        if(getLuck(commandEvent) >= 0 && getLuck(commandEvent) <= 4) {
            lucklvl1(commandEvent);
        } else if(getLuck(commandEvent) >=5 && getLuck(commandEvent) <= 8) {
            lucklvl2(commandEvent);
        } else if(getLuck(commandEvent) >=9 && getLuck(commandEvent) <= 12) {
            lucklvl3(commandEvent);
        } else if(getLuck(commandEvent) >=13 && getLuck(commandEvent) <=16){
            lucklvl4(commandEvent);
        } else if(getLuck(commandEvent) >= 17 && getLuck(commandEvent) <=20) {
            lucklvl5(commandEvent);
        } else if(getLuck(commandEvent) >= 21) {
            lucklvl6(commandEvent);
        }

    }
    private static void lucklvl1(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 50) {
            ComunesS3.ComS3(commandEvent);
        } else if(random < 85) {
            RarasS3.RarS3(commandEvent);
        } else if(random < 96) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 99) {
            LegendariasS3.LegS3(commandEvent);
        } else if(random <= 100) {
            SecretasS3.SecrS3(commandEvent);
        } else {
            Season1.CartasS1(commandEvent);
        }

    }
    private static void lucklvl2(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 40) {
            ComunesS3.ComS3(commandEvent);
        } else if(random < 85) {
            RarasS3.RarS3(commandEvent);
        } else if(random < 96) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 99) {
            LegendariasS3.LegS3(commandEvent);
        } else if(random <= 100) {
            SecretasS3.SecrS3(commandEvent);
        } else {
            Season1.CartasS1(commandEvent);
        }
    }
    private static void lucklvl3(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 30) {
            ComunesS3.ComS3(commandEvent);
        } else if(random < 75) {
            RarasS3.RarS3(commandEvent);
        } else if(random < 96) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 99) {
            LegendariasS3.LegS3(commandEvent);
        } else if(random <= 100) {
            SecretasS3.SecrS3(commandEvent);
        } else {
            Season1.CartasS1(commandEvent);
        }
    }
    private static void lucklvl4(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 30) {
            ComunesS3.ComS3(commandEvent);
        } else if(random < 75) {
            RarasS3.RarS3(commandEvent);
        } else if(random < 92) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 98) {
            LegendariasS3.LegS3(commandEvent);
        } else if(random <= 100) {
            SecretasS3.SecrS3(commandEvent);
        } else {
            Season1.CartasS1(commandEvent);
        }
    }
    private static void lucklvl5(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 20) {
            ComunesS3.ComS3(commandEvent);
        } else if(random < 65) {
            RarasS3.RarS3(commandEvent);
        } else if(random < 89) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 97) {
            LegendariasS3.LegS3(commandEvent);
        } else if(random <= 100) {
            SecretasS3.SecrS3(commandEvent);
        } else {
            Season1.CartasS1(commandEvent);
        }
    }
    private static void lucklvl6(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 15) {
            ComunesS3.ComS3(commandEvent);
        } else if(random < 55) {
            RarasS3.RarS3(commandEvent);
        } else if(random < 80) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 96) {
            LegendariasS3.LegS3(commandEvent);
        } else if(random <= 100) {
            SecretasS3.SecrS3(commandEvent);
        } else {
            Season1.CartasS1(commandEvent);
        }
    }
}
