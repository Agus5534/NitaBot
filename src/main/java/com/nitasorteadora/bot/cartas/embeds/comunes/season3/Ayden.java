package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Ayden implements EmbedHelper {
    public static void Ayden(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Entusiasta")
                .author("Ayden")
                .emote("<:Ayden:895019810449158155>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/895150877919301652/1elentusiasta.jpg")
                .dbName("CartaAyden.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }

    }
}
