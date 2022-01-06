package com.nitasorteadora.bot.commands.utils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.Main;
import com.nitasorteadora.bot.utils.VerControl;
import com.nitasorteadora.bot.utils.sql.BlacklistManager;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.sql.SQLException;
import java.util.Set;
import java.util.function.Consumer;

public class Comandos implements Consumer<CommandEvent> {
    private final Set<Command> commandSet;
    private Main plugin;
    public Comandos(Set<Command> commandSet, Main plugin){
        this.commandSet = commandSet;
        this.plugin = plugin;
    }
    @Override
    public void accept(CommandEvent event) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(event)) {
                return;
            }
        }
        BlacklistManager blacklistManager = new BlacklistManager(plugin.getConn(), event.getAuthor().getIdLong());
        try{
            if(blacklistManager.isBlacklisted()) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("No se pudo completar la acción");
                eb.setDescription("¡Estás en la lista negra!");
                eb.addField("Razón:", blacklistManager.getReason(), false);
                eb.addField("Desde:",String.valueOf(blacklistManager.getDate()),false);
                eb.addField("Autor:", blacklistManager.getAuthor(),false);
                event.getChannel().sendMessageEmbeds(eb.build()).queue();
                return;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        EmbedBuilder eb = new EmbedBuilder();
        for (Command command : commandSet) {
            eb.addField("w/" + command.getName(), command.getHelp(), false);
        }

            eb.setTitle("**Comandos:**");
            eb.setDescription("Prefix: **w/**");
            eb.setColor(Color.CYAN);
        VerControl vc = new VerControl();
            eb.setFooter(vc.getVersion() +" - Desarrollado por Agus5534");
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }



    }


