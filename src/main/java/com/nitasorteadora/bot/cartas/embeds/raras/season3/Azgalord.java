package com.nitasorteadora.bot.cartas.embeds.raras.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Azgalord implements EmbedHelper {
    public static void Azga(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("La Tele")
                .author("Azga")
                .emote("<:Azgalord:879875183572287518>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/879874891472588860/1latele.jpg")
                .dbName("CartaAzga.")
                .season(3)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
