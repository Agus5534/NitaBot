package com.nitasorteadora.bot.cartas.embeds;

import java.awt.*;

public enum CalidadC {
    COMUN("Común",Color.GRAY),
    RARA("Rara",Color.BLUE),
    EPICA("Épica",Color.MAGENTA),
    LEGENDARIA("Legendaria",Color.ORANGE),
    MITICA("Mítica",Color.GREEN),
    SECRETA("Secreta",Color.BLACK);

    private String name;
    private Color color;
    CalidadC(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
