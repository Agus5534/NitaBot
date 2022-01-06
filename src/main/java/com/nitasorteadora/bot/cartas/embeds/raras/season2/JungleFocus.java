package com.nitasorteadora.bot.cartas.embeds.raras.season2;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class JungleFocus implements EmbedHelper {
    public static void Jungle(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Humilde")
                .author("Jungle")
                .emote("<:Jungle:834510259758301284>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/879509650477842492/1elhumilde.jpg")
                .dbName("CartaJungle.")
                .season(2)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
