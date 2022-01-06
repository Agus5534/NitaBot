package com.nitasorteadora.bot.cartas.embeds.secretas.season3;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import net.dv8tion.jda.api.EmbedBuilder;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.resetLuck;

public class LaEntidad implements EmbedHelper {
    public static void Entidad(CommandEvent commandEvent) {
        int cantcartas = 0;
        int total = 0;
        try {
            cantcartas = (int) cartasconfig.get("CartaLaEntidad." + commandEvent.getAuthor().getId(), cantcartas);
            total = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), total);
            total++;
            cartasconfig.set("Total."+commandEvent.getAuthor().getId(),total);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("¡Carta diaria!");
            eb.setDescription("Obtuviste: **La Entidad** <:testemote:892895101527932991>");
            eb.setImage("https://cdn.discordapp.com/attachments/818995908779835393/892876921438875648/1entidad.jpg");
            eb.setFooter(secretas3footer + " | Carta hecha por Zazil");
            eb.setColor(colorsecreto);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Y... You... Just.... NOOOOOOOOOOOOOOOOOOOO!").queue();
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            cantcartas++;
            cartasconfig.set("CartaLaEntidad." + commandEvent.getAuthor().getId(), cantcartas);
            int desbloqueadas = 0;
            if(cantcartas == 1) {
                desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + commandEvent.getAuthor().getId(), desbloqueadas);
                desbloqueadas++;
                cartasconfig.set("Desbloqueadas."+commandEvent.getAuthor().getId(),desbloqueadas);
            }
            cartasconfig.save(cartas);
            resetLuck(commandEvent);
        } catch (Exception e) {
            cartasconfig.set("Total." + commandEvent.getAuthor().getId(), total);
            cartasconfig.set("CartaLaEntidad." + commandEvent.getAuthor().getId(), cantcartas);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " agregando a la base de datos... (Vuelve a utilizar el comando)");
        }
    }
}
