package com.nitasorteadora.bot.cartas.embeds.comunes.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Soul implements EmbedHelper {
    public static void Sl(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Perdido")
                .author("Soul")
                .emote("<:Soul:789624142739669044>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/872307979532271676/1elperdido.jpg")
                .dbName("CartaSoul.")
                .season(1)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }

    }
}
