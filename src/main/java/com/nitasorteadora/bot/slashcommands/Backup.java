package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class Backup extends SlashCommand {
    public Backup(){
        this.name = "backup";
        this.help = "Haz un backup";

    }
    @Override
    public void execute(SlashCommandEvent event) {
        if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
            event.getJDA().getGuildById("754918107587543043").getTextChannelById("898314646170271774").sendMessage("accounts.yml:").addFile(Main.accounts).queue();
            event.getJDA().getGuildById("754918107587543043").getTextChannelById("898314646170271774").sendMessage("cartas.yml:").addFile(Main.cartas).queue();
            event.reply("¡Backup realizado, revisa <#898314646170271774>!").setEphemeral(true).queue();

        } else {
            event.reply("No tienes permisos de hacer esto!").setEphemeral(true).queue();
        }
    }
}
