package com.nitasorteadora.bot.cartas.embeds.raras.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Cneyer implements EmbedHelper {
    public static void Cnyr(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Aplanador")
                .author("Cneyer")
                .emote("<:Cneyer:800064014381482004>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/872308109375340554/1elaplanador.jpg")
                .dbName("CartaCneyer.")
                .season(1)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
}
}
