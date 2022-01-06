package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class TatuRC implements EmbedHelper {
    public static void Tatu(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Boludo")
                .author("Tatu")
                .emote("<:Tatu:864214891249139772>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/879509809580367902/1elboludo.jpg")
                .dbName("CartaTatu.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
