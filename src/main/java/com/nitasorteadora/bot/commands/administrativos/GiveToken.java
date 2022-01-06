package com.nitasorteadora.bot.commands.administrativos;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.ConfigHandler;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;

import java.awt.*;

import static com.nitasorteadora.bot.Main.cartasconfig;

public class GiveToken extends Command {
    public GiveToken() {
        this.name = "givetokens";
        this.help = "Agrega tokens; Requiere ser BOT_MANAGER";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if(!ConfigHandler.getAdmins().contains(commandEvent.getAuthor().getId())) {
            commandEvent.getChannel().sendMessage("No eres administrador del bot!");
        } else {
            int tokens = 0;
            String[] message = commandEvent.getMessage().getContentRaw().split(" ");
            try {
                Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                if(target == null ) {
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setTitle("w/givetokens");
                    eb.setColor(Color.red);
                    eb.addField("Uso:","w/givetokens [user-mention] [cant tokens]", true);
                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                } else {
                    checktoken(target);
                    if(isnumber(message)) {
                        int gettokens = 0;
                        gettokens = (int) cartasconfig.get("Tokens."+target.getId(), gettokens);
                        int tokenstoset = gettokens + Integer.valueOf(message[2]);
                        if(Integer.valueOf(message[2]) >= 1) {
                            cartasconfig.set("Tokens."+target.getId(), tokenstoset);
                            save();
                            commandEvent.getChannel().sendMessage("Se han otorgado **" + message[2] + "** tokens a " + target.getAsMention()).queue();
                         //   commandEvent.getChannel().sendMessageEmbeds(new EmbedHelper(new EmbedBuilder()).author("asd", null, null).color(Color.RED).build()).queue();
                        } else {
                            commandEvent.getChannel().sendMessage("**" + message[2]+ "** No es un número entero!").queue();
                        }

                    } else {
                        commandEvent.getChannel().sendMessage("**" + message[2] + "** No es un número entero!").queue();
                    }

                }
            } catch (IndexOutOfBoundsException e) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("w/givetokens");
                eb.setColor(Color.red);
                eb.addField("Uso:","w/givetokens [user-mention] [cant tokens]", true);
                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            }
        }


    }
    private void checktoken(Member target) {
        if(!cartasconfig.contains("Tokens."+target.getUser().getId())) {
            int tokens = 0;
            cartasconfig.set("Tokens."+target.getUser().getId(),tokens);
            try {
                cartasconfig.save(Main.cartas);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private boolean isnumber(String[] message) {
        try {
            Integer.parseInt(message[2]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void save() {
        try {
            cartasconfig.save(Main.cartas);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
