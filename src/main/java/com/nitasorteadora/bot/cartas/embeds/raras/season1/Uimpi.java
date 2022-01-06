package com.nitasorteadora.bot.cartas.embeds.raras.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Uimpi implements EmbedHelper {
    public static void Uim(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("La Animadora")
                .author("Uimpi")
                .emote("<:Uimpi:799828322287747092>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/872201333636222976/1laanimadora.jpg")
                .dbName("CartaUimpi.")
                .season(1)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
