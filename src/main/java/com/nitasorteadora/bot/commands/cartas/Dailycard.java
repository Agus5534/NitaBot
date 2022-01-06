package com.nitasorteadora.bot.commands.cartas;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.cartas.config.Season1;
import com.nitasorteadora.bot.cartas.config.Season2;
import com.nitasorteadora.bot.cartas.config.Season3;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static com.nitasorteadora.bot.utils.cartashelper.CooldownManager.*;
import static com.nitasorteadora.bot.utils.cartashelper.RemovedReset.resetdawe;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.checkLuck;

public class Dailycard extends Command {
    public Dailycard() {
        this.name = "dailycard";
        this.aliases = new String[] {"dc","dailycards", "cd","daylicard"};
        this.help = "Obten una carta al azar";
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
       if(commandEvent.getChannel().getId().equals("889645049401450616")) {
           if(!hasCooldown(commandEvent.getAuthor().getIdLong())) {
               setCooldown(commandEvent.getAuthor().getIdLong());
               checkLuck(commandEvent);
               resetdawe(commandEvent);
               int random = (int) (Math.random() * 100 + 1);
               if(random <= 37) {
                   Season1.CartasS1(commandEvent);
               } else {
                   if(random <= 74) {
                       Season2.CartasS2(commandEvent);
                   } else {
                       if(random <= 100) {
                           Season3.CartasS3(commandEvent);
                       }
                   }
               }
           } else {
               long ms = getCooldownLong(commandEvent.getAuthor().getIdLong());
               final long milliseconds = ms - System.currentTimeMillis();
               final long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
               final long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
                       - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds));
               final long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
                       - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds));
               EmbedBuilder eb = new EmbedBuilder();
               eb.setTitle("¡Todavía tienes cooldown!");
               eb.setDescription("Podras volver a usar este comando en " + (hours != 0 ? hours+" horas ":"") + (minutes != 0 ? minutes+" minutos ":"") + (seconds !=0 ? seconds+" segundos ":""));
               eb.setColor(Color.GREEN);
               commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
           }


        } else {
           commandEvent.getChannel().sendMessage("Solo se puede usar este comando en el canal <#889645049401450616>").queue();
       }
    }
}
