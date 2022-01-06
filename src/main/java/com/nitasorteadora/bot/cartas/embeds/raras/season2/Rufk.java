package com.nitasorteadora.bot.cartas.embeds.raras.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Rufk implements EmbedHelper {
    public static void ruf(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Inquieto")
                .author("Rufk")
                .emote("<:Rufk:819332353939210241>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/873422021311221800/1elinquieto.jpg")
                .dbName("CartaRufk.")
                .season(2)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
