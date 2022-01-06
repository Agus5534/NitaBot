package com.nitasorteadora.bot.cartas.embeds.raras.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Yuri implements EmbedHelper {
    public static void Yur(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Varelense")
                .author("Yuri")
                .emote("<:Yuri:864214891538677780>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/879874807427104768/elvarelense.jpg")
                .dbName("CartaYuri.")
                .season(3)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
