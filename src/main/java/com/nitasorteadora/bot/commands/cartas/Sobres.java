package com.nitasorteadora.bot.commands.cartas;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.cartashelper.RemovedReset.resetdawe;

public class Sobres extends Command {
    boolean locked = true;
    public Sobres() {
        this.name = "sobres";
        this.help = "Compra sobres o ve tus sobres; Comando en Beta";
        this.hidden = true;
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        if(locked) {
            commandEvent.getChannel().sendMessage("Usa /sobres").queue();
            return;
        }
        int tokens = 0;
        String[] message = commandEvent.getMessage().getContentRaw().split(" ");
        if(cartasconfig.contains("Tokens."+commandEvent.getMessage().getAuthor().getId())) {
            tokens = (int) cartasconfig.get("Tokens."+commandEvent.getMessage().getAuthor().getId(), tokens);
            try {
                checksobrecomun(commandEvent);
                checksobreraro(commandEvent);
                checksobreepico(commandEvent);
                resetdawe(commandEvent);
                int sc = 0;
                sc = (int) cartasconfig.get("SobreComun."+commandEvent.getMessage().getAuthor().getId(),sc);
                int sr = 0;
                sr = (int) cartasconfig.get("SobreRaro."+commandEvent.getMessage().getAuthor().getId(),sr);
                int se = 0;
                se = (int) cartasconfig.get("SobreEpico."+commandEvent.getMessage().getAuthor().getId(),se);
            if(message[1].equalsIgnoreCase("view")) {
            checksobrecomun(commandEvent);
            checksobreraro(commandEvent);
            checksobreepico(commandEvent);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Tus sobres");
            eb.addField("Sobres comunes:", String.valueOf(sc),true);
            eb.addField("Sobres raros:",String.valueOf(sr), true);
            eb.addField("Sobres Épicos:",String.valueOf(se), true);
            eb.setColor(Color.GREEN);
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            } else {
                if(message[1].equalsIgnoreCase("buy")) {
                    checksobrecomun(commandEvent);
                    checksobreraro(commandEvent);
                    checksobreepico(commandEvent);
                    if(message[2].equalsIgnoreCase("comun")) {
                        if(tokens >= 11) {
                            int mathcalc = tokens - 11;
                            int mathcalc2 = sc +1;
                            cartasconfig.set("Tokens."+commandEvent.getAuthor().getId(),mathcalc);
                            cartasconfig.set("SobreComun."+commandEvent.getAuthor().getId(),mathcalc2);
                            commandEvent.getChannel().sendMessage("Has comprado un sobre común!").queue();
                            try {
                                cartasconfig.save(Main.cartas);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            commandEvent.getChannel().sendMessage("No tienes tokens suficientes!").queue();
                        }
                    } else if(message[2].equalsIgnoreCase("raro")) {
                            if(tokens >= 14) {
                                int mathcalc = tokens - 14;
                                int mathcalc2 = sr +1;
                                cartasconfig.set("Tokens."+commandEvent.getAuthor().getId(),mathcalc);
                                cartasconfig.set("SobreRaro."+commandEvent.getAuthor().getId(),mathcalc2);
                                commandEvent.getChannel().sendMessage("Has comprado un sobre raro!").queue();
                                try {
                                    cartasconfig.save(Main.cartas);
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                            } else {
                                commandEvent.getChannel().sendMessage("No tienes tokens suficientes!").queue();
                            }
                    } else if(message[2].equalsIgnoreCase("epico")) {
                        if(tokens >= 18){
                            int mathcalc = tokens - 18;
                            int mathcalc2 = se + 1;
                            cartasconfig.set("Tokens."+commandEvent.getAuthor().getId(),mathcalc);
                            cartasconfig.set("SobreEpico."+commandEvent.getAuthor().getId(),mathcalc2);
                            commandEvent.getChannel().sendMessage("Has comprado un sobre épico!").queue();
                            try {
                                cartasconfig.save(Main.cartas);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        } else {
                            commandEvent.getChannel().sendMessage("No tienes tokens suficientes!").queue();
                        }
                    } else {
                        Main.errorembed(commandEvent, "w/sobres", "Compra o ve tus sobres", "View:", "w!sobres view", "Buy:", "w!sobres buy [comun|raro|epico]", "Costes:", "w!sobres costes", "", true, true, true, true, false, Color.RED);
                       /* EmbedBuilder eb = new EmbedBuilder();
                        eb.setTitle("w/sobres");
                        eb.setColor(Color.RED);
                        eb.setDescription("Compra sobres o ve tus sobres");
                        eb.addField("View:","w!sobres view", true);
                        eb.addField("Buy:","w!sobres buy [comun|raro|epico]", true);
                        eb.addField("Costes:", "w!sobres costes", true);
                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();*/
                    }
                } else {
                    if(message[1].equalsIgnoreCase("costes")) {
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setTitle("Costes");
                    eb.addField("Sobre Común:","11 tokens", true);
                    eb.addField("Sobre Raro:","14 tokens", true);
                    eb.addField("Sobre Épico:","18 tokens", true);
                    eb.setColor(Color.CYAN);
                    eb.setFooter("Estos precios pueden variar");
                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();

                    } else {
                        Main.errorembed(commandEvent, "w/sobres", "Compra o ve tus sobres", "View:", "w!sobres view", "Buy:", "w!sobres buy [comun|raro|epico]", "Costes:", "w!sobres costes", "", true, true, true, true, false, Color.RED);

                    }
                }
            }
            } catch (IndexOutOfBoundsException e) {
                Main.errorembed(commandEvent, "w/sobres", "Compra o ve tus sobres", "View:", "w!sobres view", "Buy:", "w!sobres buy [comun|raro|epico]", "Costes:", "w!sobres costes", "", true, true, true, true, false, Color.RED);
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
}
