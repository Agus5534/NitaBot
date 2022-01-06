package com.nitasorteadora.bot.cartas.embeds.raras.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Infernal implements EmbedHelper {
    public static void Infer(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Loco")
                .author("Infernal")
                .emote("<:Infernal:864214891149262859>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/879874620407300096/1elloco.jpg")
                .dbName("CartaInfer.")
                .season(3)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
