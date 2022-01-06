package com.nitasorteadora.bot.cartas.embeds.epicas.season1;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import net.dv8tion.jda.api.EmbedBuilder;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.randomLuck;

public class LuquiMC implements EmbedHelper {
    public static void Luqui(CommandEvent commandEvent) {
        int cantcartas = 0;
        int total = 0;
        try {
            cantcartas = (int) cartasconfig.get("CartaLuqui." + commandEvent.getAuthor().getId(), cantcartas);
            total = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), total);
            total++;
            cartasconfig.set("Total."+commandEvent.getAuthor().getId(),total);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("¡Carta diaria!");
            eb.setDescription("Obtuviste: **El Tranquilo** <:Luqui:851185434284916787>");
            eb.setThumbnail("https://cdn.discordapp.com/attachments/818995908779835393/835349972265205769/epico.png");
            eb.setImage("https://cdn.discordapp.com/attachments/818613273813319781/871973173573324840/1eltranquilo.jpg");
            eb.setFooter(epicas1footer);
            eb.setColor(colorepico);
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            cantcartas++;
            cartasconfig.set("CartaLuqui." + commandEvent.getAuthor().getId(), cantcartas);
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
            cartasconfig.set("CartaLuqui." + commandEvent.getAuthor().getId(), cantcartas);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " agregando a la base de datos... (Vuelve a utilizar el comando)");
        }
    }
}