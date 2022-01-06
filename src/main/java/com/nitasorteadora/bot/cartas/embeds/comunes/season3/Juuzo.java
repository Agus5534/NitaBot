package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Juuzo implements EmbedHelper {
    public static void Juzo(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("La Inexperta")
                .author("Juzo")
                .emote("<:Juzo:864242052514578482>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/884606570997108746/1lainexperta.jpg")
                .dbName("CartaJuzo.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
