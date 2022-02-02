package com.nitasorteadora.bot.utils.cartashelper;

public enum SobresType {
    COMUN("SobreComun.",13),
    RARO("SobreRaro.",17),
    EPICO("SobreEpico.",21);

    private String dbName;
    private int coste;
    SobresType(String dbName, int coste) {
        this.dbName = dbName;
        this.coste = coste;
    }

    public String getDbName() {
        return dbName;
    }

    public int getCoste() {
        return coste;
    }
}
