package com.nitasorteadora.bot.cartas.embeds.epicas.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import net.dv8tion.jda.api.EmbedBuilder;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.randomLuck;

public class Celestial implements EmbedHelper {
    public static void Cel(CommandEvent commandEvent) {
        int cantcartas = 0;
        int total = 0;
        try {
            cantcartas = (int) cartasconfig.get("CartaCel." + commandEvent.getAuthor().getId(), cantcartas);
            total = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), total);
            total++;
            cartasconfig.set("Total."+commandEvent.getAuthor().getId(),total);
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("¡Carta diaria!");
        eb.setDescription("Obtuviste: **El Escandaloso** <:Celestial:795497092755095582>");
        eb.setThumbnail("https://cdn.discordapp.com/attachments/818995908779835393/835349972265205769/epico.png");
        eb.setImage("https://cdn.discordapp.com/attachments/818613273813319781/872308160877178890/1elescandaloso.jpg");
        eb.setFooter(epicas1footer);
        eb.setColor(colorepico);
        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            cantcartas++;
            cartasconfig.set("CartaCel." + commandEvent.getAuthor().getId(), cantcartas);
            int desbloqueadas = 0;
             if(cantcartas == 1) {
                desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + commandEvent.getAuthor().getId(), desbloqueadas);
                desbloqueadas++;
                cartasconfig.set("Desbloqueadas."+commandEvent.getAuthor().getId(),desbloqueadas);
            }
            cartasconfig.save(cartas);
            randomLuck(commandEvent);
        } catch (Exception e) {
            cartasconfig.set("Total." + commandEvent.getAuthor().getId(), total);
            cartasconfig.set("CartaCel." + commandEvent.getAuthor().getId(), cantcartas);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " agregando a la base de datos... (Vuelve a utilizar el comando)");
        }
    }
}
