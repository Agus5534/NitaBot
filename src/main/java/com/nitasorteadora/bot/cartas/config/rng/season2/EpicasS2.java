package com.nitasorteadora.bot.cartas.config.rng.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.rng.season1.EpicasS1;
import com.nitasorteadora.bot.cartas.embeds.epicas.season2.ConnG;

public class EpicasS2 {
    public static void EpicS2(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 30 + 1);
        if(random <= 25) {
            ConnG.Conn(commandEvent);
            int random2 = (int) (Math.random() * 50 + 1);
            if(random2 == 38) {
                commandEvent.getChannel().sendMessage("Y ahí sale Conn otra vez, ¿Cuantas veces ha salido ya?").queue();
            }
        } else {
            EpicasS1.EpicS1(commandEvent);
        }

    }
}
