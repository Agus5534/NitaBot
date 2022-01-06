package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class Flowii implements EmbedHelper {
    public static void Flowi(CommandEvent commandEvent){
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("La Cantante")
                .author("Flowii")
                .emote("<:Flowii:864240761573998593>")
                .image("https://cdn.discordapp.com/attachments/818613273813319781/884606533923639296/1lacantante.jpg")
                .dbName("CartaFlowii.")
                .season(3)
                .esComun();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
