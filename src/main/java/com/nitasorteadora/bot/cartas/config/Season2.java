package com.nitasorteadora.bot.cartas.config;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.rng.season1.LegendariasS1;
import com.nitasorteadora.bot.cartas.config.rng.season2.ComunesS2;
import com.nitasorteadora.bot.cartas.config.rng.season2.EpicasS2;
import com.nitasorteadora.bot.cartas.config.rng.season2.RarasS2;

import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuck;

public class Season2 {

    public static void CartasS2(CommandEvent commandEvent) {
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
            ComunesS2.ComS2(commandEvent);
        } else if(random  < 85) {
            RarasS2.RarS2(commandEvent);
        } else if(random < 97) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 100) {
            LegendariasS1.LegS1(commandEvent);
        } else {
            Season3.CartasS3(commandEvent);
        }
    }
    private static void lucklvl2(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 40) {
            ComunesS2.ComS2(commandEvent);
        } else if(random  < 85) {
            RarasS2.RarS2(commandEvent);
        } else if(random < 97) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 100) {
            LegendariasS1.LegS1(commandEvent);
        } else {
            Season3.CartasS3(commandEvent);
        }
    }
    private static void lucklvl3(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 30) {
            ComunesS2.ComS2(commandEvent);
        } else if(random  < 75) {
            RarasS2.RarS2(commandEvent);
        } else if(random < 97) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 100) {
            LegendariasS1.LegS1(commandEvent);
        } else {
            Season3.CartasS3(commandEvent);
        }
    }
    private static void lucklvl4(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 30) {
            ComunesS2.ComS2(commandEvent);
        } else if(random  < 75) {
            RarasS2.RarS2(commandEvent);
        } else if(random < 92) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 100) {
            LegendariasS1.LegS1(commandEvent);
        } else {
            Season3.CartasS3(commandEvent);
        }
    }
    private static void lucklvl5(CommandEvent commandEvent){
        int random = (int) (Math.random() * 100 + 1);
        if(random < 20) {
            ComunesS2.ComS2(commandEvent);
        } else if(random  < 65) {
            RarasS2.RarS2(commandEvent);
        } else if(random < 89) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 100) {
            LegendariasS1.LegS1(commandEvent);
        } else {
            Season3.CartasS3(commandEvent);
        }
    }
    private static void lucklvl6(CommandEvent commandEvent){
        int random = (int) (Math.random() * 100 + 1);
        if(random < 15) {
            ComunesS2.ComS2(commandEvent);
        } else if(random  < 55) {
            RarasS2.RarS2(commandEvent);
        } else if(random < 80) {
            EpicasS2.EpicS2(commandEvent);
        } else if(random < 100) {
            LegendariasS1.LegS1(commandEvent);
        } else {
            Season3.CartasS3(commandEvent);
        }
    }
}
