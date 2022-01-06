package com.nitasorteadora.bot.commands.teams;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.utils.TeamsArraysList;
import net.dv8tion.jda.api.Permission;

public class ClearTeams extends Command implements TeamsArraysList {
    public ClearTeams() {
        this.name = "clearteams";
        this.aliases = new String[] {"borrarteams"};
        this.help = "Vacía la lista de teams; Requiere permisos de Administrador";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        if (commandEvent.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            participantes.clear();
            team1.clear();
            team2.clear();
            team3.clear();
            team4.clear();
            team5.clear();
            team6.clear();
            team7.clear();
            team8.clear();
            team9.clear();
            team10.clear();
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " se han borrado los teams!").queue();
        } else {
            commandEvent.getChannel().sendMessage("Permisos insuficientes para ejecutar **Clearteams**").queue();
        }
    }
}
