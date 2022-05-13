package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.nitasorteadora.bot.ConfigHandler;
import com.nitasorteadora.bot.modalidades.CooldownHelper;
import com.nitasorteadora.bot.modalidades.ModalidadManager;
import com.nitasorteadora.bot.modalidades.Modalidades;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dailymod extends SlashCommand {
    public Dailymod() {
        this.name = "dailymod";
        this.help = "Obtiene una modalidad, una al día";
    }

    @Override
    public void execute(SlashCommandEvent event) {
        if(!ConfigHandler.getBetas().contains(event.getMember().getId())) {
            event.reply("No eres usuario beta!").setEphemeral(true).queue();
            return;
        }
        if(event.getChannel().getId().equals("889645049401450616")) {
            if(new CooldownHelper().hasCooldown(event.getMember().getIdLong())) {
                long ms = new CooldownHelper().getCooldownLong(event.getMember().getIdLong());
                final long milliseconds = ms - System.currentTimeMillis();
                final long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
                final long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds));
                final long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds));
                event.reply("Te queda: `" + (hours != 0 ? hours+" horas ":"") + (minutes != 0 ? minutes+" minutos ":"") + (seconds !=0 ? seconds+" segundos ":"") +"` de cooldown").setEphemeral(true).queue();
                return;
            } else {
                List<Modalidades> l = Arrays.asList(Modalidades.values());
                Collections.shuffle(l);
                Collections.shuffle(l);
                Collections.shuffle(l);
                Collections.shuffle(l);
                Collections.shuffle(l);
                Collections.shuffle(l,new Random(23002));
                new ModalidadManager(event,l.get(2)).addCard();
            }
        } else {
            event.reply("No se puede ejecutar el comando en este canal").setEphemeral(true).queue();
            return;
        }
    }
}
