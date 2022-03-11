package com.nitasorteadora.bot.commands.administrativos;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;



public class Reload extends Command {
    private final ConfigHandler configHandler;
    public Reload(ConfigHandler configHandler) {
        this.name = "recargar";
        this.configHandler = configHandler;
        this.help = "Recarga al bot; Requiere el permiso BOT_MANAGER";
        this.aliases = new String[] {"reload"};
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        if(!ConfigHandler.getAdmins().contains(commandEvent.getAuthor().getId())) {
            commandEvent.getChannel().sendMessage("No eres administrador del bot!");
        } else {
        commandEvent.getChannel().sendMessage("Recargando config.yml").queue();
            commandEvent.getChannel().sendMessage("Recargando cartas.yml").queue();
            commandEvent.getChannel().sendMessage("Reload completado!").queue();
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "[Nita Bot] " + ChatColor.GREEN + "Config recargada");
        ConfigHandler.getLogger().severe(commandEvent.getAuthor().getName() + " (" + commandEvent.getAuthor().getId() + ") ha recargado la config del bot!");
        configHandler.reloadConfig();
        }
    }
}
