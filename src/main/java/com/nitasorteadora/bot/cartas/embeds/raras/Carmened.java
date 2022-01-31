package com.nitasorteadora.bot.cartas.embeds.raras;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Carmened {
    public static void Carmened(CommandEvent commandEvent ){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("El Espontáneo")
                .author("Carmened")
                .emote("<:Carmened:935644590441107556>")
                .image("https://cdn.discordapp.com/attachments/818995908779835393/936805180731699230/1elespontaneo.jpg")
                .dbName("CartaCarmened.")
                .season(0)
                .esRara();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
