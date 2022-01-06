package com.nitasorteadora.bot.commands.cartas;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;

import java.time.LocalDate;

import static com.nitasorteadora.bot.Main.*;

public class Claim extends Command {
    public Claim() {
        this.name = "claimreward";
        this.aliases = new String[] {"cr","reclamar"};
        this.help = "Reclama tu recompensa";
        this.cooldown = 5;
        this.hidden = true;
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        final LocalDate now = LocalDate.now();
        final LocalDate tb = LocalDate.of(2021, 11, 21);


        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        if(now.isAfter(tb)) {
        commandEvent.getChannel().sendMessage("Este evento ya ha pasado :(").queue();
        } else if(now.isBefore(tb)) {
        commandEvent.getChannel().sendMessage("¡Todavía falta para este evento!").queue();
        } else if(now.isEqual(tb)) {
            if(!alreadyClaimed(commandEvent)) {
                claim(commandEvent);
            } else {
                commandEvent.getChannel().sendMessage("Ya has reclamado tu recompensa!").queue();
            }
        }

    }
    private boolean alreadyClaimed(CommandEvent commandEvent){
        if(!claimedconfig.contains("Aniversario.Sobre."+commandEvent.getAuthor().getId())) {
            return false;
        } else {
            return true;
        }
    }
    private void claim(CommandEvent commandEvent) {
        claimedconfig.set("Aniversario.Sobre."+commandEvent.getAuthor().getId(), true);
        cartasconfig.set("SobreAniversario."+commandEvent.getAuthor().getId(),1);
        commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Sobre reclamado! Para abrir usa **w!abrirsobre aniversario**").queue();

        save();
    }
    private void save() {
        try {
            claimedconfig.save(claimed);
            cartasconfig.save(cartas);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
