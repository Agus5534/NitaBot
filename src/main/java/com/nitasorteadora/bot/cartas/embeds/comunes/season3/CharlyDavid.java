package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class CharlyDavid implements EmbedHelper {
    public static void Charly(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El MultiEstilo")
                .author("Charly")
                .emote("<:Charly:864214891275223070>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/879875055620874301/1elmultiestilo.jpg")
                .dbName("CartaCharly.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }

    }
}
