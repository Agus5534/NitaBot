package com.nitasorteadora.bot.utils

import java.util.*

class VerControl {

    private val versionProperties = Properties()
    init {
        versionProperties.load(this.javaClass.getResourceAsStream("/version.properties"))
    }

   fun getVersion() : String = versionProperties.getProperty("version") ?: "No se encontro"



}