package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.nitasorteadora.bot.utils.cartashelper.SobresManager;
import com.nitasorteadora.bot.utils.cartashelper.SobresType;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

import java.awt.*;

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
            this.children = new SlashCommand[]{new Comun(),new Raro(), new Epico()};
        }
        @Override
        public void execute(SlashCommandEvent event) {
        }
        private class Comun extends SlashCommand{
            public Comun() {
                this.name = "comun";
                this.help = "Compra un sobre común";
            }
            @Override
            public void execute(SlashCommandEvent event) {
                if(new SobresManager().canBuy(SobresType.COMUN, event.getMember())) {
                    new SobresManager().giveSobre(SobresType.COMUN, event.getMember());
                    event.reply("Has comprado un sobre común correctamente").setEphemeral(true).queue();
                }
            }
        }
        private class Raro extends SlashCommand {
            public Raro() {
                this.name = "raro";
                this.help = "Compra un sobre raro";
            }
            @Override
            public void execute(SlashCommandEvent event) {
                if(new SobresManager().canBuy(SobresType.RARO, event.getMember())) {
                    new SobresManager().giveSobre(SobresType.RARO, event.getMember());
                    event.reply("Has comprado un sobre raro correctamente").setEphemeral(true).queue();
                }
            }
        }
        private class Epico extends SlashCommand {
            public Epico() {
                this.name = "epico";
                this.help = "Compra un sobre épico";
            }
            @Override
            public void execute(SlashCommandEvent event) {
                if(new SobresManager().canBuy(SobresType.EPICO, event.getMember())) {
                    new SobresManager().giveSobre(SobresType.EPICO, event.getMember());
                    event.reply("Has comprado un sobre épico correctamente").setEphemeral(true).queue();
                }
            }
        }
    }
    private class Open extends SlashCommand {
        public Open() {
            this.name = "abrir";
            this.help = "Abre un sobre";
            this.children = new SlashCommand[]{new Comun(), new Raro(), new Epico()};
        }
        @Override
        public void execute(SlashCommandEvent event) {
        }
        private class Comun extends SlashCommand{
            public Comun() {
                this.name = "comun";
                this.help = "Abre un sobre común";
            }
            @Override
            public void execute(SlashCommandEvent event) {
                new SobresManager().openSobre(SobresType.COMUN, event);
            }
        }
        private class Raro extends SlashCommand{
            public Raro() {
                this.name = "raro";
                this.help = "Abre un sobre raro";
            }
            @Override
            public void execute(SlashCommandEvent event) {
                new SobresManager().openSobre(SobresType.RARO, event);
            }
        }
        private class Epico extends SlashCommand {
            public Epico() {
                this.name = "epico";
                this.help = "Abre un sobre épico";
            }
            @Override
            public void execute(SlashCommandEvent event) {
                new SobresManager().openSobre(SobresType.EPICO, event);
            }
        }
    }
}
