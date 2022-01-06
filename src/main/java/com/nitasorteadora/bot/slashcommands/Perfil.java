package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.nitasorteadora.bot.ConfigHandler;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.cartashelper.RemovedReset.resetdawe;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuckfortarget;

public class Perfil extends SlashCommand {
    public Perfil(){
        this.name = "perfil";
        this.help = "Ve tu perfil o el de alguien";
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.USER,"usuario","El usuario de quien quieres ver el perfil (opcional)").setRequired(false));
        this.options = options;
    }

    @Override
    public void execute(SlashCommandEvent event) {
        if(event.getOption("usuario") == null) {
            Member member = event.getMember();
            resetdawe(member);
            perfil(event, member);

        } else {
            Member member = event.getOption("usuario").getAsMember();
            resetdawe(member);
            perfil(event, member);

        }
    }
    private void perfil(SlashCommandEvent event, Member target) {
        event.deferReply().queue();
        String badges = "Usuario :pick: ";
        if (ConfigHandler.getBetas().contains(target.getId())) {
            badges = badges + "\n" + "Beta Tester :star: ";
        }
        if(ConfigHandler.getAdmins().contains(target.getId())) {
            badges = badges + "\n" + "Bot Co-Owner :gem: ";
        }
        if(target.getId().equalsIgnoreCase("621875607839440916")) {
            badges = badges + "\n" + "Bot Owner :crown: " + "\n" + "Bot Developer :wrench: ";
        }
        if(target.getId().equalsIgnoreCase("326879991629479936")) {
            badges = badges + "\n" + "Coleccionista Raro :sparkles: ";
        }
        if(target.getId().equalsIgnoreCase("223909547054465024")) {
            badges = badges + "\n" + "Coleccionista Épico :sparkles: ";
        }
        if(target.getId().equalsIgnoreCase("475432942215102465")) {
            badges = badges + "\n" + "Coleccionista Legendario :sparkles: ";
        }
        if(target.getId().equalsIgnoreCase("599632807299383316")) {
            badges = badges + "\n" + "Coleccionista Común :sparkles: ";
        }

        int totalidad = 0;
        int desbloqueadas = 0;
        int tokens = 0;
        totalidad = (int) cartasconfig.get("Total." + target.getId(), totalidad);
        desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + target.getId(), desbloqueadas);
        tokens = (int) cartasconfig.get("Tokens."+target.getId(),tokens);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Perfil de **" + target.getUser().getName() + "**:");
        eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
        //eb.addField("Discord:", "", false);
        //eb.addField("")
        eb.addField("Rango en el BOT:", badges, false);
        eb.addField("Estado:", estado(target), true);
        eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
        eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + "/47"), true);
        eb.addField("Tokens:", String.valueOf(tokens), true);
        eb.addField("Suerte:",luckidentifiertarget(target), true);
        eb.setThumbnail(target.getUser().getAvatarUrl());
        event.getHook().sendMessageEmbeds(eb.build()).queue();
    }
    private String estado(Member target) {
        String status = target.getOnlineStatus().toString();
        if(status.equalsIgnoreCase("DO_NOT_DISTURB")) {
            return "No Molestar";
        } else {
            if(status.equalsIgnoreCase("IDLE")) {
                return "Ausente";
            } else {
                if(status.equalsIgnoreCase("ONLINE")) {
                    return "Conectado";
                } else {
                    if(status.equalsIgnoreCase("OFFLINE")) {
                        return "Desconectado";
                    } else {
                        return "No se encontró";
                    }
                }
            }
        }
    }
    private String luckidentifiertarget(Member target) {
        if(getLuckfortarget(target) >= 1 && getLuckfortarget(target) <= 4) {
            return "Super Baja";
        } else if(getLuckfortarget(target) >=5 && getLuckfortarget(target) <=8) {
            return "Baja";
        } else if(getLuckfortarget(target) >= 9 && getLuckfortarget(target) <=12) {
            return "Normal";
        } else if(getLuckfortarget(target) >=13 && getLuckfortarget(target) <= 16) {
            return "Alta";
        } else if(getLuckfortarget(target) >= 17 && getLuckfortarget(target) <= 20){
            return "Super Alta";
        } else if(getLuckfortarget(target) >= 21) {
            return "Extremadamente Alta";
        } else {
            return "No se encontró";
        }
    }
}
