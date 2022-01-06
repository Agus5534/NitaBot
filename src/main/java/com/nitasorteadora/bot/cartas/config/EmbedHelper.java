package com.nitasorteadora.bot.cartas.config;

import net.dv8tion.jda.annotations.DeprecatedSince;
import net.dv8tion.jda.annotations.ForRemoval;
import net.dv8tion.jda.annotations.ReplaceWith;

import java.awt.*;
@Deprecated
@ForRemoval(deadline = "2.1.0")
@ReplaceWith("CartasHelper carta = new CartaHelper()")
@DeprecatedSince("2.0.0")
public interface EmbedHelper {
    //COLORES
    Color colorcomun = Color.GRAY;
    Color colorraro = Color.BLUE;
    Color colorepico = Color.MAGENTA;
    Color colorlegendario = Color.ORANGE;
    Color colorsecreto = Color.BLACK;

    //Embed Footer
    String comuns1footer = "Carta Común | Season 1";
    String comuns2footer = "Carta Común | Season 2";
    String comuns3footer = "Carta Común | Season 3";

    String raras1footer = "Carta Rara | Season 1";
    String raras2footer = "Carta Rara | Season 2";
    String raras3footer = "Carta Rara | Season 3";

    String epicas1footer = "Carta Épica | Season 1";
    String epicas2footer = "Carta Épica | Season 2";
    String epicas3footer = "Carta Épica | Season 3";

    String legens1footer = "Carta Legendaria | Season 1";
    String legens2footer = "Carta Legendaria | Season 2";
    String legenss3footer = "Carta Legendaria | Season 3";

    String secretas3footer = "Carta Secreta | Season 3";
}
