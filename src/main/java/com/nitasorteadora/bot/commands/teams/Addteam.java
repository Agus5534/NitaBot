package com.nitasorteadora.bot.commands.teams;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.utils.TeamsArraysList;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;

public class Addteam extends Command implements TeamsArraysList {
    protected boolean comprobado = false;
    int maxduos = 2;
    int maxtrios = 3;

    public Addteam() {
        this.name = "addteam";
        this.aliases = new String[]{"at", "agregarequipo", "ae"};
        this.help = "Agrega una persona al team; Uso: w/addteam <Duos|Trios|redvsblue> <Cantidad Teams> <User mention> ; Requiere permisos de Administrador";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if (JDAHandler.devonly) {
            if (!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        String[] message = commandEvent.getMessage().getContentRaw().split(" ");
        try {
            if (commandEvent.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                if (message[1] != null) {
                    if (message[2] != null) {
                        if (message[3] != null) {
                            comprobado = true;
                        }
                    }
                }
            } else {
                commandEvent.getChannel().sendMessage("Permisos insuficientes").queue();
            }
        } catch (IndexOutOfBoundsException e) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("**addteam**");
            eb.setDescription("Syntax erronea");
            eb.addField("Uso:", "w/addteam <Duos|Trios|redvsblue> <Cantidad Teams> <User mention>", true);
            eb.setColor(Color.red);
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
        if (comprobado == true) {
            if (commandEvent.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                if (message[1].equals("Duos")) {
                    if (message[2].equals("4")) {
                        Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                        if (target == null) {
                            EmbedBuilder eb = new EmbedBuilder();
                            eb.setTitle("**addteam**");
                            eb.setDescription("Syntax erronea");
                            eb.addField("Error:", "Faltando Syntax <User mention>", true);
                            eb.setColor(Color.red);
                            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                        } else {
                            int random = (int) (Math.random() * 4 + 1);
                            if (random == 1) {
                                participantes.add(target.getId());
                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                if (team1.size() < maxduos) {
                                    team1.add("<@" + target.getId() + ">");
                                } else {
                                    if (team2.size() < maxduos) {
                                        team2.add("<@" + target.getId() + ">");
                                    } else {
                                        if (team3.size() < maxduos) {
                                            team3.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team4.size() < maxduos) {
                                                team4.add("<@" + target.getId() + ">");
                                            }
                                        }
                                    }
                                }

                            } else {
                                if (random == 2) {
                                    participantes.add(target.getId());
                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                    if (team2.size() < maxduos) {
                                        team2.add("<@" + target.getId() + ">");
                                    } else {
                                        if (team3.size() < maxduos) {
                                            team3.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team4.size() < maxduos) {
                                                team4.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team1.size() < maxduos) {
                                                    team1.add("<@" + target.getId() + ">");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (random == 3) {
                                        participantes.add(target.getId());
                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                        if (team3.size() < maxduos) {
                                            team3.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team4.size() < maxduos) {
                                                team4.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team1.size() < maxduos) {
                                                    team1.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team2.size() < maxduos) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (random == 4) {

                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team4.size() < maxduos) {
                                                team4.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team1.size() < maxduos) {
                                                    team1.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team2.size() < maxduos) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team3.size() < maxduos) {
                                                            team3.add("<@" + target.getId() + ">");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team1.size() < maxduos) {
                                                team1.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team2.size() < maxduos) {
                                                    team2.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team3.size() < maxduos) {
                                                        team3.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team4.size() < maxduos) {
                                                            team4.add("<@" + target.getId() + ">");
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
                        if (message[2].equals("5")) {
                            Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                            if (target == null) {
                                EmbedBuilder eb = new EmbedBuilder();
                                eb.setTitle("**addteam**");
                                eb.setDescription("Syntax erronea");
                                eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                eb.setColor(Color.red);
                                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                            } else {

                                int random = (int) (Math.random() * 5 + 1);
                                if (random == 1) {
                                    participantes.add(target.getId());
                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                    if (team1.size() < maxduos) {
                                        team1.add("<@" + target.getId() + ">");
                                    } else {
                                        if (team2.size() < maxduos) {
                                            team2.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team3.size() < maxduos) {
                                                team3.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team4.size() < maxduos) {
                                                    team4.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team5.size() < maxduos) {
                                                        team5.add("<@" + target.getId() + ">");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (random == 2) {
                                        participantes.add(target.getId());
                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                        if (team2.size() < maxduos) {
                                            team2.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team3.size() < maxduos) {
                                                team3.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team4.size() < maxduos) {
                                                    team4.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team5.size() < maxduos) {
                                                        team5.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team1.size() < maxduos) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (random == 3) {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team3.size() < maxduos) {
                                                team3.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team4.size() < maxduos) {
                                                    team4.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team5.size() < maxduos) {
                                                        team5.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team1.size() < maxduos) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team2.size() < maxduos) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (random == 4) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team4.size() < maxduos) {
                                                    team4.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team5.size() < maxduos) {
                                                        team5.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team1.size() < maxduos) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team2.size() < maxduos) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team3.size() < maxduos) {
                                                                    team3.add("<@" + target.getId() + ">");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (random == 5) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team5.size() < maxduos) {
                                                        team5.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team1.size() < maxduos) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team2.size() < maxduos) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team3.size() < maxduos) {
                                                                    team3.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team4.size() < maxduos) {
                                                                        team4.add("<@" + target.getId() + ">");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team1.size() < maxduos) {
                                                        team1.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team2.size() < maxduos) {
                                                            team2.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team3.size() < maxduos) {
                                                                team3.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team4.size() < maxduos) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxduos) {
                                                                        team5.add("<@" + target.getId() + ">");
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
                            }
                        } else {
                            if (message[2].equals("6")) {
                                Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                if (target == null) {
                                    EmbedBuilder eb = new EmbedBuilder();
                                    eb.setTitle("**addteam**");
                                    eb.setDescription("Syntax erronea");
                                    eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                    eb.setColor(Color.red);
                                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                } else {
                                    int random = (int) (Math.random() * 6 + 1);
                                    if (random == 1) {
                                        participantes.add(target.getId());
                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                        if (team1.size() < maxduos) {
                                            team1.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team2.size() < maxduos) {
                                                team2.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team3.size() < maxduos) {
                                                    team3.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team4.size() < maxduos) {
                                                        team4.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team5.size() < maxduos) {
                                                            team5.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team6.size() < maxduos) {
                                                                team6.add("<@" + target.getId() + ">");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (random == 2) {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team2.size() < maxduos) {
                                                team2.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team3.size() < maxduos) {
                                                    team3.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team4.size() < maxduos) {
                                                        team4.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team5.size() < maxduos) {
                                                            team5.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team6.size() < maxduos) {
                                                                team6.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxduos) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                        } else {
                                            if (random == 3) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team3.size() < maxduos) {
                                                    team3.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team4.size() < maxduos) {
                                                        team4.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team5.size() < maxduos) {
                                                            team5.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team6.size() < maxduos) {
                                                                team6.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxduos) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < maxduos) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (random == 4) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team4.size() < maxduos) {
                                                        team4.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team5.size() < maxduos) {
                                                            team5.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team6.size() < maxduos) {
                                                                team6.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxduos) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < maxduos) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team3.size() < maxduos) {
                                                                            team3.add("<@" + target.getId() + ">");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (random == 5) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team5.size() < maxduos) {
                                                            team5.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team6.size() < maxduos) {
                                                                team6.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxduos) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < maxduos) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team3.size() < maxduos) {
                                                                            team3.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team4.size() < maxduos) {
                                                                                team4.add("<@" + target.getId() + ">");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (random == 6) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team6.size() < maxduos) {
                                                                team6.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxduos) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < maxduos) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team3.size() < maxduos) {
                                                                            team3.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team4.size() < maxduos) {
                                                                                team4.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team5.size() < maxduos) {
                                                                                    team5.add("<@" + target.getId() + ">");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team1.size() < maxduos) {
                                                                team1.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team2.size() < maxduos) {
                                                                    team2.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team3.size() < maxduos) {
                                                                        team3.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team4.size() < maxduos) {
                                                                            team4.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team5.size() < maxduos) {
                                                                                team5.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team6.size() < maxduos) {
                                                                                    team6.add("<@" + target.getId() + ">");
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
                                        }
                                    }

                                }
                            } else {
                                if (message[2].equals("7")) {
                                    Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                    if (target == null) {
                                        EmbedBuilder eb = new EmbedBuilder();
                                        eb.setTitle("**addteam**");
                                        eb.setDescription("Syntax erronea");
                                        eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                        eb.setColor(Color.red);
                                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                    } else {
                                        int random = (int) (Math.random() * 7 + 1);
                                        if (random == 1) {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team1.size() < maxduos) {
                                                team1.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team2.size() < maxduos) {
                                                    team2.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team3.size() < maxduos) {
                                                        team3.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team4.size() < maxduos) {
                                                            team4.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team5.size() < maxduos) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team6.size() < maxduos) {
                                                                    team6.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team7.size() < maxduos) {
                                                                        team7.add("<@" + target.getId() + ">");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (random == 2) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team2.size() < maxduos) {
                                                    team2.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team3.size() < maxduos) {
                                                        team3.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team4.size() < maxduos) {
                                                            team4.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team5.size() < maxduos) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team6.size() < maxduos) {
                                                                    team6.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team7.size() < maxduos) {
                                                                        team7.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxduos) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            } else {
                                                if (random == 3) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team3.size() < maxduos) {
                                                        team3.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team4.size() < maxduos) {
                                                            team4.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team5.size() < maxduos) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team6.size() < maxduos) {
                                                                    team6.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team7.size() < maxduos) {
                                                                        team7.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxduos) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxduos) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (random == 4) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team4.size() < maxduos) {
                                                            team4.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team5.size() < maxduos) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team6.size() < maxduos) {
                                                                    team6.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team7.size() < maxduos) {
                                                                        team7.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxduos) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxduos) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team3.size() < maxduos) {
                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (random == 5) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team5.size() < maxduos) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team6.size() < maxduos) {
                                                                    team6.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team7.size() < maxduos) {
                                                                        team7.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxduos) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxduos) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team3.size() < maxduos) {
                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team4.size() < maxduos) {
                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (random == 6) {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if (team6.size() < maxduos) {
                                                                    team6.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team7.size() < maxduos) {
                                                                        team7.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxduos) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxduos) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team3.size() < maxduos) {
                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team4.size() < maxduos) {
                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team5.size() < maxduos) {
                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                if (random == 7) {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team7.size() < maxduos) {
                                                                        team7.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxduos) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxduos) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team3.size() < maxduos) {
                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team4.size() < maxduos) {
                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team5.size() < maxduos) {
                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team6.size() < maxduos) {
                                                                                                team6.add("<@" + target.getId() + ">");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team1.size() < maxduos) {
                                                                        team1.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team2.size() < maxduos) {
                                                                            team2.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team3.size() < maxduos) {
                                                                                team3.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team4.size() < maxduos) {
                                                                                    team4.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team5.size() < maxduos) {
                                                                                        team5.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team6.size() < maxduos) {
                                                                                            team6.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team7.size() < maxduos) {
                                                                                                team7.add("<@" + target.getId() + ">");
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
                                                    }
                                                }
                                            }
                                        }

                                    }
                                } else {
                                    if (message[2].equals("8")) {
                                        int random = (int) (Math.random() * 8 + 1);
                                        Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                        if (target == null) {
                                            EmbedBuilder eb = new EmbedBuilder();
                                            eb.setTitle("**addteam**");
                                            eb.setDescription("Syntax erronea");
                                            eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                            eb.setColor(Color.red);
                                            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                        } else {
                                            if (random == 1) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team1.size() < maxduos) {
                                                    team1.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team2.size() < maxduos) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team3.size() < maxduos) {
                                                            team3.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team4.size() < maxduos) {
                                                                team4.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team5.size() < maxduos) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxduos) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team7.size() < maxduos) {
                                                                            team7.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team8.size() < maxduos) {
                                                                                team8.add("<@" + target.getId() + ">");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (random == 2) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team2.size() < maxduos) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team3.size() < maxduos) {
                                                            team3.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team4.size() < maxduos) {
                                                                team4.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team5.size() < maxduos) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxduos) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team7.size() < maxduos) {
                                                                            team7.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team8.size() < maxduos) {
                                                                                team8.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxduos) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (random == 3) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team3.size() < maxduos) {
                                                            team3.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team4.size() < maxduos) {
                                                                team4.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team5.size() < maxduos) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxduos) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team7.size() < maxduos) {
                                                                            team7.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team8.size() < maxduos) {
                                                                                team8.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxduos) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxduos) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (random == 4) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team4.size() < maxduos) {
                                                                team4.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team5.size() < maxduos) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxduos) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team7.size() < maxduos) {
                                                                            team7.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team8.size() < maxduos) {
                                                                                team8.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxduos) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxduos) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxduos) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (random == 5) {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if (team5.size() < maxduos) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxduos) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team7.size() < maxduos) {
                                                                            team7.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team8.size() < maxduos) {
                                                                                team8.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxduos) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxduos) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxduos) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team4.size() < maxduos) {
                                                                                                team4.add("<@" + target.getId() + ">");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                if (random == 6) {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team6.size() < maxduos) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team7.size() < maxduos) {
                                                                            team7.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team8.size() < maxduos) {
                                                                                team8.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxduos) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxduos) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxduos) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team4.size() < maxduos) {
                                                                                                team4.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team5.size() < maxduos) {
                                                                                                    team5.add("<@" + target.getId() + ">");
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (random == 7) {
                                                                        participantes.add(target.getId());
                                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                        if (team7.size() < maxduos) {
                                                                            team7.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team8.size() < maxduos) {
                                                                                team8.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxduos) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxduos) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxduos) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team4.size() < maxduos) {
                                                                                                team4.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team5.size() < maxduos) {
                                                                                                    team5.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team6.size() < maxduos) {
                                                                                                        team6.add("<@" + target.getId() + ">");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (random == 8) {
                                                                            participantes.add(target.getId());
                                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                            if (team8.size() < maxduos) {
                                                                                team8.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxduos) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxduos) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxduos) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team4.size() < maxduos) {
                                                                                                team4.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team5.size() < maxduos) {
                                                                                                    team5.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team6.size() < maxduos) {
                                                                                                        team6.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team7.size() < maxduos) {
                                                                                                            team7.add("<@" + target.getId() + ">");
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            participantes.add(target.getId());
                                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                            if (team1.size() < maxduos) {
                                                                                team1.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team2.size() < maxduos) {
                                                                                    team2.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team3.size() < maxduos) {
                                                                                        team3.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team4.size() < maxduos) {
                                                                                            team4.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team5.size() < maxduos) {
                                                                                                team5.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team6.size() < maxduos) {
                                                                                                    team6.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team7.size() < maxduos) {
                                                                                                        team7.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team8.size() < maxduos) {
                                                                                                            team8.add("<@" + target.getId() + ">");
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
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                        }
                                    } else {
                                        if (message[2].equals("9")) {
                                            int random = (int) (Math.random() * 9 + 1);
                                            Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                            if (target == null) {
                                                EmbedBuilder eb = new EmbedBuilder();
                                                eb.setTitle("**addteam**");
                                                eb.setDescription("Syntax erronea");
                                                eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                                eb.setColor(Color.red);
                                                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                            } else {
                                                if (random == 1) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team1.size() < maxduos) {
                                                        team1.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team2.size() < maxduos) {
                                                            team2.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team3.size() < maxduos) {
                                                                team3.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team4.size() < maxduos) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxduos) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxduos) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxduos) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team8.size() < maxduos) {
                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
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
                                                    if (random == 2) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team2.size() < maxduos) {
                                                            team2.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team3.size() < maxduos) {
                                                                team3.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team4.size() < maxduos) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxduos) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxduos) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxduos) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team8.size() < maxduos) {
                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxduos) {
                                                                                            team1.add("<@" + target.getId() + ">");
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
                                                        if (random == 3) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team3.size() < maxduos) {
                                                                team3.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team4.size() < maxduos) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxduos) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxduos) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxduos) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team8.size() < maxduos) {
                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxduos) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxduos) {
                                                                                                team2.add("<@" + target.getId() + ">");
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
                                                            if (random == 4) {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if (team4.size() < maxduos) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxduos) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxduos) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxduos) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team8.size() < maxduos) {
                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxduos) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxduos) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxduos) {
                                                                                                    team3.add("<@" + target.getId() + ">");
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
                                                                if (random == 5) {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team5.size() < maxduos) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxduos) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxduos) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team8.size() < maxduos) {
                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxduos) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxduos) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxduos) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxduos) {
                                                                                                        team4.add("<@" + target.getId() + ">");
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
                                                                    if (random == 6) {
                                                                        participantes.add(target.getId());
                                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                        if (team6.size() < maxduos) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxduos) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team8.size() < maxduos) {
                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxduos) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxduos) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxduos) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxduos) {
                                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team5.size() < maxduos) {
                                                                                                            team5.add("<@" + target.getId() + ">");
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
                                                                        if (random == 7) {
                                                                            participantes.add(target.getId());
                                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                            if (team7.size() < maxduos) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team8.size() < maxduos) {
                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxduos) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxduos) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxduos) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxduos) {
                                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team5.size() < maxduos) {
                                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                                        } else {
                                                                                                            if (team6.size() < maxduos) {
                                                                                                                team6.add("<@" + target.getId() + ">");
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
                                                                            if (random == 8) {
                                                                                participantes.add(target.getId());
                                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                                if (team8.size() < maxduos) {
                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxduos) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxduos) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxduos) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxduos) {
                                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team5.size() < maxduos) {
                                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                                        } else {
                                                                                                            if (team6.size() < maxduos) {
                                                                                                                team6.add("<@" + target.getId() + ">");
                                                                                                            } else {
                                                                                                                if (team7.size() < maxduos) {
                                                                                                                    team7.add("<@" + target.getId() + ">");
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
                                                                                if (random == 9) {
                                                                                    participantes.add(target.getId());
                                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                                    if (team9.size() < maxduos) {
                                                                                        team9.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxduos) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxduos) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxduos) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxduos) {
                                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team5.size() < maxduos) {
                                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                                        } else {
                                                                                                            if (team6.size() < maxduos) {
                                                                                                                team6.add("<@" + target.getId() + ">");
                                                                                                            } else {
                                                                                                                if (team7.size() < maxduos) {
                                                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                                                } else {
                                                                                                                    if (team8.size() < maxduos) {
                                                                                                                        team8.add("<@" + target.getId() + ">");
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
                                                                                    participantes.add(target.getId());
                                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                                    if (team1.size() < maxduos) {
                                                                                        team1.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team2.size() < maxduos) {
                                                                                            team2.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team3.size() < maxduos) {
                                                                                                team3.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team4.size() < maxduos) {
                                                                                                    team4.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team5.size() < maxduos) {
                                                                                                        team5.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team6.size() < maxduos) {
                                                                                                            team6.add("<@" + target.getId() + ">");
                                                                                                        } else {
                                                                                                            if (team7.size() < maxduos) {
                                                                                                                team7.add("<@" + target.getId() + ">");
                                                                                                            } else {
                                                                                                                if (team8.size() < maxduos) {
                                                                                                                    team8.add("<@" + target.getId() + ">");
                                                                                                                } else {
                                                                                                                    if (team9.size() < maxduos) {
                                                                                                                        team9.add("<@" + target.getId() + ">");
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
                                            EmbedBuilder eb = new EmbedBuilder();
                                            eb.setTitle("**addteam**");
                                            eb.setDescription("Syntax erronea");
                                            eb.addField("Error:", "Faltando Syntax <cantidad teams>. Disponibles: 4 a 9", true);
                                            eb.setColor(Color.red);
                                            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (message[1].equals("Trios")) {
                        if (message[2].equals("3")) {
                            int random = (int) (Math.random() * 3 + 1);
                            Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                            if (target == null) {
                                EmbedBuilder eb = new EmbedBuilder();
                                eb.setTitle("**addteam**");
                                eb.setDescription("Syntax erronea");
                                eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                eb.setColor(Color.red);
                                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                            } else {
                                if (random == 1) {
                                    participantes.add(target.getId());
                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                    if (team1.size() < maxtrios) {
                                        team1.add("<@" + target.getId() + ">");
                                    } else {
                                        if (team2.size() < maxtrios) {
                                            team2.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team3.size() < maxtrios) {
                                                team3.add("<@" + target.getId() + ">");
                                            }
                                        }
                                    }
                                } else {
                                    if (random == 2) {
                                        participantes.add(target.getId());
                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                        if (team2.size() < maxtrios) {
                                            team2.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team3.size() < maxtrios) {
                                                team3.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team1.size() < maxtrios) {
                                                    team1.add("<@" + target.getId() + ">");
                                                }
                                            }
                                        }
                                    } else {
                                        if (random == 3) {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team3.size() < maxtrios) {
                                                team3.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team1.size() < maxtrios) {
                                                    team1.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team2.size() < maxtrios) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        } else {
                            if (message[2].equals("4")) {
                                int random = (int) (Math.random() * 4 + 1);
                                Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                if (target == null) {
                                    EmbedBuilder eb = new EmbedBuilder();
                                    eb.setTitle("**addteam**");
                                    eb.setDescription("Syntax erronea");
                                    eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                    eb.setColor(Color.red);
                                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                } else {
                                    if (random == 1) {
                                        participantes.add(target.getId());
                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                        if (team1.size() < maxtrios) {
                                            team1.add("<@" + target.getId() + ">");
                                        } else {
                                            if (team2.size() < maxtrios) {
                                                team2.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team3.size() < maxtrios) {
                                                    team3.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team4.size() < maxtrios) {
                                                        team4.add("<@" + target.getId() + ">");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (random == 2) {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team2.size() < maxtrios) {
                                                team2.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team3.size() < maxtrios) {
                                                    team3.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team4.size() < maxtrios) {
                                                        team4.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team1.size() < maxtrios) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (random == 3) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team3.size() < maxtrios) {
                                                    team3.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team4.size() < maxtrios) {
                                                        team4.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team1.size() < maxtrios) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team2.size() < maxtrios) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (random == 4) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team4.size() < maxtrios) {
                                                        team4.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team1.size() < maxtrios) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team2.size() < maxtrios) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team3.size() < maxtrios) {
                                                                    team3.add("<@" + target.getId() + ">");
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
                                if (message[2].equals("5")) {
                                    int random = (int) (Math.random() * 5 + 1);
                                    Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                    if (target == null) {
                                        EmbedBuilder eb = new EmbedBuilder();
                                        eb.setTitle("**addteam**");
                                        eb.setDescription("Syntax erronea");
                                        eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                        eb.setColor(Color.red);
                                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                    } else {
                                        if (random == 1) {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team1.size() < maxtrios) {
                                                team1.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team2.size() < maxtrios) {
                                                    team2.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team3.size() < maxtrios) {
                                                        team3.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team4.size() < maxtrios) {
                                                            team4.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team5.size() < maxtrios) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (random == 2) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team2.size() < maxtrios) {
                                                    team2.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team3.size() < maxtrios) {
                                                        team3.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team4.size() < maxtrios) {
                                                            team4.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team5.size() < maxtrios) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxtrios) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (random == 3) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team3.size() < maxtrios) {
                                                        team3.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team4.size() < maxtrios) {
                                                            team4.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team5.size() < maxtrios) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxtrios) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < maxtrios) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (random == 4) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team4.size() < maxtrios) {
                                                            team4.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team5.size() < maxtrios) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxtrios) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < maxtrios) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team3.size() < maxtrios) {
                                                                            team3.add("<@" + target.getId() + ">");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (random == 5) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team5.size() < maxtrios) {
                                                                team5.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < maxtrios) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < maxtrios) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team3.size() < maxtrios) {
                                                                            team3.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team4.size() < maxtrios) {
                                                                                team4.add("<@" + target.getId() + ">");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team1.size() < maxtrios) {
                                                                team1.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team2.size() < maxtrios) {
                                                                    team2.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team3.size() < maxtrios) {
                                                                        team3.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team4.size() < maxtrios) {
                                                                            team4.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team5.size() < maxtrios) {
                                                                                team5.add("<@" + target.getId() + ">");
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
                                    }
                                } else {
                                    if (message[2].equals("6")) {
                                        int random = (int) (Math.random() * 6 + 1);
                                        Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                        if (target == null) {
                                            EmbedBuilder eb = new EmbedBuilder();
                                            eb.setTitle("**addteam**");
                                            eb.setDescription("Syntax erronea");
                                            eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                            eb.setColor(Color.red);
                                            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                        } else {
                                            if (random == 1) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team1.size() < maxtrios) {
                                                    team1.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team2.size() < maxtrios) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team3.size() < maxtrios) {
                                                            team3.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team4.size() < maxtrios) {
                                                                team4.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team5.size() < maxtrios) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxtrios) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (random == 2) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team2.size() < maxtrios) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team3.size() < maxtrios) {
                                                            team3.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team4.size() < maxtrios) {
                                                                team4.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team5.size() < maxtrios) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxtrios) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxtrios) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (random == 3) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team3.size() < maxtrios) {
                                                            team3.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team4.size() < maxtrios) {
                                                                team4.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team5.size() < maxtrios) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxtrios) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxtrios) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxtrios) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (random == 4) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team4.size() < maxtrios) {
                                                                team4.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team5.size() < maxtrios) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxtrios) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxtrios) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxtrios) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team3.size() < maxtrios) {
                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (random == 5) {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if (team5.size() < maxtrios) {
                                                                    team5.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team6.size() < maxtrios) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxtrios) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxtrios) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team3.size() < maxtrios) {
                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team4.size() < maxtrios) {
                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                if (random == 6) {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team6.size() < maxtrios) {
                                                                        team6.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < maxtrios) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < maxtrios) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team3.size() < maxtrios) {
                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team4.size() < maxtrios) {
                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team5.size() < maxtrios) {
                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team1.size() < maxtrios) {
                                                                        team1.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team2.size() < maxtrios) {
                                                                            team2.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team3.size() < maxtrios) {
                                                                                team3.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team4.size() < maxtrios) {
                                                                                    team4.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team5.size() < maxtrios) {
                                                                                        team5.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team6.size() < maxtrios) {
                                                                                            team6.add("<@" + target.getId() + ">");
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
                                                }
                                            }
                                        }
                                    } else {
                                        if (message[2].equals("7")) {
                                            int random = (int) (Math.random() * 7 + 1);
                                            Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                            if (target == null) {
                                                EmbedBuilder eb = new EmbedBuilder();
                                                eb.setTitle("**addteam**");
                                                eb.setDescription("Syntax erronea");
                                                eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                                eb.setColor(Color.red);
                                                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                            } else {
                                                if (random == 1) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team1.size() < maxtrios) {
                                                        team1.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team2.size() < maxtrios) {
                                                            team2.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team3.size() < maxtrios) {
                                                                team3.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team4.size() < maxtrios) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxtrios) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxtrios) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxtrios) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (random == 2) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team2.size() < maxtrios) {
                                                            team2.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team3.size() < maxtrios) {
                                                                team3.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team4.size() < maxtrios) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxtrios) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxtrios) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxtrios) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxtrios) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (random == 3) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team3.size() < maxtrios) {
                                                                team3.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team4.size() < maxtrios) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxtrios) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxtrios) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxtrios) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxtrios) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxtrios) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (random == 4) {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if (team4.size() < maxtrios) {
                                                                    team4.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team5.size() < maxtrios) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxtrios) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxtrios) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxtrios) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxtrios) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxtrios) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                if (random == 5) {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team5.size() < maxtrios) {
                                                                        team5.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team6.size() < maxtrios) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxtrios) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxtrios) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxtrios) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxtrios) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team4.size() < maxtrios) {
                                                                                                team4.add("<@" + target.getId() + ">");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (random == 6) {
                                                                        participantes.add(target.getId());
                                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                        if (team6.size() < maxtrios) {
                                                                            team6.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team7.size() < maxtrios) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxtrios) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxtrios) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxtrios) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team4.size() < maxtrios) {
                                                                                                team4.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team5.size() < maxtrios) {
                                                                                                    team5.add("<@" + target.getId() + ">");
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (random == 7) {
                                                                            participantes.add(target.getId());
                                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                            if (team7.size() < maxtrios) {
                                                                                team7.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team1.size() < maxtrios) {
                                                                                    team1.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team2.size() < maxtrios) {
                                                                                        team2.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team3.size() < maxtrios) {
                                                                                            team3.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team4.size() < maxtrios) {
                                                                                                team4.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team5.size() < maxtrios) {
                                                                                                    team5.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team6.size() < maxtrios) {
                                                                                                        team6.add("<@" + target.getId() + ">");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            participantes.add(target.getId());
                                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                            if (team2.size() < maxtrios) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team3.size() < maxtrios) {
                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team4.size() < maxtrios) {
                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team5.size() < maxtrios) {
                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team6.size() < maxtrios) {
                                                                                                team6.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team7.size() < maxtrios) {
                                                                                                    team7.add("<@" + target.getId() + ">");
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
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (message[2].equals("8")) {
                                                int random = (int) (Math.random() * 8 + 1);
                                                Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                                if (target == null) {
                                                    EmbedBuilder eb = new EmbedBuilder();
                                                    eb.setTitle("**addteam**");
                                                    eb.setDescription("Syntax erronea");
                                                    eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                                    eb.setColor(Color.red);
                                                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                                } else {
                                                    if (random == 1) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team1.size() < maxtrios) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team2.size() < maxtrios) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team3.size() < maxtrios) {
                                                                    team3.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team4.size() < maxtrios) {
                                                                        team4.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team5.size() < maxtrios) {
                                                                            team5.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team6.size() < maxtrios) {
                                                                                team6.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team7.size() < maxtrios) {
                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team8.size() < maxtrios) {
                                                                                        team8.add("<@" + target.getId() + ">");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (random == 2) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team2.size() < maxtrios) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team3.size() < maxtrios) {
                                                                    team3.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team4.size() < maxtrios) {
                                                                        team4.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team5.size() < maxtrios) {
                                                                            team5.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team6.size() < maxtrios) {
                                                                                team6.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team7.size() < maxtrios) {
                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team8.size() < maxtrios) {
                                                                                        team8.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxtrios) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (random == 3) {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if (team3.size() < maxtrios) {
                                                                    team3.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team4.size() < maxtrios) {
                                                                        team4.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team5.size() < maxtrios) {
                                                                            team5.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team6.size() < maxtrios) {
                                                                                team6.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team7.size() < maxtrios) {
                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team8.size() < maxtrios) {
                                                                                        team8.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxtrios) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxtrios) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                if (random == 4) {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team4.size() < maxtrios) {
                                                                        team4.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team5.size() < maxtrios) {
                                                                            team5.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team6.size() < maxtrios) {
                                                                                team6.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team7.size() < maxtrios) {
                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team8.size() < maxtrios) {
                                                                                        team8.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxtrios) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxtrios) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxtrios) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (random == 5) {
                                                                        participantes.add(target.getId());
                                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                        if (team5.size() < maxtrios) {
                                                                            team5.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team6.size() < maxtrios) {
                                                                                team6.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team7.size() < maxtrios) {
                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team8.size() < maxtrios) {
                                                                                        team8.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxtrios) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxtrios) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxtrios) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxtrios) {
                                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (random == 6) {
                                                                            participantes.add(target.getId());
                                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                            if (team6.size() < maxtrios) {
                                                                                team6.add("<@" + target.getId() + ">");
                                                                            } else {
                                                                                if (team7.size() < maxtrios) {
                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team8.size() < maxtrios) {
                                                                                        team8.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxtrios) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxtrios) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxtrios) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxtrios) {
                                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team5.size() < maxtrios) {
                                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if (random == 7) {
                                                                                participantes.add(target.getId());
                                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                                if (team7.size() < maxtrios) {
                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                } else {
                                                                                    if (team8.size() < maxtrios) {
                                                                                        team8.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxtrios) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxtrios) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxtrios) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxtrios) {
                                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team5.size() < maxtrios) {
                                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                                        } else {
                                                                                                            if (team6.size() < maxtrios) {
                                                                                                                team6.add("<@" + target.getId() + ">");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (random == 8) {
                                                                                    participantes.add(target.getId());
                                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                                    if (team8.size() < maxtrios) {
                                                                                        team8.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team1.size() < maxtrios) {
                                                                                            team1.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team2.size() < maxtrios) {
                                                                                                team2.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team3.size() < maxtrios) {
                                                                                                    team3.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team4.size() < maxtrios) {
                                                                                                        team4.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team5.size() < maxtrios) {
                                                                                                            team5.add("<@" + target.getId() + ">");
                                                                                                        } else {
                                                                                                            if (team6.size() < maxtrios) {
                                                                                                                team6.add("<@" + target.getId() + ">");
                                                                                                            } else {
                                                                                                                if (team7.size() < maxtrios) {
                                                                                                                    team7.add("<@" + target.getId() + ">");
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    participantes.add(target.getId());
                                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                                    if (team1.size() < maxtrios) {
                                                                                        team1.add("<@" + target.getId() + ">");
                                                                                    } else {
                                                                                        if (team2.size() < maxtrios) {
                                                                                            team2.add("<@" + target.getId() + ">");
                                                                                        } else {
                                                                                            if (team3.size() < maxtrios) {
                                                                                                team3.add("<@" + target.getId() + ">");
                                                                                            } else {
                                                                                                if (team4.size() < maxtrios) {
                                                                                                    team4.add("<@" + target.getId() + ">");
                                                                                                } else {
                                                                                                    if (team5.size() < maxtrios) {
                                                                                                        team5.add("<@" + target.getId() + ">");
                                                                                                    } else {
                                                                                                        if (team6.size() < maxtrios) {
                                                                                                            team6.add("<@" + target.getId() + ">");
                                                                                                        } else {
                                                                                                            if (team7.size() < maxtrios) {
                                                                                                                team7.add("<@" + target.getId() + ">");
                                                                                                            } else {
                                                                                                                if (team8.size() < maxtrios) {
                                                                                                                    team8.add("<@" + target.getId() + ">");
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
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                EmbedBuilder eb = new EmbedBuilder();
                                                eb.setTitle("**addteam**");
                                                eb.setDescription("Syntax erronea");
                                                eb.addField("Error:", "Faltando Syntax <cantidad teams>. Disponibles: 3 al 8", true);
                                                eb.setColor(Color.red);
                                                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (message[1].equals("redvsblue")) {
                            if (message[2].equals("5")) {
                                int random = (int) (Math.random() * 2 + 1);
                                Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                if (target == null) {
                                    EmbedBuilder eb = new EmbedBuilder();
                                    eb.setTitle("**addteam**");
                                    eb.setDescription("Syntax erronea");
                                    eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                    eb.setColor(Color.red);
                                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                } else {
                                    if(random == 1) {
                                        participantes.add(target.getId());
                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                        if(team1.size() < 5) {
                                            team1.add("<@" + target.getId() + ">");
                                        } else {
                                            if(team2.size() < 5) {
                                                team2.add("<@" + target.getId() + ">");
                                            }
                                        }
                                    } else {
                                        if(random == 2) {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if(team2.size() < 5) {
                                                team2.add("<@" + target.getId() + ">");
                                            } else {
                                                if(team1.size() < 5) {
                                                    team1.add("<@" + target.getId() + ">");
                                                }
                                            }
                                        } else {
                                            if(random == 1) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team1.size() < 5) {
                                                    team1.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team2.size() < 5) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    }
                                                }
                                            }}}
                                }
                            } else {
                                if (message[2].equals("6")) {
                                    int random = (int) (Math.random() * 2 + 1);
                                    Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                    if (target == null) {
                                        EmbedBuilder eb = new EmbedBuilder();
                                        eb.setTitle("**addteam**");
                                        eb.setDescription("Syntax erronea");
                                        eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                        eb.setColor(Color.red);
                                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                    } else {
                                        if(random == 1) {
                                            participantes.add(target.getId());
                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                            if (team1.size() < 6) {
                                                team1.add("<@" + target.getId() + ">");
                                            } else {
                                                if (team2.size() < 6) {
                                                    team2.add("<@" + target.getId() + ">");
                                                }
                                            }
                                        } else {
                                            if(random == 2) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if(team2.size() < 6){
                                                    team2.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team1.size() < 6) {
                                                        team1.add("<@" + target.getId() + ">");
                                                    }
                                                }
                                            } else {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team1.size() < 6) {
                                                    team1.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team2.size() < 6) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (message[2].equals("7")) {
                                        int random = (int) (Math.random() * 2 + 1);
                                        Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                        if (target == null) {
                                            EmbedBuilder eb = new EmbedBuilder();
                                            eb.setTitle("**addteam**");
                                            eb.setDescription("Syntax erronea");
                                            eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                            eb.setColor(Color.red);
                                            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                        } else {
                                            if(random == 1) {
                                                participantes.add(target.getId());
                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                if (team1.size() < 7) {
                                                    team1.add("<@" + target.getId() + ">");
                                                } else {
                                                    if (team2.size() < 7) {
                                                        team2.add("<@" + target.getId() + ">");
                                                    }
                                                }
                                            } else {
                                                if(random == 2) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if(team2.size() < 7){
                                                        team2.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team1.size() < 7) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        }
                                                    }
                                                } else {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team1.size() < 7) {
                                                        team1.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team2.size() < 7) {
                                                            team2.add("<@" + target.getId() + ">");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (message[2].equals("8")) {
                                            int random = (int) (Math.random() * 2 + 1);
                                            Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                            if (target == null) {
                                                EmbedBuilder eb = new EmbedBuilder();
                                                eb.setTitle("**addteam**");
                                                eb.setDescription("Syntax erronea");
                                                eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                                eb.setColor(Color.red);
                                                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                            } else {
                                                if(random == 1) {
                                                    participantes.add(target.getId());
                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                    if (team1.size() < 8) {
                                                        team1.add("<@" + target.getId() + ">");
                                                    } else {
                                                        if (team2.size() < 8) {
                                                            team2.add("<@" + target.getId() + ">");
                                                        }
                                                    }
                                                } else {
                                                    if(random == 2) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if(team2.size() < 8){
                                                            team2.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team1.size() < 8) {
                                                                team1.add("<@" + target.getId() + ">");
                                                            }
                                                        }
                                                    } else {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team1.size() < 8) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team2.size() < 8) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (message[2].equals("9")) {
                                                int random = (int) (Math.random() * 2 + 1);
                                                Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                                if (target == null) {
                                                    EmbedBuilder eb = new EmbedBuilder();
                                                    eb.setTitle("**addteam**");
                                                    eb.setDescription("Syntax erronea");
                                                    eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                                    eb.setColor(Color.red);
                                                    commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                                } else {
                                                    if(random == 1) {
                                                        participantes.add(target.getId());
                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                        if (team1.size() < 9) {
                                                            team1.add("<@" + target.getId() + ">");
                                                        } else {
                                                            if (team2.size() < 9) {
                                                                team2.add("<@" + target.getId() + ">");
                                                            }
                                                        }
                                                    } else {
                                                        if(random == 2) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if(team2.size() < 9){
                                                                team2.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team1.size() < 9) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                }
                                                            }
                                                        } else {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team1.size() < 9) {
                                                                team1.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team2.size() < 9) {
                                                                    team2.add("<@" + target.getId() + ">");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (message[2].equals("10")) {
                                                    int random = (int) (Math.random() * 2 + 1);
                                                    Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                                    if (target == null) {
                                                        EmbedBuilder eb = new EmbedBuilder();
                                                        eb.setTitle("**addteam**");
                                                        eb.setDescription("Syntax erronea");
                                                        eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                                        eb.setColor(Color.red);
                                                        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                                    } else {
                                                        if(random == 1) {
                                                            participantes.add(target.getId());
                                                            commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                            if (team1.size() < 10) {
                                                                team1.add("<@" + target.getId() + ">");
                                                            } else {
                                                                if (team2.size() < 10) {
                                                                    team2.add("<@" + target.getId() + ">");
                                                                }
                                                            }
                                                        } else {
                                                            if(random == 2) {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if(team2.size() < 10){
                                                                    team2.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team1.size() < 10) {
                                                                        team1.add("<@" + target.getId() + ">");
                                                                    }
                                                                }
                                                            } else {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if (team1.size() < 10) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < 10) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (message[2].equals("11")) {
                                                        int random = (int) (Math.random() * 2 + 1);
                                                        Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                                        if (target == null) {
                                                            EmbedBuilder eb = new EmbedBuilder();
                                                            eb.setTitle("**addteam**");
                                                            eb.setDescription("Syntax erronea");
                                                            eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                                            eb.setColor(Color.red);
                                                            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                                        } else {
                                                            if(random == 1) {
                                                                participantes.add(target.getId());
                                                                commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                if (team1.size() < 11) {
                                                                    team1.add("<@" + target.getId() + ">");
                                                                } else {
                                                                    if (team2.size() < 11) {
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    }
                                                                }
                                                            } else {
                                                                if(random == 2) {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if(team2.size() < 11){
                                                                        team2.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team1.size() < 11) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        }
                                                                    }
                                                                } else {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team1.size() < 11) {
                                                                        team1.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team2.size() < 11) {
                                                                            team2.add("<@" + target.getId() + ">");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (message[2].equals("12")) {
                                                            int random = (int) (Math.random() * 2 + 1);
                                                            Member target = commandEvent.getMessage().getMentionedMembers().get(0);
                                                            if (target == null) {
                                                                EmbedBuilder eb = new EmbedBuilder();
                                                                eb.setTitle("**addteam**");
                                                                eb.setDescription("Syntax erronea");
                                                                eb.addField("Error:", "Faltando Syntax <User mention>", true);
                                                                eb.setColor(Color.red);
                                                                commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                                            } else {
                                                                if(random == 1) {
                                                                    participantes.add(target.getId());
                                                                    commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                    if (team1.size() < 12) {
                                                                        team1.add("<@" + target.getId() + ">");
                                                                    } else {
                                                                        if (team2.size() < 12) {
                                                                            team2.add("<@" + target.getId() + ">");
                                                                        }
                                                                    }
                                                                } else {
                                                                    if(random == 2) {
                                                                        participantes.add(target.getId());
                                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                        if(team2.size() < 12){
                                                                            team2.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team1.size() < 12) {
                                                                                team1.add("<@" + target.getId() + ">");
                                                                            }
                                                                        }
                                                                    } else {
                                                                        participantes.add(target.getId());
                                                                        commandEvent.getChannel().sendMessage("Se ha agregado a **" + target.getUser().getName() + "** a la lista.").queue();
                                                                        if (team1.size() < 12) {
                                                                            team1.add("<@" + target.getId() + ">");
                                                                        } else {
                                                                            if (team2.size() < 12) {
                                                                                team2.add("<@" + target.getId() + ">");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            EmbedBuilder eb = new EmbedBuilder();
                                                            eb.setTitle("**addteam**");
                                                            eb.setDescription("Syntax erronea");
                                                            eb.addField("Error:", "Faltando Syntax <cantidad de personas por team>. Disponibles: 5 al 12", true);
                                                            eb.setColor(Color.red);
                                                            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            EmbedBuilder eb = new EmbedBuilder();
                            eb.setTitle("**addteam**");
                            eb.setDescription("Syntax erronea");
                            eb.addField("Error:", "Faltando Syntax <modalidad>. Disponibles: Duos, Trios y redvsblue", true);
                            eb.setColor(Color.red);
                            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
                        }
                    }

                }
            } else {
                commandEvent.getChannel().sendTyping().queue();
                commandEvent.getChannel().sendMessage("No tienes permiso de ejecutar este comando!").queue();

            }
        }


    }
}