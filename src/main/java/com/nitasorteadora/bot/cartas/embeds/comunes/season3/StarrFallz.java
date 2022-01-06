package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class StarrFallz implements EmbedHelper {
    public static void Starr(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("La Indecisa")
                .author("Starr")
                .emote("<:Starrzfall:864216141685456956>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/884575359788535869/1laindecisa.jpg")
                .dbName("CartaStarr.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
