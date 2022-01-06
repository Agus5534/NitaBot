package com.nitasorteadora.bot.cartas.embeds.comunes.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Andrew implements EmbedHelper {
    public static void Andr(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Amable")
                .author("Andrew")
                .emote("<:Andru:821367908063117403>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/873422116400283709/1elamable.jpg")
                .dbName("CartaAndrew.")
                .season(2)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }

    }
}
