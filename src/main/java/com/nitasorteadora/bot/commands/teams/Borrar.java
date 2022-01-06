package com.nitasorteadora.bot.commands.teams;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.utils.TeamsArraysList;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;


public class Borrar extends Command implements TeamsArraysList {
    public Borrar() {
        this.name = "borrar";
        this.help = "Borra a alguien de un team; Requiere admin perms";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        if (commandEvent.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            try {
                Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                if(participantes.contains(target.getId())) {
                    if(team1.contains("<@" + target.getId() + ">")) {
                        team1.remove("<@" + target.getId() + ">");
                        participantes.remove(target.getId());
                        commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                    } else {
                        if(team2.contains("<@" + target.getId() + ">")) {
                            team2.remove("<@" + target.getId() + ">");
                            participantes.remove(target.getId());
                            commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                        } else {
                            if(team3.contains("<@" + target.getId() + ">")) {
                                team3.remove("<@" + target.getId() + ">");
                                participantes.remove(target.getId());
                                commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                            } else {
                                if(team4.contains("<@" + target.getId() + ">")) {
                                    team4.remove("<@" + target.getId() + ">");
                                    participantes.remove(target.getId());
                                    commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                                } else {
                                    if(team5.contains("<@" + target.getId() + ">")) {
                                        team5.remove("<@" + target.getId() + ">");
                                        participantes.remove(target.getId());
                                        commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                                    } else {
                                        if(team6.contains("<@" + target.getId() + ">")) {
                                            team6.remove("<@" + target.getId() + ">");
                                            participantes.remove(target.getId());
                                            commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                                        }else {
                                            if(team7.contains("<@" + target.getId() + ">")) {
                                                team7.remove("<@" + target.getId() + ">");
                                                participantes.remove(target.getId());
                                                commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                                            } else {
                                                if(team8.contains("<@" + target.getId() + ">")) {
                                                    team8.remove("<@" + target.getId() + ">");
                                                    participantes.remove(target.getId());
                                                    commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                                                } else {
                                                    if(team9.contains("<@" + target.getId() + ">")) {
                                                        team9.remove("<@" + target.getId() + ">");
                                                        participantes.remove(target.getId());
                                                        commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                                                    } else {
                                                        if(team10.contains("<@" + target.getId() + ">")) {
                                                            team10.remove("<@" + target.getId() + ">");
                                                            participantes.remove(target.getId());
                                                            commandEvent.reply("Se ha eliminado a "+ target.getUser().getName() + " de un team");
                                                        } else {
                                                            commandEvent.reply("El participante no está en la lista");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    commandEvent.reply("El participante no está en la lista");


                }
            } catch (Exception e) {
                commandEvent.reply("**Uso: w/borrar <User mention>**");
            }

        } else {
            commandEvent.reply("Permisos insuficientes!");
        }
    }
}
