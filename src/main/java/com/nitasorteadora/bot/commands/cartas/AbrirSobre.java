package com.nitasorteadora.bot.commands.cartas;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.Main;
import com.nitasorteadora.bot.cartas.config.rng.season1.ComunesS1;
import com.nitasorteadora.bot.cartas.config.rng.season1.EpicasS1;
import com.nitasorteadora.bot.cartas.config.rng.season1.LegendariasS1;
import com.nitasorteadora.bot.cartas.config.rng.season1.RarasS1;
import com.nitasorteadora.bot.cartas.config.rng.season2.ComunesS2;
import com.nitasorteadora.bot.cartas.config.rng.season2.RarasS2;
import com.nitasorteadora.bot.cartas.config.rng.season3.ComunesS3;
import com.nitasorteadora.bot.cartas.config.rng.season3.LegendariasS3;
import com.nitasorteadora.bot.cartas.config.rng.season3.RarasS3;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

import static com.nitasorteadora.bot.Main.cartasconfig;

public class AbrirSobre extends Command {
    public AbrirSobre() {
        this.name = "abrirsobre";
        this.cooldown = 10;
        this.help = "Abre un sobre";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        int tokens = 0;
        String[] message = commandEvent.getMessage().getContentRaw().split(" ");
        if(cartasconfig.contains("Tokens."+commandEvent.getMessage().getAuthor().getId())) {
            checksobrecomun(commandEvent);
            checksobreraro(commandEvent);
            checksobreepico(commandEvent);
            int sc = 0;
            sc = (int) cartasconfig.get("SobreComun."+commandEvent.getMessage().getAuthor().getId(),sc);
            int sr = 0;
            sr = (int) cartasconfig.get("SobreRaro."+commandEvent.getMessage().getAuthor().getId(),sr);
            int se = 0;
            se = (int) cartasconfig.get("SobreEpico."+commandEvent.getMessage().getAuthor().getId(),se);
            int sa = 0;
            sa = (int) cartasconfig.get("SobreAniversario."+commandEvent.getMessage().getAuthor().getId(), sa);
            try {
                if(message[1].equalsIgnoreCase("comun")) {
                    if(sc >= 1) {
                        int mathcalc2 = sc - 1;
                        cartasconfig.set("SobreComun."+commandEvent.getAuthor().getId(),mathcalc2);
                        try {
                            cartasconfig.save(Main.cartas);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        opensobrecomun(commandEvent);
                    } else {
                        commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " no tienes sobres suficientes! Compra más con w/sobres").queue();
                    }
                } else if(message[1].equalsIgnoreCase("raro")) {
                    if(sr >= 1) {
                        int mathcalc2 = sr - 1;
                        cartasconfig.set("SobreRaro."+commandEvent.getAuthor().getId(),mathcalc2);
                        try {
                            cartasconfig.save(Main.cartas);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        opensobreraro(commandEvent);
                    } else {
                        commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " no tienes sobres suficientes! Compra más con w/sobres").queue();
                    }
                } else if(message[1].equalsIgnoreCase("epico")) {
                    if(se >= 1) {
                        int mathcalc2 = se - 1;
                        cartasconfig.set("SobreEpico."+commandEvent.getAuthor().getId(),mathcalc2);
                        try {
                            cartasconfig.save(Main.cartas);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        opensobreepico(commandEvent);
                    } else {
                        commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " no tienes sobres suficientes! Compra más con w/sobres").queue();

                    }
                } else {
                    if(message[1].equalsIgnoreCase("aniversario")) {
                        if(sa >= 1) {
                            int mathcalc2 = sa - 1;
                            cartasconfig.set("SobreAniversario."+commandEvent.getAuthor().getId(),mathcalc2);
                            try {
                                cartasconfig.save(Main.cartas);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                            opensobreaniversario(commandEvent);
                        } else {
                            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " no tienes sobres suficientes! Parece que no has reclamado el tuyo!").queue();

                        }
                    } else {
                        EmbedBuilder eb = new EmbedBuilder();
                        eb.setColor(Color.RED);
                        eb.setTitle("w/abrirsobre");
                        eb.addField("Uso:","w/abrirsobre [comun|raro|epico]", true);
                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                    }

                }
            } catch(IndexOutOfBoundsException e) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.RED);
                eb.setTitle("w/abrirsobre");
                eb.addField("Uso:","w/abrirsobre [comun|raro|epico]", true);
                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            }
        } else {
            cartasconfig.set("Tokens."+commandEvent.getMessage().getAuthor().getId(),tokens);
            commandEvent.getChannel().sendMessage("Vuelve a utilizar el comando!").queue();
            try {
                cartasconfig.save(Main.cartas);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private void checksobrecomun(CommandEvent commandEvent) {
        if(!cartasconfig.contains("SobreComun."+commandEvent.getMessage().getAuthor().getId())) {
            int sobrescomunes = 0;
            cartasconfig.set("SobreComun."+commandEvent.getMessage().getAuthor().getId(),sobrescomunes);
            try {
                cartasconfig.save(Main.cartas);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private void checksobreraro(CommandEvent commandEvent) {
        if(!cartasconfig.contains("SobreRaro."+commandEvent.getMessage().getAuthor().getId())) {
            int sobresraros = 0;
            cartasconfig.set("SobreRaro."+commandEvent.getMessage().getAuthor().getId(),sobresraros);
            try {
                cartasconfig.save(Main.cartas);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private void checksobreepico(CommandEvent commandEvent){
        if(!cartasconfig.contains("SobreEpico."+commandEvent.getMessage().getAuthor().getId())) {
            int sobresepicos = 0;
            cartasconfig.set("SobreEpico."+commandEvent.getMessage().getAuthor().getId(),sobresepicos);
            try {
                cartasconfig.save(Main.cartas);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private void opensobrecomun(CommandEvent commandEvent) {
        int season = (int) (Math.random() * 100 + 1);
        int random = (int) (Math.random() * 100 + 1);
        if(season <= 33) {
            if(random >= 75) {
                ComunesS1.ComS1(commandEvent);
                RarasS1.RarS1(commandEvent);
                RarasS1.RarS1(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
            } else {
                ComunesS1.ComS1(commandEvent);
                RarasS1.RarS1(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
            }
        } else if(season <= 66) {
            if(random >= 75) {
                ComunesS2.ComS2(commandEvent);
                RarasS2.RarS2(commandEvent);
                RarasS2.RarS2(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
            } else {
                ComunesS2.ComS2(commandEvent);
                RarasS2.RarS2(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
            }
        } else {
            if(random >= 75) {
                ComunesS3.ComS3(commandEvent);
                RarasS3.RarS3(commandEvent);
                RarasS3.RarS3(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
            } else {
                ComunesS3.ComS3(commandEvent);
                RarasS3.RarS3(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
            }
        }



    }
    private void opensobreraro(CommandEvent commandEvent) {
        int season = (int) (Math.random() * 100 + 1);
        int random = (int) (Math.random() * 100 + 1);
        if(season <= 33) {
        if(random >= 85) {
            RarasS1.RarS1(commandEvent);
            RarasS1.RarS1(commandEvent);
            EpicasS1.EpicS1(commandEvent);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
        } else {
            RarasS1.RarS1(commandEvent);
            RarasS1.RarS1(commandEvent);
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
        }
        } else {
            if(season <= 66) {
                if(random >= 85) {
                    RarasS2.RarS2(commandEvent);
                    RarasS2.RarS2(commandEvent);
                    EpicasS1.EpicS1(commandEvent);
                    commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
                } else {
                    RarasS2.RarS2(commandEvent);
                    RarasS2.RarS2(commandEvent);
                    commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
                }
            } else {
                if(random >= 85) {
                    RarasS3.RarS3(commandEvent);
                    RarasS3.RarS3(commandEvent);
                    EpicasS1.EpicS1(commandEvent);
                    commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
                } else {
                    RarasS3.RarS3(commandEvent);
                    RarasS3.RarS3(commandEvent);
                    commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
                }
            }
        }
    }
    private void opensobreepico(CommandEvent commandEvent) {
        int season = (int) (Math.random() * 100 + 1);
        int random = (int) (Math.random() * 100 + 1);
        if(season <= 33) {
            if(random >= 93) {
                RarasS1.RarS1(commandEvent);
                EpicasS1.EpicS1(commandEvent);
                LegendariasS1.LegS1(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
            } else {
                RarasS1.RarS1(commandEvent);
                EpicasS1.EpicS1(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
            }
        } else if(season <= 66) {
            if(random >= 93) {
                RarasS2.RarS2(commandEvent);
                EpicasS1.EpicS1(commandEvent);
                LegendariasS1.LegS1(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
            } else {
                RarasS2.RarS2(commandEvent);
                EpicasS1.EpicS1(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
            }
        } else {
            if(random >= 93) {
                RarasS3.RarS3(commandEvent);
                EpicasS1.EpicS1(commandEvent);
                LegendariasS3.LegS3(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre y le ha tocado carta extra!").queue();
            } else {
                RarasS3.RarS3(commandEvent);
                EpicasS1.EpicS1(commandEvent);
                commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
            }
        }
    }
    private void opensobreaniversario(CommandEvent commandEvent){
        int tokens = (int) (Math.random() * 8 + 1);
        int season = (int) (Math.random() * 100 + 1);
        int secret = (int) (Math.random() * 100 + 1);
        if(season <= 33) {
            ComunesS1.ComS1(commandEvent);
            RarasS1.RarS1(commandEvent);
            EpicasS1.EpicS1(commandEvent);
            LegendariasS1.LegS1(commandEvent);
        } else if(season <= 66) {
            ComunesS2.ComS2(commandEvent);
            RarasS2.RarS2(commandEvent);
            EpicasS1.EpicS1(commandEvent);
            LegendariasS1.LegS1(commandEvent);
        } else {
            ComunesS3.ComS3(commandEvent);
            RarasS3.RarS3(commandEvent);
            EpicasS1.EpicS1(commandEvent);
            LegendariasS3.LegS3(commandEvent);
        }
        int tks = 0;
        tks = (int) cartasconfig.get("Tokens."+commandEvent.getMessage().getAuthor().getId(), tokens);
        tks = tks + tokens;
        cartasconfig.set("Tokens."+commandEvent.getMessage().getAuthor().getId(),tks);
        commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Obtuvo "+tokens+" tokens!").queue();

        if(secret >= 75 && secret <= 87) {
            commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Obtuvo un comando exclusivo, pronto sabras más detalles...").queue();
            cartasconfig.set("AccessDailyToken."+commandEvent.getMessage().getAuthor().getId(),true);

        }
        commandEvent.getChannel().sendMessage(commandEvent.getAuthor().getAsMention() + " Ha abierto un sobre!").queue();
        try {
            cartasconfig.save(Main.cartas);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
