package com.nitasorteadora.bot.cartas.embeds.comunes.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Gersoon implements EmbedHelper {
    public static void Ger(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Recopilador")
                .author("Geerson")
                .emote("<:Gersoon:819332227115647036>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/873350880475377735/1elrecopilador.jpg")
                .dbName("CartaGersoon.")
                .season(2)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
       
    }
}
