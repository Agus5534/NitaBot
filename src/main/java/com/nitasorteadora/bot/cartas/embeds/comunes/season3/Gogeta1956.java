package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;


public class Gogeta1956 implements EmbedHelper {
    public static void Goge(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Referencias")
                .author("Goge")
                .emote("<:Goge:864242052559667210>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/884606642707103814/1elreferencias.jpg")
                .dbName("CartaGoge.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
