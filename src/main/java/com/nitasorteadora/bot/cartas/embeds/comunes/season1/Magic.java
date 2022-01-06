package com.nitasorteadora.bot.cartas.embeds.comunes.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Magic implements EmbedHelper {
    public static void Magia(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Modder")
                .author("Magic")
                .emote("<:Magic:788433576848261130>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/871973224005640212/1elmodder.jpg")
                .dbName("CartaMagic.")
                .season(1)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }

    }
}
