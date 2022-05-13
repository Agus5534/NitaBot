package com.nitasorteadora.bot.modalidades;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.nitasorteadora.bot.Main.*;

public class ModalidadManager {
    SlashCommandEvent event;
    Modalidades modalidades;

    public ModalidadManager(SlashCommandEvent event, Modalidades modalidades) {
        this.event = event;
        this.modalidades = modalidades;
    }


    public void addCard() {
        if(isUnlocked()) {
            cartasconfig.set("Modalidad.unlocked."+event.getMember().getId(),getUnlocked()+1);
            cartasconfig.set("Modalidad.streak."+event.getMember().getId(),0);
        } else {
            cartasconfig.set("Modalidad.streak."+event.getMember().getId(),getStreak()+1);
        }
        cartasconfig.set("Modalidad."+modalidades.getCodename()+"."+event.getMember().getId(),getCardCount()+1);

            new CooldownHelper().setCooldown(event.getMember().getIdLong());
            try {
                cartasconfig.save(cartas);
            } catch ( Exception e) {
                e.printStackTrace();
            }
            List<Modalidades> l = Arrays.asList(Modalidades.values());
            double percentage = (l.size() / 100) * getUnlocked();
        String pctage = new DecimalFormat("##.##").format(percentage);
            String message = "Tienes el "+pctage+"% desbloqueado.";
        if(getStreak() >= 5) {
            new CooldownHelper().removeCooldown(86400000, event.getMember().getIdLong());
            cartasconfig.set("Modalidad.streak."+event.getMember().getId(),0);
            message += " Racha de 5 repetidas, se ha ELIMINADO el cooldown.";
        } else if(getStreak() == 4) {
            new CooldownHelper().removeCooldown(new Random().nextInt(51120000), event.getMember().getIdLong());
            message += " Racha de 4 repetidas, se ha reducido el cooldown.";
        } else if(getStreak() == 3) {
            new CooldownHelper().removeCooldown(new Random().nextInt(26700000), event.getMember().getIdLong());
            message += " Racha de 3 repetidas, se ha reducido el cooldown.";
        } else if(getStreak() == 2) {
            new CooldownHelper().removeCooldown(new Random().nextInt(18000000), event.getMember().getIdLong());
            message += " Racha de 2 repetidas, se ha reducido el cooldown.";
        } else if(getStreak() == 1) {
            new CooldownHelper().removeCooldown(new Random().nextInt(5400000), event.getMember().getIdLong());
            message += " Racha de 1 repetida, se ha reducido el cooldown.";
        }
        try {
            cooldownsconfig.save(cooldowns);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //BUILD EMBED
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.CYAN);
        embedBuilder.setTitle("¡Obtuviste la modalidad: " + modalidades.getName() + "!");
        embedBuilder.setDescription(modalidades.getDescription());
        embedBuilder.setThumbnail(modalidades.getUrl());
        embedBuilder.setFooter(message);
        event.replyEmbeds(embedBuilder.build()).setEphemeral(true).queue();
    }



    private int getCardCount() {
        int num = 0;
        //QUITAR BETA EN LANZAMIENTO
        num = (int) cartasconfig.get("Modalidad."+modalidades.getCodename()+"."+event.getMember().getId(),num);
        return num;
    }
    private int getUnlocked() {
        int num = 0;
        num = (int) cartasconfig.get("Modalidad.unlocked."+event.getMember().getId(),num);
        return num;
    }
    private int getStreak() {
        int num = 0;
        num = (int) cartasconfig.get("Modalidad.streak."+event.getMember().getId(),num);
        return num;
    }

    private boolean isUnlocked() {
        if(getCardCount() == 0){
            return true;
        } else {
            return false;
        }
    }




}
