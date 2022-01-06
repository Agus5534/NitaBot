package com.nitasorteadora.bot.cartas.embeds.comunes.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Tamara1001 implements EmbedHelper {
    public static void Tamara(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("La Dedicada")
                .author("Tamara")
                .emote("<:Tamara:819338319921152000>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/873421903434485880/1ladedicada.jpg")
                .dbName("CartaTamara.")
                .season(2)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }

    }
}
