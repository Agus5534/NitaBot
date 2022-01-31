package com.nitasorteadora.bot.cartas.config.rng.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.embeds.miticas.LaEntidad;
import com.nitasorteadora.bot.cartas.embeds.miticas.NitaBot;

public class SecretasS3 {
    public static void SecrS3(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);

        if(random < 50){
            NitaBot.NitaBot(commandEvent);
        } else {
            LaEntidad.Entidad(commandEvent);
        }
    }
}
