package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

import static com.nitasorteadora.bot.Main.cartasconfig;

public class Dbedit extends SlashCommand {
    public Dbedit() {
        this.name = "dbedit";
        this.help = "Edita la base de datos del bot";
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.STRING,"path","Database Path").setRequired(true));
        options.add(new OptionData(OptionType.INTEGER, "value","To set value (Integer)").setRequired(true));
        this.options = options;
    }
    @Override
    public void execute(SlashCommandEvent event){
        event.deferReply().queue();
        if(event.getMember().getId().equals("621875607839440916")) {
            String path = event.getOption("path").getAsString();
            long value = event.getOption("value").getAsLong();
            cartasconfig.set(path, value);
            event.getHook().sendMessage("Acción ejecutada!").setEphemeral(true).queue();

            try {
                cartasconfig.save(Main.cartas);
            } catch (Exception e) {
                event.getHook().sendMessage("No se ha podido guardar la base de datos!").setEphemeral(true).queue();
                e.printStackTrace();
            }
        } else {
            event.getHook().sendMessage("No tienes permisos para hacer esto").setEphemeral(true).queue();
        }
    }
}
