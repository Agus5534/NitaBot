package com.nitasorteadora.bot.cartas.embeds.comunes.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Xrayos implements EmbedHelper {
    public static void Rayos(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Tímido")
                .author("XRayos")
                .emote("<:Xrayos:821463211001118720>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/873422178471800862/1eltimido.jpg")
                .dbName("CartaXRayos.")
                .season(2)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }

    }
}
