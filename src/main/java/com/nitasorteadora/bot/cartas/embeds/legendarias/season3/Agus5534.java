package com.nitasorteadora.bot.cartas.embeds.legendarias.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import net.dv8tion.jda.api.EmbedBuilder;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.randomLuck2;

public class Agus5534 implements EmbedHelper {
    public static void Agus(CommandEvent commandEvent) {
        //Agus del futuro, de última hace la secreta ademas de esta
        int cantcartas = 0;
        int total = 0;
        try {
            cantcartas = (int) cartasconfig.get("CartaAgus5534." + commandEvent.getAuthor().getId(), cantcartas);
            total = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), total);
            total++;
            cartasconfig.set("Total."+commandEvent.getAuthor().getId(),total);
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("¡Carta diaria!");
        eb.setDescription("Obtuviste: **El Programador** <:Agus:873056466972581920>");
       eb.setThumbnail("https://cdn.discordapp.com/attachments/818995908779835393/835349989952978994/legendario.png");
        eb.setImage("https://cdn.discordapp.com/attachments/818613273813319781/884650845638103050/1elprogramador.jpg");
        eb.setFooter(legenss3footer);
        eb.setColor(colorlegendario);
        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            cantcartas++;
            cartasconfig.set("CartaAgus5534." + commandEvent.getAuthor().getId(), cantcartas);
            int desbloqueadas = 0;
             if(cantcartas == 1) {
                desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + commandEvent.getAuthor().getId(), desbloqueadas);
                desbloqueadas++;
                cartasconfig.set("Desbloqueadas."+commandEvent.getAuthor().getId(),desbloqueadas);
            }
            cartasconfig.save(cartas);
            randomLuck2(commandEvent);
        } catch (Exception e) {
            cartasconfig.set("Total." + commandEvent.getAuthor().getId(), total);
            cartasconfig.set("CartaAgus5534." + commandEvent.getAuthor().getId(), cantcartas);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " agregando a la base de datos... (Vuelve a utilizar el comando)");
        }
    }
}