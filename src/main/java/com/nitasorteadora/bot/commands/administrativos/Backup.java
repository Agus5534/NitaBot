package com.nitasorteadora.bot.commands.administrativos;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.ConfigHandler;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.Main;



public class Backup extends Command {
    public Backup() {
        this.name = "backup";
        this.ownerCommand = true;
        this.help = "Haz un backup de las cartas; Owner Command";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        if(!ConfigHandler.getAdmins().contains(commandEvent.getAuthor().getId())) {
            commandEvent.getChannel().sendMessage("No eres administrador del bot!").queue();
        } else {
            try {
                commandEvent.getChannel().sendMessage("Realizando Backup!").queue();
                    commandEvent.getJDA().getGuildById("754918107587543043").getTextChannelById("898314646170271774").sendMessage("cartas.yml:").addFile(Main.cartas).queue();
                commandEvent.getJDA().getGuildById("754918107587543043").getTextChannelById("898314646170271774").sendMessage("accounts.yml:").addFile(Main.accounts).queue();

                commandEvent.getChannel().sendMessage("¡Backup realizado, revisa <#898314646170271774>!").queue();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
