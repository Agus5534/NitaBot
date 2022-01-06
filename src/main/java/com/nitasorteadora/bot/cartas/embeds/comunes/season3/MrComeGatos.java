package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class MrComeGatos implements EmbedHelper {
    public static void ComeGatos(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Hayabusa")
                .author("MrComeGatos")
                .emote("<:MrComeGatos:864214891396726804>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/884575170243747880/1elhayabusa.jpg")
                .dbName("CartaMrComeGatos.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
