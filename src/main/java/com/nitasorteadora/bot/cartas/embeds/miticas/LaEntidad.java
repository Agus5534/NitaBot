package com.nitasorteadora.bot.cartas.embeds.miticas;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;
import net.dv8tion.jda.api.EmbedBuilder;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.resetLuck;

public class LaEntidad {
    public static void Entidad(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("La Entidad")
                .author("La Entidad")
                .emote("<:testemote:892895101527932991>")
                .image("https://cdn.discordapp.com/attachments/818995908779835393/892876921438875648/1entidad.jpg")
                .dbName("CartaLaEntidad.")
                .season(3)
                .esMitica();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
