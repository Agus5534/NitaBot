package com.nitasorteadora.bot.cartas.embeds.comunes.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Zijhyan implements EmbedHelper {
    public static void Zij(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Mago Ingeniero")
                .author("Zijhyan")
                .emote("<:Zijhyan:788421732125507595>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/872201410341658674/1elingeniero.jpg")
                .dbName("CartaZij.")
                .season(1)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
       
    }
}
