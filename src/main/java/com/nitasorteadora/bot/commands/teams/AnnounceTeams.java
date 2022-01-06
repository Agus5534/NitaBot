package com.nitasorteadora.bot.commands.teams;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.utils.TeamsArraysList;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;

import java.awt.*;

public class AnnounceTeams extends Command implements TeamsArraysList {
    public AnnounceTeams() {
        this.name = "announceteams";
        this.aliases = new String[] {"anunciarteams"};
        this.help = "Anuncia los teams; Requiere permisos de Administrador";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        String tm1 = team1.toString();
        tm1 = tm1.replace("[", "")
                .replace("]", "")
                .replace(" ", "");

        String tm2 = team2.toString();
        tm2 = tm2.replace("[", "")
                .replace("]", "")
                .replace(" ", "");

        String tm3 = team3.toString();
        tm3 = tm3.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String tm4 = team4.toString();
        tm4 = tm4.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String tm5 = team5.toString();
        tm5 = tm5.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String tm6 = team6.toString();
        tm6 = tm6.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String tm7 = team7.toString();
        tm7 = tm7.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String tm8 = team8.toString();
        tm8 = tm8.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String tm9 = team9.toString();
        tm9 = tm9.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String tm10 = team10.toString();
        tm10 = tm10.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        if (commandEvent.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            EmbedBuilder eb = new EmbedBuilder();
            if(team1.isEmpty() && team2.isEmpty() && team3.isEmpty() && team4.isEmpty() && team5.isEmpty() && team6.isEmpty() && team7.isEmpty() && team8.isEmpty() && team9.isEmpty() && team10.isEmpty()) {
                eb.setDescription("¿No has pensado en agregar a alguien?");
            }
          if(team1.size() >= 1) {
              eb.addField("Team 1:", tm1, true);
          }
          if(team2.size() >= 1) {
              eb.addField("Team 2:", tm2, true);
          }
          if(team3.size() >= 1){
              eb.addField("Team 3:", tm3, true);
          }
          if(team4.size() >= 1) {
              eb.addField("Team 4:", tm4, true);
          }
          if(team5.size() >= 1) {
              eb.addField("Team 5:", tm5, true);
          }
          if(team6.size() >= 1) {
              eb.addField("Team 6:", tm6, true);
          }
          if(team7.size() >= 1){
              eb.addField("Team 7:", tm7, true);
          }
          if(team8.size() >= 1){
              eb.addField("Team 8:", tm8, true);
          }
          if(team9.size() >= 1) {
              eb.addField("Team 9:", tm9, true);
          }
          if(team10.size() >= 1){
              eb.addField("Team 10:", tm10, true);
          }
            eb.setColor(Color.cyan);
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
        } else {
            commandEvent.getChannel().sendMessage("Permisos insuficientes para ejecutar **Announceteams**").queue();
        }

    }
}
