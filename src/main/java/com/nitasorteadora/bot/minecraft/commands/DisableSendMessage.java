package com.nitasorteadora.bot.minecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.nitasorteadora.bot.slashcommands.SendMessage.sendMessageEnabled;

public class DisableSendMessage implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sendMessageEnabled){
            sendMessageEnabled = false;
        } else {
            sendMessageEnabled = true;
        }
        return true;
    }
}
