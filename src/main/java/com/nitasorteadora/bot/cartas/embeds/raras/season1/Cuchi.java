package com.nitasorteadora.bot.cartas.embeds.raras.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Cuchi implements EmbedHelper {
    public static void Cuc(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("La Pequeña")
                .author("Cuchi")
                .emote("<:Cuchi:864245161993961473>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/871923636737564693/1lapequena.jpg")
                .dbName("CartaCuchi.")
                .season(1)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}