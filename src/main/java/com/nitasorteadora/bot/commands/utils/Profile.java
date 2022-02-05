package com.nitasorteadora.bot.commands.utils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.Main;
import com.nitasorteadora.bot.utils.sql.BlacklistManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;

import java.awt.*;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuck;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuckfortarget;

public class Profile extends Command {
    private Main plugin;
    public Profile(Main plugin) {
        this.plugin = plugin;
        this.name = "profile";
        this.help = "Ve tu perfil del bot";
        this.hidden = true;
        this.aliases = new String[]{"perfil"};
    }
    private String getAlphaNumeric(int number) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
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
    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        BlacklistManager blacklistManager = new BlacklistManager(plugin.getConn(), commandEvent.getAuthor().getIdLong());
        try{
            if(blacklistManager.isBlacklisted()) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("No se pudo completar la acción");
                eb.setDescription("¡Estás en la lista negra!");
                eb.addField("Razón:", blacklistManager.getReason(), false);
                eb.addField("Desde:",String.valueOf(blacklistManager.getDate()),false);
                eb.addField("Autor:", blacklistManager.getAuthor(),false);
                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                return;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Perfil de " + getAlphaNumeric(8));
        DateTimeFormatter fmtt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        embedBuilder.setDescription("Cuenta Eliminada el " + commandEvent.getAuthor().getTimeCreated().format(fmtt));
        String ttl = "FREE_TOKENS_BADGE :star:" + "\n" + "DEFAULT_BADGE :pick:";
        embedBuilder.addField("Rango en el Bot:",ttl,false);
        embedBuilder.addField("Estado:","Deprimido",true);
        embedBuilder.addField("Cartas Totales:","666",true);
        embedBuilder.addField("Cartas Desbloqueadas:","0/37",true);
        embedBuilder.addField("Tokens:","99999999999",true);
        embedBuilder.addField("Suerte:","Inexistente",true);
        embedBuilder.setThumbnail("https://cdn.discordapp.com/attachments/820116089731153950/939336283975745586/unknown.png");
        embedBuilder.setFooter(":warning: Nos hemos topado con un problema al ejecutar el comando");
        embedBuilder.setColor(Color.RED);
        commandEvent.getChannel().sendMessageEmbeds(embedBuilder.build());

    }

    private static String gameinfo(Member target) {
        try {
            String game = target.getActivities().toString();
            return "Jugando: " + game;
        } catch (NullPointerException e) {
            return "No está jugando ningun juego!";
        }
    }

    private static String infogame(CommandEvent commandEvent) {
        try {
        String juego = commandEvent.getMember().getActivities().toString();
        return "Jugando: " + juego;
    } catch (NullPointerException e) {
        return "No está jugando ningun juego!";
    }
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
private String estadoce(CommandEvent commandEvent) {
    String status = commandEvent.getMember().getOnlineStatus().toString();
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
private String luckidentifier(CommandEvent commandEvent) {
        if(getLuck(commandEvent) >= 1 && getLuck(commandEvent) <= 4) {
            return "Super Baja";
        } else if(getLuck(commandEvent) >=5 && getLuck(commandEvent) <=8) {
            return "Baja";
        } else if(getLuck(commandEvent) >= 9 && getLuck(commandEvent) <=12) {
            return "Normal";
        } else if(getLuck(commandEvent) >=13  && getLuck(commandEvent) <= 16) {
            return "Alta";
        } else if(getLuck(commandEvent) >= 17 && getLuck(commandEvent) <= 20){
            return "Super Alta";
        } else if(getLuck(commandEvent) >= 21) {
            return "Extremadamente Alta";
        } else {
            return "No se encontró";
        }
}
}
