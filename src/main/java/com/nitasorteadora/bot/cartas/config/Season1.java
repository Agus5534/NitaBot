package com.nitasorteadora.bot.cartas.config;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.cartas.config.rng.season1.ComunesS1;
import com.nitasorteadora.bot.cartas.config.rng.season1.EpicasS1;
import com.nitasorteadora.bot.cartas.config.rng.season1.LegendariasS1;
import com.nitasorteadora.bot.cartas.config.rng.season1.RarasS1;

import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuck;

public class Season1 {

    public static void CartasS1(CommandEvent commandEvent) {
        if(getLuck(commandEvent) >= 0 && getLuck(commandEvent) <= 4) {
            lucklvl1(commandEvent);
        } else if(getLuck(commandEvent) >=5 && getLuck(commandEvent) <= 8) {
            lucklvl2(commandEvent);
        } else if(getLuck(commandEvent) >=9 && getLuck(commandEvent) <= 12) {
            lucklvl3(commandEvent);
        } else if(getLuck(commandEvent) >=13 && getLuck(commandEvent) <=16){
            lucklvl4(commandEvent);
        } else if(getLuck(commandEvent) >= 17 && getLuck(commandEvent) <=20) {
            lucklvl5(commandEvent);
        } else if(getLuck(commandEvent) >= 21) {
            lucklvl6(commandEvent);
        }

    }
    public static void lucklvl1(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 50) {
            ComunesS1.ComS1(commandEvent);
        } else {
            if(random < 85) {
                RarasS1.RarS1(commandEvent);
            } else {
                if(random < 97) {
                    EpicasS1.EpicS1(commandEvent);
                } else {
                    if(random < 100) {
                        LegendariasS1.LegS1(commandEvent);
                    } else {
                        Season3.CartasS3(commandEvent);
                    }
                }
            }
        }
    }
    public static void lucklvl2(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 40) {
            ComunesS1.ComS1(commandEvent);
        } else {
            if(random < 85) {
                RarasS1.RarS1(commandEvent);
            } else {
                if(random < 97) {
                    EpicasS1.EpicS1(commandEvent);
                } else {
                    if(random < 100) {
                        LegendariasS1.LegS1(commandEvent);
                    } else {
                        Season3.CartasS3(commandEvent);
                    }
                }
            }
        }
    }
    public static void lucklvl3(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 30) {
            ComunesS1.ComS1(commandEvent);
        } else {
            if(random < 75) {
                RarasS1.RarS1(commandEvent);
            } else {
                if(random < 97) {
                    EpicasS1.EpicS1(commandEvent);
                } else {
                    if(random < 100) {
                        LegendariasS1.LegS1(commandEvent);
                    } else {
                        Season3.CartasS3(commandEvent);
                    }
                }
            }
        }
    }
    public static void lucklvl4(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 30) {
            ComunesS1.ComS1(commandEvent);
        } else {
            if(random < 75) {
                RarasS1.RarS1(commandEvent);
            } else {
                if(random < 92) {
                    EpicasS1.EpicS1(commandEvent);
                } else {
                    if(random < 100) {
                        LegendariasS1.LegS1(commandEvent);
                    } else {
                        Season3.CartasS3(commandEvent);
                    }
                }
            }
        }
    }
    private static void lucklvl5(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 20) {
            ComunesS1.ComS1(commandEvent);
        } else {
            if(random < 65) {
                RarasS1.RarS1(commandEvent);
            } else {
                if(random < 89) {
                    EpicasS1.EpicS1(commandEvent);
                } else {
                    if(random < 100) {
                        LegendariasS1.LegS1(commandEvent);
                    } else {
                        Season3.CartasS3(commandEvent);
                    }
                }
            }
        }
    }
    private static void lucklvl6(CommandEvent commandEvent){
        int random = (int) (Math.random() * 100 + 1);
        if(random < 15) {
            ComunesS1.ComS1(commandEvent);
        } else {
            if(random < 55) {
                RarasS1.RarS1(commandEvent);
            } else {
                if(random < 80) {
                    EpicasS1.EpicS1(commandEvent);
                } else {
                    if(random < 100) {
                        LegendariasS1.LegS1(commandEvent);
                    } else {
                        Season3.CartasS3(commandEvent);
                    }
                }
            }
        }
    }
}
