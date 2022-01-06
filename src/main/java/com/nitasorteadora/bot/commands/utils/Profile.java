package com.nitasorteadora.bot.commands.utils;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.ConfigHandler;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.Main;
import com.nitasorteadora.bot.utils.sql.BlacklistManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.cartashelper.CartasData.totaldesbloqueadas;
import static com.nitasorteadora.bot.utils.cartashelper.RemovedReset.resetdawe;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuck;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuckfortarget;

public class Profile extends Command {
    private Main plugin;
    public Profile(Main plugin) {
        this.plugin = plugin;
        this.name = "profile";
        this.help = "Ve tu perfil del bot";
        this.aliases = new String[]{"perfil"};
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

        int totalidad = 0;
        int desbloqueadas = 0;
        int tokens = 0;
        String[] message = commandEvent.getMessage().getContentRaw().split(" ");
        MessageChannel channel = commandEvent.getChannel();
        Guild guild = commandEvent.getGuild();
        try {

            Member target = commandEvent.getMessage().getMentionedMembers().get(0);
            resetdawe(target);
            resetdawe(commandEvent);
            if (target.getId().equals("621875607839440916")) {
                totalidad = (int) cartasconfig.get("Total." + target.getId(), totalidad);
                desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + target.getId(), desbloqueadas);
                tokens = (int) cartasconfig.get("Tokens."+target.getId(),tokens);
                String beta = "Beta Tester :star: ";
                String botowner = "Bot Owner :crown: ";
                String botdeveloper = "Bot Developer :wrench: ";
                String user = "Usuario :pick: ";
                String total = botowner + "\n " + botdeveloper + "\n " + beta + "\n " + user;
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("Perfil de **" + target.getUser().getName() + "**:");
                eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
                //eb.addField("Discord:", "", false);
                //eb.addField("")
                eb.addField("Rango en el BOT:", total, false);
                eb.addField("Estado:", estado(target), true);
                eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
                eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + totaldesbloqueadas), true);
                eb.addField("Tokens:", String.valueOf(tokens), true);
                eb.addField("Suerte:",luckidentifiertarget(target), true);
                eb.setThumbnail(target.getUser().getAvatarUrl());
                eb.setFooter("Comando en BETA");
                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            } else {
                if (ConfigHandler.getAdmins().contains(target.getId())) {
                    totalidad = (int) cartasconfig.get("Total." + target.getId(), totalidad);
                    desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + target.getId(), desbloqueadas);
                    tokens = (int) cartasconfig.get("Tokens."+target.getId(),tokens);
                    String beta = "Beta Tester :star: ";
                    String botcoowners = "Bot Co-Owner :gem: ";
                    String user = "Usuario :pick: ";
                    String total2 = botcoowners + "\n " + beta + "\n " + user;
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setTitle("Perfil de **" + target.getUser().getName() + "**:");
                    eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
                    //eb.addField("Discord:", "", false);
                    //eb.addField("")
                    eb.addField("Rango en el BOT:", total2, false);
                    eb.addField("Estado:", estado(target), true);
                    eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
                    eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + totaldesbloqueadas), true);
                    eb.addField("Tokens:", String.valueOf(tokens), true);
                    eb.addField("Suerte:",luckidentifiertarget(target), true);
                    eb.setThumbnail(target.getUser().getAvatarUrl());
                    eb.setFooter("Comando en BETA");
                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                } else {
                    if (ConfigHandler.getBetas().contains(target.getId())) {
                        totalidad = (int) cartasconfig.get("Total." + target.getId(), totalidad);
                        desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + target.getId(), desbloqueadas);
                        tokens = (int) cartasconfig.get("Tokens."+target.getId(),tokens);
                        String beta = "Beta Tester :star:";
                        String user = "Usuario :pick:";
                        String total3 = beta + "\n " + user;
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        EmbedBuilder eb = new EmbedBuilder();
                        eb.setTitle("Perfil de **" + target.getUser().getName() + "**:");
                        eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
                        //eb.addField("Discord:", "", false);
                        //eb.addField("")
                        eb.addField("Rango en el BOT:", total3, false);
                        eb.addField("Estado:", estado(target), true);
                        eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
                        eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + totaldesbloqueadas), true);
                        eb.addField("Tokens:", String.valueOf(tokens), true);
                        eb.addField("Suerte:",luckidentifiertarget(target), true);
                        eb.setThumbnail(target.getUser().getAvatarUrl());
                        eb.setFooter("Comando en BETA");
                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                    } else {
                        totalidad = (int) cartasconfig.get("Total." + target.getId(), totalidad);
                        desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + target.getId(), desbloqueadas);
                        tokens = (int) cartasconfig.get("Tokens."+target.getId(),tokens);
                        String user = "Usuario :pick:";
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        EmbedBuilder eb = new EmbedBuilder();
                        eb.setTitle("Perfil de **" + target.getUser().getName() + "**:");
                        eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
                        //eb.addField("Discord:", "", false);
                        //eb.addField("")
                        eb.addField("Rango en el BOT:", user, false);
                        eb.addField("Estado:", estado(target), true);
                        eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
                        eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + totaldesbloqueadas), true);
                        eb.addField("Tokens:", String.valueOf(tokens), true);
                        eb.addField("Suerte:",luckidentifiertarget(target), true);
                        eb.setThumbnail(target.getUser().getAvatarUrl());
                        eb.setFooter("Comando en BETA");
                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                    }
                }
            }
        } catch (Exception e) {
            resetdawe(commandEvent);
            if (commandEvent.getMessage().getAuthor().getId().equals("621875607839440916")) {
                totalidad = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), totalidad);
                desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + commandEvent.getAuthor().getId(), desbloqueadas);
                tokens = (int) cartasconfig.get("Tokens."+commandEvent.getAuthor().getId(), tokens);
                String beta = "Beta Tester :star: ";
                String botowner = "Bot Owner :crown: ";
                String botdeveloper = "Bot Developer :wrench: ";
                String user = "Usuario :pick: ";
                String total = botowner + "\n " + botdeveloper + "\n " + beta + "\n " + user;
                User target = commandEvent.getMessage().getAuthor();
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("Perfil de **" + commandEvent.getAuthor().getName() + "**:");
                eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
                //eb.addField("Discord:", "", false);
                //eb.addField("")
                eb.addField("Rango en el BOT:", total, false);
                eb.addField("Estado:", estadoce(commandEvent), true);
                eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
                eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + totaldesbloqueadas), true);
                eb.addField("Tokens:",String.valueOf(tokens), true);
                eb.addField("Suerte:",luckidentifier(commandEvent), true);
                eb.setThumbnail(commandEvent.getAuthor().getAvatarUrl());
                eb.setFooter("Comando en BETA");
                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
            } else {
                if (ConfigHandler.getAdmins().contains(commandEvent.getAuthor().getId())) {
                    totalidad = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), totalidad);
                    desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + commandEvent.getAuthor().getId(), desbloqueadas);
                    tokens = (int) cartasconfig.get("Tokens."+commandEvent.getAuthor().getId(), tokens);
                    String beta = "Beta Tester :star: ";
                    String botcoowners = "Bot Co-Owner :gem: ";
                    String user = "Usuario :pick: ";
                    String total2 = botcoowners + "\n " + beta + "\n " + user;
                    User target = commandEvent.getMessage().getAuthor();
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setTitle("Perfil de **" + commandEvent.getAuthor().getName() + "**:");
                    eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
                    //eb.addField("Discord:", "", false);
                    //eb.addField("")
                    eb.addField("Rango en el BOT:", total2, false);
                    eb.addField("Estado:", estadoce(commandEvent), true);
                    eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
                    eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + totaldesbloqueadas), true);
                    eb.addField("Tokens:",String.valueOf(tokens), true);
                    eb.addField("Suerte:",luckidentifier(commandEvent), true);
                    eb.setThumbnail(commandEvent.getAuthor().getAvatarUrl());
                    eb.setFooter("Comando en BETA");
                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                } else {
                    if (ConfigHandler.getBetas().contains(commandEvent.getAuthor().getId())) {
                        totalidad = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), totalidad);
                        desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + commandEvent.getAuthor().getId(), desbloqueadas);
                        tokens = (int) cartasconfig.get("Tokens."+commandEvent.getAuthor().getId(), tokens);
                        String beta = "Beta Tester :star:";
                        String user = "Usuario :pick:";
                        String total3 = beta + "\n " + user;
                        User target = commandEvent.getMessage().getAuthor();
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        EmbedBuilder eb = new EmbedBuilder();
                        eb.setTitle("Perfil de **" + commandEvent.getAuthor().getName() + "**:");
                        eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
                        //eb.addField("Discord:", "", false);
                        //eb.addField("")
                        eb.addField("Rango en el BOT:", total3, false);
                        eb.addField("Estado:", estadoce(commandEvent), true);
                        eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
                        eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + totaldesbloqueadas), true);
                        eb.addField("Tokens:",String.valueOf(tokens), true);
                        eb.addField("Suerte:",luckidentifier(commandEvent), true);
                        eb.setThumbnail(commandEvent.getAuthor().getAvatarUrl());
                        eb.setFooter("Comando en BETA");
                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                    } else {
                        totalidad = (int) cartasconfig.get("Total." + commandEvent.getAuthor().getId(), totalidad);
                        desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + commandEvent.getAuthor().getId(), desbloqueadas);
                        tokens = (int) cartasconfig.get("Tokens."+commandEvent.getAuthor().getId(), tokens);
                        String user = "Usuario :pick:";
                        User target = commandEvent.getMessage().getAuthor();
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        EmbedBuilder eb = new EmbedBuilder();
                        eb.setTitle("Perfil de **" + commandEvent.getAuthor().getName() + "**:");
                        eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
                        //eb.addField("Discord:", "", false);
                        //eb.addField("")
                        eb.addField("Rango en el BOT:", user, false);
                        eb.addField("Estado:", estadoce(commandEvent), true);
                        eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
                        eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + totaldesbloqueadas), true);
                        eb.addField("Tokens:",String.valueOf(tokens), true);
                        eb.addField("Suerte:",luckidentifier(commandEvent), true);
                        eb.setThumbnail(commandEvent.getAuthor().getAvatarUrl());
                        eb.setFooter("Comando en BETA");
                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                    }
                }
            }
        }


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
