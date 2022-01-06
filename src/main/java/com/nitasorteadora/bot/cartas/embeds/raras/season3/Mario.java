package com.nitasorteadora.bot.cartas.embeds.raras.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Mario implements EmbedHelper {
    public static void Mari(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Pokemaníaco")
                .author("Mario")
                .emote("<:Mario:864214891283349505>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/884575253915926588/1elpokemaniaco.jpg")
                .dbName("CartaMario.")
                .season(3)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
