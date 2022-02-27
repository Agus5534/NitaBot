package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public class SendMessage extends SlashCommand {
    public static boolean sendMessageEnabled = true;
    public SendMessage() {
        this.name = "send";
        this.help = "Envia un mensaje en el chat de Minecraft";
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.STRING, "mensaje", "Mensaje a enviar en el servidor de Minecraft").setRequired(true));
        this.options = options;
    }
    @Override
    protected void execute(SlashCommandEvent event) {
        if(sendMessageEnabled) {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            if (scoreboard.getObjective("totalmins") != null) {
                Objective totalmins = scoreboard.getObjective("totalmins");
                if(totalmins.getScore("values").getScore() < 180) {
                    String mensaje = event.getOption("mensaje").getAsString();
                    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&8[&9Discord&8] &b"+event.getMember().getUser().getName() + "#"+event.getMember().getUser().getDiscriminator()+" &6"+mensaje.replace("&","")));
                    event.reply("Mensaje enviado!").setEphemeral(true).queue();
                } else {
                    event.reply("La partida ya ha pasado las 3 horas!").setEphemeral(true).queue();
                }
            } else {
                event.reply("Ha ocurrido un error al ejecutar este comando >.<").setEphemeral(true).queue();

            }
        } else {
            event.reply("Este comando está deshabilitado").setEphemeral(true).queue();
        }
    }
}
