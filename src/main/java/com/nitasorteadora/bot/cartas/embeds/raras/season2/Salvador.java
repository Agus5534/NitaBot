package com.nitasorteadora.bot.cartas.embeds.raras.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Salvador implements EmbedHelper {
    public static void Salvi(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Impaciente")
                .author("Salvi")
                .emote("<:Salvador:819332288759332864>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/873350979045711943/1elimpaciente.jpg")
                .dbName("CartaSalvi.")
                .season(2)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
