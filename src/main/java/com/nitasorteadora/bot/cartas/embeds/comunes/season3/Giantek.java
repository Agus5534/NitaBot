package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Giantek implements EmbedHelper {
    public static void Gian(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Pelotudo")
                .author("Giantek")
                .emote("<:Gian:866447180914884639>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/884606688206925864/1elpelotudo.jpg")
                .dbName("CartaGiantek.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
