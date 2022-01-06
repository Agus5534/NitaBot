package com.nitasorteadora.bot.cartas.embeds.raras.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class PatoLand implements EmbedHelper {
    public static void Pato(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Discreto")
                .author("Pato")
                .emote("<:Pato:822562210554445845>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/873422071340884029/1eldiscreto.jpg")
                .dbName("CartaPato.")
                .season(2)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}