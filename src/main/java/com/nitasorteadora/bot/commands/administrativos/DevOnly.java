package com.nitasorteadora.bot.commands.administrativos;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.ConfigHandler;
import com.nitasorteadora.bot.JDAHandler;
import org.bukkit.Bukkit;

public class DevOnly extends Command {
    public DevOnly() {
        this.name = "devonly";
        this.aliases = new String[] {"devmode"};
        this.help = "Pon el bot en modo desarrollador!";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if (!ConfigHandler.getAdmins().contains(commandEvent.getAuthor().getId())) {
            return;
        } else {
            JDAHandler.devonly = !(JDAHandler.devonly);
            Bukkit.getLogger().severe(commandEvent.getAuthor().getName() + " (" + commandEvent.getAuthor().getId() + ") ha cambiado el estado de devonly!");
        }
    }
}
