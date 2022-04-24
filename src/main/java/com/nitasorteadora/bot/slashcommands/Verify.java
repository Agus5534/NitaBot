package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static com.nitasorteadora.bot.Main.accountsconfig;

public class Verify extends SlashCommand {
    Main plugin;

    public static HashMap<UUID,String>uuidCodeMap = new HashMap<>();
    public static HashMap<UUID,String> uuidIdMap = new HashMap<>();
    public Verify(Main plugin) {
        this.plugin = plugin;
        this.name = "verificar";
        this.help = "Verificate en el bot y en el servidor!";
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.STRING,"usuario","Tu nombre en Minecraft para verificarte").setRequired(true));
        this.options = options;
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        String user = event.getOption("usuario").getAsString();
        if(event.getGuild().getId().equals("779862254807547926")) {
            if (!accountsconfig.contains("Accounts.Discord." + event.getMember().getId())) {
                OfflinePlayer target = Bukkit.getOfflinePlayer(user);
                if(target == null) {
                    event.reply("No se ha encontrado a ese usuario!").setEphemeral(true).queue();
                } else {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, ()-> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "whitelist add " + user), 10L);
                    String randomCode = getRandomAlphaNumeric(7);
                    uuidCodeMap.put(target.getUniqueId(), randomCode);
                    uuidIdMap.put(target.getUniqueId(), event.getMember().getId());
                    event.reply("Tu código de verificación fue generado y **recomiendo sacarle captura**\n Usa este comando dentro del servidor para verificarte: ``/link "+randomCode+"``").setEphemeral(true).queue();
                }
            } else {
                event.reply("Ya te has vinculado a otra cuenta! Si crees que es un error contacta a Agus5534").setEphemeral(true).queue();
            }
        } else {
            event.reply("Este comando no está disponible en este servidor").setEphemeral(true).queue();
        }
    }

    public String getRandomAlphaNumeric(int number) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        StringBuilder sb = new StringBuilder(number);

        for (int i = 0; i < number; i++) {


            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();

    }
}
