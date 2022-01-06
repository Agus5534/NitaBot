package com.nitasorteadora.bot.commands.utils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import static com.nitasorteadora.bot.Main.accountsconfig;

public class LinkAccount extends Command {
    public static HashMap<UUID,String>uuidCodeMap = new HashMap<>();
    public static HashMap<UUID,String> uuidIdMap = new HashMap<>();
    public LinkAccount() {
        this.name = "linkaccount";
        this.help = "Linkea tu cuenta de Discord con la de Minecraft";
        this.aliases = new String[]{"la","linka","lacc","link","conectar"};
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        String[] message = commandEvent.getMessage().getContentRaw().split(" ");
        try {
            if (!accountsconfig.contains("Accounts.Discord." + commandEvent.getAuthor().getId())) {
                if (message[1] != null) {
                    Player target = Bukkit.getPlayer(message[1]);
                    if (target == null) {
                        commandEvent.getChannel().sendMessage("No he encontrado a ese usuario conectado en el servidor!").queue();
                    }  else {
                        String randomcode = new Random().nextInt(800000) + 200000 + "NB";
                        uuidCodeMap.put(target.getUniqueId(), randomcode);
                        uuidIdMap.put(target.getUniqueId(), commandEvent.getAuthor().getId());
                        try {
                            commandEvent.getAuthor().openPrivateChannel().complete().sendMessage("Tu código de verificación fue generado **(Recuerda no compartirlo con nadie)**!\n" +
                                    "Usa este comando en **minecraft** para verificar: ``/link " + randomcode + "``").queue();
                        } catch (Exception e) {
                            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " no puedo mandarte mensajes privados! Revisa si me tienes bloqueado o Mensajes Directos apagados").queue();
                        }
                    }
                } else {
                    commandEvent.getChannel().sendMessage("Uso: w!link [Username]").queue();
                }
            } else {
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ya te has linkeado con este username!").queue();
            }
        } catch (IndexOutOfBoundsException e){
            commandEvent.getChannel().sendMessage("Uso: w!link [Username]").queue();
        }
    }

}
