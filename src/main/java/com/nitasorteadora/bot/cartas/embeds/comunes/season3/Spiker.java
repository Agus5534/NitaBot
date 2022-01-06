package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Spiker implements EmbedHelper {
    public static void Spik(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Boomer")
                .author("Spiker")
                .emote("<:Spiker:864214891458986034>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/884575316805308436/1elboomer.jpg")
                .dbName("CartaSpiker.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
