package com.nitasorteadora.bot.cartas.embeds.raras;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Fabo {
    public static void Fabo(CommandEvent commandEvent) {

        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Asustadizo")
                .author("Fabo")
                .emote("<:Fabo:935644590680199179>")
                .image("https://cdn.discordapp.com/attachments/818995908779835393/936805180408733706/1elasustadizo.jpg")
                .dbName("CartaFabo.")
                .season(0)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
