package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.nitasorteadora.bot.utils.cartashelper.SobresManager;
import com.nitasorteadora.bot.utils.cartashelper.SobresType;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sobres extends SlashCommand {
    public Sobres() {
        this.name = "sobres";
        this.help = "Gestiona tus sobres";
        this.children = new SlashCommand[]{new Costes(), new View(), new Buy(), new Open()};
    }
    @Override
    public void execute(SlashCommandEvent event) {
    }
    private class Costes extends SlashCommand {
        public Costes() {
            this.name = "costes";
            this.help = "Mira los costes de los sobres";
        }
        @Override
        public void execute(SlashCommandEvent event) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Costes");
            eb.addField("Sobre Común:", SobresType.COMUN.getCoste() +" tokens", true);
            eb.addField("Sobre Raro:",SobresType.RARO.getCoste() +" tokens", true);
            eb.addField("Sobre Épico:",SobresType.EPICO.getCoste() +" tokens", true);
            eb.setColor(Color.CYAN);
            eb.setFooter("Estos precios pueden variar");
            event.replyEmbeds(eb.build()).setEphemeral(true).queue();
        }
    }
    private class View extends SlashCommand {
        public View() {
            this.name = "view";
            this.help = "Ve tu inventario de sobres";
        }
        @Override
        public void execute(SlashCommandEvent event) {
            Member member = event.getMember();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Tus sobres:");
            eb.setColor(Color.ORANGE);
            eb.addField("Sobres Comunes:", new SobresManager().getCountString(SobresType.COMUN, member),true);
            eb.addField("Sobres Raros:", new SobresManager().getCountString(SobresType.RARO, member),true);
            eb.addField("Sobres Épicos:", new SobresManager().getCountString(SobresType.EPICO, member),true);
            event.replyEmbeds(eb.build()).setEphemeral(true).queue();
        }
    }
    private class Buy extends SlashCommand {
        public Buy() {
            this.name = "comprar";
            this.help = "Compra sobres";
            List<OptionData> options = new ArrayList<>();
            OptionData sobrestype = new OptionData(OptionType.STRING,"sobre","El tipo de sobre que comprarás").setRequired(true);
            sobrestype.addChoice("Común","Común");
            sobrestype.addChoice("Raro","Raro");
            sobrestype.addChoice("Épico","Épico");
            options.add(sobrestype);
            options.add(new OptionData(OptionType.INTEGER,"cantidad","Cantidad de sobres que comprarás").setRequired(true));
            this.options = options;
            //this.children = new SlashCommand[]{new BuyComun(),new BuyRaro(), new BuyEpico()};
        }
        @Override
        public void execute(SlashCommandEvent event) {
            String option = event.getOption("sobre").getAsString();
            long cant = event.getOption("cantidad").getAsLong();
            switch (option){
                case "Común":
                    if(new SobresManager().canBuy(SobresType.COMUN,event.getMember(),cant)) {
                        new SobresManager().giveSobre(SobresType.COMUN, event.getMember(), cant);
                        event.reply("Has comprado un sobre común correctamente").setEphemeral(true).queue();
                        break;
                    } else {
                        event.reply("No tienes suficientes tokens para comprar este sobre").setEphemeral(true).queue();
                        break;
                    }
                case "Raro":
                    if(new SobresManager().canBuy(SobresType.RARO, event.getMember(),cant)) {
                        new SobresManager().giveSobre(SobresType.RARO, event.getMember(),cant);
                        event.reply("Has comprado un sobre raro correctamente").setEphemeral(true).queue();
                        break;
                    } else {
                        event.reply("No tienes suficientes tokens para comprar este sobre").setEphemeral(true).queue();
                        break;
                    }
                case "Épico":
                    if(new SobresManager().canBuy(SobresType.EPICO, event.getMember(),cant)) {
                        new SobresManager().giveSobre(SobresType.EPICO, event.getMember(),cant);
                        event.reply("Has comprado un sobre épico correctamente").setEphemeral(true).queue();
                        break;
                    } else {
                        event.reply("No tienes suficientes tokens para comprar este sobre").setEphemeral(true).queue();
                        break;
                    }
            }

        }

    }
    private class Open extends SlashCommand {
        public Open() {
            this.name = "abrir";
            this.help = "Abre un sobre";
            List<OptionData> options = new ArrayList<>();
            OptionData sobrestype = new OptionData(OptionType.STRING,"sobre","El tipo de sobre que abriras").setRequired(true);
            sobrestype.addChoice("Común","Común");
            sobrestype.addChoice("Raro","Raro");
            sobrestype.addChoice("Épico","Épico");
            options.add(sobrestype);
            this.options = options;
           // this.children = new SlashCommand[]{new Comun(), new Raro(), new Epico()};
        }
        @Override
        public void execute(SlashCommandEvent event) {
            String option = event.getOption("sobre").getAsString();
            switch (option){
                case "Común":
                    new SobresManager().openSobre(SobresType.COMUN, event);
                    break;
                case "Raro":
                    new SobresManager().openSobre(SobresType.RARO, event);
                    break;
                case "Épico":
                    new SobresManager().openSobre(SobresType.EPICO, event);
                    break;
            }
        }

    }
}
