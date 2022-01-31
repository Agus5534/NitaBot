package com.nitasorteadora.bot.cartas.embeds.miticas;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.EmbedHelper;
import net.dv8tion.jda.api.EmbedBuilder;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.resetLuck;

public class NitaBot implements EmbedHelper {
    public static void NitaBot(CommandEvent commandEvent) {
        int cantcartas = 0;
        int total = 0;
        try {
            cantcartas = (int) cartasconfig.get("CartaNitaBot." + commandEvent.getAuthor().getId(), cantcartas);
            total = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), total);
            total++;
            cartasconfig.set("Total."+commandEvent.getAuthor().getId(),total);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("¡Carta diaria!");
            eb.setDescription("Obtuviste: **NitaBot** <:testemote:892895101527932991>");
            eb.setImage("https://cdn.discordapp.com/attachments/818995908779835393/892876959032414218/1nitabot.jpg");
            eb.setFooter(secretas3footer);
            eb.setColor(colorsecreto);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Hola! Me presento, soy Nita Sorteadora, un bot que fue creado por Panda, Nita y Agus5534, desarrollado por este último. Te cuento un poco sobre mí, un día, en el servidor de Discord de Lucmus, en el canal de staff, Lucmus le preguntó a Agus sobre lo de hacer bots porque necesitaba uno para sortear teams para el UHC Weekend. Agus aceptó y así nací... Tiempo después, Panda y Nita tenian ganas de hacer que las cartas de cada personaje, que estaban recien salidas, salgan en el bot mediante azar. Asi llegamos a hoy en día!").queue();
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            cantcartas++;
            cartasconfig.set("CartaNitaBot." + commandEvent.getAuthor().getId(), cantcartas);
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
            cartasconfig.set("CartaNitaBot." + commandEvent.getAuthor().getId(), cantcartas);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " agregando a la base de datos... (Vuelve a utilizar el comando)").queue();
        }
    }
}
