package com.nitasorteadora.bot.cartas.embeds.raras.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Heis implements EmbedHelper {
    public static void Hs(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Sicario")
                .author("Heis")
                .emote("<:Heis:864214891493326878>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/879509720266862662/1elsicario.jpg")
                .dbName("CartaHeis.")
                .season(3)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
