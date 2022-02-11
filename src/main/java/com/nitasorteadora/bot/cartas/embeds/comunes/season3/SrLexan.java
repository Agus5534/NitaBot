package com.nitasorteadora.bot.cartas.embeds.comunes.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.cartas.embeds.CartaC;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class SrLexan implements EmbedHelper {
    public static void Lexan(CommandEvent commandEvent) {
        CartaC carta = CartaC.SRLEXAN;
        CartasHelper embed = new CartasHelper(commandEvent,carta);
        embed.cardName(carta.getName())
                .author(carta.getAuthor())
                .emote(carta.getEmote())
                .image(carta.getImage())
                .dbName(carta.getDBName())
                .season(carta.getSeason());
        switch (carta.getCalidad()){
            case COMUN:
                embed.esComun();
                break;
            case RARA:
                embed.esRara();
                break;
            case EPICA:
                embed.esEpica();
                break;
            case LEGENDARIA:
                embed.esLegendaria();
                break;
            case MITICA:
                embed.esMitica();
                break;
            case SECRETA:
                embed.esSecreta();
                break;
        }
        try {
            embed.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
