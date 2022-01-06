package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class SrLexan implements EmbedHelper {
    public static void Lexan(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Distraído")
                .author("Lexan")
                .emote("<:Lexan:892154822277619722>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/892875761189519411/1eldistraido.jpg")
                .dbName("CartaLexan.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
