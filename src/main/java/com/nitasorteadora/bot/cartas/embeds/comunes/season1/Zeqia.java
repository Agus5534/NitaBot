package com.nitasorteadora.bot.cartas.embeds.comunes.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Zeqia implements EmbedHelper {
    public static void Zeq(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Mudo")
                .author("Zeqia")
                .emote("<:Soul:789624142739669044>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/872201507456548936/1elmudo.jpg")
                .dbName("CartaZeqia.")
                .season(1)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }

    }
}
