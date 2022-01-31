package com.nitasorteadora.bot.cartas.embeds.miticas;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;
import net.dv8tion.jda.api.EmbedBuilder;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.resetLuck;

public class NitaBot {
    public static void NitaBot(CommandEvent commandEvent) {
        CartasHelper carta = new CartasHelper(commandEvent);
        carta.cardName("NitaBot")
                .author("NitaBot")
                .emote("<:testemote:892895101527932991>")
                .image("https://cdn.discordapp.com/attachments/818995908779835393/892876959032414218/1nitabot.jpg")
                .dbName("CartaNitaBot.")
                .season(3)
                .esMitica();
        try {
            carta.build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
