package com.nitasorteadora.bot.commands.extra;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.Main;
import com.nitasorteadora.bot.cumples.abril.Juuzouv5;
import com.nitasorteadora.bot.cumples.abril.Spiker;
import com.nitasorteadora.bot.cumples.agosto.Cneyer;
import com.nitasorteadora.bot.cumples.agosto.Magic;
import com.nitasorteadora.bot.cumples.agosto.PatoLand;
import com.nitasorteadora.bot.cumples.agosto.Zeqia;
import com.nitasorteadora.bot.cumples.diciembre.*;
import com.nitasorteadora.bot.cumples.enero.Celestial;
import com.nitasorteadora.bot.cumples.enero.IkiAndChill;
import com.nitasorteadora.bot.cumples.enero.Infernal;
import com.nitasorteadora.bot.cumples.enero.XRayos;
import com.nitasorteadora.bot.cumples.febrero.Ayden;
import com.nitasorteadora.bot.cumples.febrero.Cuchiuwu;
import com.nitasorteadora.bot.cumples.febrero.Rufk;
import com.nitasorteadora.bot.cumples.julio.Firredrake;
import com.nitasorteadora.bot.cumples.julio.LuquiMC;
import com.nitasorteadora.bot.cumples.julio.Maurito;
import com.nitasorteadora.bot.cumples.julio.vYurita;
import com.nitasorteadora.bot.cumples.junio.Ivoo;
import com.nitasorteadora.bot.cumples.junio.MrComeGatos;
import com.nitasorteadora.bot.cumples.junio.Niita;
import com.nitasorteadora.bot.cumples.marzo.Eriksito;
import com.nitasorteadora.bot.cumples.marzo.Evil;
import com.nitasorteadora.bot.cumples.marzo.NitaSorteadora;
import com.nitasorteadora.bot.cumples.marzo.Starrzfall;
import com.nitasorteadora.bot.cumples.mayo.*;
import com.nitasorteadora.bot.cumples.noviembre.*;
import com.nitasorteadora.bot.cumples.octubre.*;
import com.nitasorteadora.bot.cumples.septiembre.Agus5534;
import com.nitasorteadora.bot.cumples.septiembre.Heis;
import com.nitasorteadora.bot.cumples.septiembre.TheJuanjo;
import com.nitasorteadora.bot.cumples.septiembre.Zazil;
import com.nitasorteadora.bot.utils.sql.BlacklistManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;
import java.sql.SQLException;

import static com.nitasorteadora.bot.utils.cartashelper.RemovedReset.resetdawe;


