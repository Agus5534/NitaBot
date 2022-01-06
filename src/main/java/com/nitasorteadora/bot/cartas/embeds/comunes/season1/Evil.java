package com.nitasorteadora.bot.cartas.embeds.comunes.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Evil implements EmbedHelper {
    public static void Evl(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Dasher")
                .author("Evil")
                .emote("<:Evil:793945486109179904>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/872308037484945438/1eldasher.jpg")
                .dbName("CartaEvil.")
                .season(1)
                .esComun();
                try {
                    carta.build(commandEvent);
                } catch (CreateCardException e) {
                    e.printStackTrace();
                }
    }
}