public class Cumples extends Command {
    private Main plugin;
    private boolean locked = true;
    public Cumples(Main plugin){
        this.plugin = plugin;
        this.name = "cumpleaños";
        this.help = "Todos los cumpleaños del weekend!";
        this.aliases = new String[] {"cumples","cumple"};
    }
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        if(locked) {
            commandEvent.getChannel().sendMessage("Comando en renovación! Disculpe las molestias").queue();
            return;
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
        String[] message = commandEvent.getMessage().getContentRaw().split(" ");
        MessageChannel channel = commandEvent.getChannel();
        resetdawe(commandEvent);
        try {
        if(message[1].equalsIgnoreCase("Iki")) {
            IkiAndChill.Iki(commandEvent);
        } else {
            if(message[1].equalsIgnoreCase("Xrayos")) {
                XRayos.Rayos(commandEvent);
            } else {
                if(message[1].equalsIgnoreCase("Infernal")) {
                    Infernal.Infer(commandEvent);
                } else {
                    if(message[1].equalsIgnoreCase("Celestial")) {
                        Celestial.Cel(commandEvent);
                    } else {
                            if(message[1].equalsIgnoreCase("Cuchi")) {
                                Cuchiuwu.Cuchi(commandEvent);
                            } else {
                                if(message[1].equalsIgnoreCase("Rufk")) {
                                    Rufk.Ruf(commandEvent);
                                } else {
                                    if(message[1].equalsIgnoreCase("Star")) {
                                        Starrzfall.Star(commandEvent);
                                    } else {
                                        if(message[1].equalsIgnoreCase("Evil")) {
                                            Evil.Evl(commandEvent);
                                        } else {
                                            if(message[1].equalsIgnoreCase("Juzo")) {
                                                Juuzouv5.Juzo(commandEvent);
                                            } else {
                                                if(message[1].equalsIgnoreCase("Spiker")) {
                                                    Spiker.Spik(commandEvent);
                                                } else {
                                                    if(message[1].equalsIgnoreCase("Nyrem")) {
                                                        NyNyrem.Nyrem(commandEvent);
                                                    } else {
                                                        if(message[1].equalsIgnoreCase("Augus")) {
                                                            AugusImperial.Augus(commandEvent);
                                                        } else {
                                                            if(message[1].equalsIgnoreCase("Flowii")) {
                                                                Flowii.Flowi(commandEvent);
                                                            } else {
                                                                if(message[1].equalsIgnoreCase("Charly")) {
                                                                    CharlyDavid.Charly(commandEvent);
                                                                } else {
                                                                    if(message[1].equalsIgnoreCase("Goge")) {
                                                                        Gogeta.Goge(commandEvent);
                                                                    } else {
                                                                        if(message[1].equalsIgnoreCase("MrComeGatos")) {
                                                                            MrComeGatos.ComeGatos(commandEvent);
                                                                        } else {
                                                                            if(message[1].equalsIgnoreCase("Nita")) {
                                                                                Niita.Nita(commandEvent);
                                                                            } else {
                                                                                if(message[1].equalsIgnoreCase("Ivo")) {
                                                                                    Ivoo.Ivo(commandEvent);

                                                                                } else {
                                                                                    if(message[1].equalsIgnoreCase("Yuri")) {
                                                                                        vYurita.Yuri(commandEvent);

                                                                                    } else {
                                                                                        if(message[1].equalsIgnoreCase("Maurito")) {
                                                                                            Maurito.Mauri(commandEvent);

                                                                                        } else {
                                                                                            if(message[1].equalsIgnoreCase("Luqui")) {
                                                                                                LuquiMC.Luqui(commandEvent);

                                                                                            } else {
                                                                                                if(message[1].equalsIgnoreCase("Firre")){
                                                                                                    Firredrake.Firre(commandEvent);

                                                                                                } else {
                                                                                                        if(message[1].equalsIgnoreCase("Cneyer")) {
                                                                                                            Cneyer.Cnyr(commandEvent);

                                                                                                        } else {
                                                                                                            if(message[1].equalsIgnoreCase("Pato")) {
                                                                                                                PatoLand.Pato(commandEvent);

                                                                                                            } else {
                                                                                                                if(message[1].equalsIgnoreCase("Magic")) {
                                                                                                                    Magic.Magia(commandEvent);

                                                                                                                } else {
                                                                                                                    if(message[1].equalsIgnoreCase("Zeqia")) {
                                                                                                                        Zeqia.Zeq(commandEvent);

                                                                                                                    } else {
                                                                                                                        if(message[1].equalsIgnoreCase("Heis")) {
                                                                                                                            Heis.Hs(commandEvent);

                                                                                                                        } else {
                                                                                                                            if(message[1].equalsIgnoreCase("Juanjo")) {
                                                                                                                                TheJuanjo.Juanjo(commandEvent);

                                                                                                                            } else {
                                                                                                                                if(message[1].equalsIgnoreCase("Agus")) {
                                                                                                                                    Agus5534.Agus(commandEvent);

                                                                                                                                } else {
                                                                                                                                    if(message[1].equalsIgnoreCase("Conn")) {
                                                                                                                                        ConnG.Conn(commandEvent);

                                                                                                                                    } else {
                                                                                                                                        if(message[1].equalsIgnoreCase("Andrew")) {
                                                                                                                                            Andrew1091.Andrew(commandEvent);

                                                                                                                                        } else {
                                                                                                                                            if(message[1].equalsIgnoreCase("Zijhyan")) {
                                                                                                                                                Zijhyan.Zij(commandEvent);

                                                                                                                                            } else {
                                                                                                                                                if(message[1].equalsIgnoreCase("Mario")) {
                                                                                                                                                    Mario.Mrio(commandEvent);

                                                                                                                                                } else {
                                                                                                                                                    if(message[1].equalsIgnoreCase("Sub")) {
                                                                                                                                                        SubXaso.Sub(commandEvent);

                                                                                                                                                    } else {
                                                                                                                                                        if(message[1].equalsIgnoreCase("Gersoon")) {
                                                                                                                                                            Gersoon.Gerson(commandEvent);

                                                                                                                                                        } else {
                                                                                                                                                            if(message[1].equalsIgnoreCase("Tatu")) {
                                                                                                                                                                Taturc.Tatu(commandEvent);

                                                                                                                                                            } else {
                                                                                                                                                                if(message[1].equalsIgnoreCase("Salvador")) {
                                                                                                                                                                    Salvadorsss.Salvi(commandEvent);

                                                                                                                                                                } else {
                                                                                                                                                                    if(message[1].equalsIgnoreCase("Soul")) {
                                                                                                                                                                        Soul.Sl(commandEvent);

                                                                                                                                                                    } else {
                                                                                                                                                                        if(message[1].equalsIgnoreCase("Jungle")) {
                                                                                                                                                                            JungleFocus.Jungle(commandEvent);

                                                                                                                                                                        } else {
                                                                                                                                                                            if(message[1].equalsIgnoreCase("Tamara")) {
                                                                                                                                                                                Tamara1001.Tamara(commandEvent);

                                                                                                                                                                            } else {
                                                                                                                                                                                if(message[1].equalsIgnoreCase("Azgalord")) {
                                                                                                                                                                                    Azgalord.Azga(commandEvent);

                                                                                                                                                                                } else {
                                                                                                                                                                                    if(message[1].equalsIgnoreCase("Uimpi")) {
                                                                                                                                                                                        Uimpi.Uimp(commandEvent);

                                                                                                                                                                                    } else {
                                                                                                                                                                                        if(message[1].equalsIgnoreCase("Panda")) {
                                                                                                                                                                                            TheBoyPanda.Panda(commandEvent);

                                                                                                                                                                                        } else {
                                                                                                                                                                                            if(message[1].equalsIgnoreCase("Lucmus")) {
                                                                                                                                                                                                Lucmus.Luc(commandEvent);

                                                                                                                                                                                            } else {
                                                                                                                                                                                                if(message[1].equalsIgnoreCase("Eriksito")) {
                                                                                                                                                                                                    Eriksito.Erik(commandEvent);
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    if(message[1].equalsIgnoreCase("Zazil")) {
                                                                                                                                                                                                        Zazil.Zazi(commandEvent);
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        if(message[1].equalsIgnoreCase("Lexan")) {
                                                                                                                                                                                                            SrLexan.Lexan(commandEvent);
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            if(message[1].equalsIgnoreCase("Ayden")) {
                                                                                                                                                                                                                Ayden.Ayden(commandEvent);
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                if(message[1].equalsIgnoreCase("Weekend")) {
                                                                                                                                                                                                                    Weekend.Weekend(commandEvent);
                                                                                                                                                                                                                } else if(message[1].equalsIgnoreCase("NitaSorteadora")) {
                                                                                                                                                                                                                    NitaSorteadora.NitaSorteadora(commandEvent);
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    EmbedBuilder eb = new EmbedBuilder();
                                                                                                                                                                                                                    eb.setTitle("w/cumpleaños");
                                                                                                                                                                                                                    eb.setDescription("Uso: ```w/cumpleaños <persona>```");
                                                                                                                                                                                                                    eb.addField("Lista de personas:", "```Weekend, NitaSorteadora, Iki, Xrayos, Infernal, Celestial, Cuchi, Ayden, Rufk, Star, Evil, Eriksito, Juzo, Spiker, Nyrem, Augus, Flowii, Charly, Goge, MrComeGatos, Nita, Ivo, Yuri, Maurito, Luqui, Firre, Cneyer, Pato, Magic, Zeqia, Heis, Juanjo, Zazil, Agus, Conn, Andrew, Zijhyan, Mario, Sub, Gersoon, Tatu, Salvador, Soul, Jungle, Tamara, Azgalord, Uimpi, Panda, Lexan, Lucmus```", true);
                                                                                                                                                                                                                    eb.setColor(Color.RED);
                                                                                                                                                                                                                    channel.sendMessageEmbeds(eb.build()).queue();
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
        } catch(IndexOutOfBoundsException e) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("w/cumpleaños");
            eb.setDescription("Uso: ```w/cumpleaños <persona>```");
            eb.addField("Lista de personas:", "```Weekend, NitaSorteadora, Iki, Xrayos, Infernal, Celestial, Cuchi, Ayden, Rufk, Star, Evil, Eriksito, Juzo, Spiker, Nyrem, Augus, Flowii, Charly, Goge, MrComeGatos, Nita, Ivo, Yuri, Maurito, Luqui, Firre, Cneyer, Pato, Magic, Zeqia, Heis, Juanjo, Zazil, Agus, Conn, Andrew, Zijhyan, Mario, Sub, Gersoon, Tatu, Salvador, Soul, Jungle, Tamara, Azgalord, Uimpi, Panda, Lexan, Lucmus```", true);
            eb.setColor(Color.RED);
            channel.sendMessageEmbeds(eb.build()).queue();
        }

    }
}
