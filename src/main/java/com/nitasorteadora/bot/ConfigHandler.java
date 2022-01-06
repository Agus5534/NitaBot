package com.nitasorteadora.bot;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;
public class ConfigHandler {
    private static Logger logger;
    private static FileConfiguration config;
    private static Set<String> adminsInSet;
    private static String[] adminsInArray;
    private static Set<String> betasInSet;
    private static String[] betasInArray;
    private final JavaPlugin bot;

    public ConfigHandler(final JavaPlugin bot) {
        this.bot = bot;
        logger = bot.getLogger();
        config = bot.getConfig();

        reloadConfig();
    }
    public void reloadConfig() {
        bot.saveDefaultConfig();
        bot.reloadConfig();
        config = bot.getConfig();
        String adminsWithCommas = getSetting("admins");
        adminsInArray = adminsWithCommas.split(",");
        adminsInSet = new HashSet<>(Arrays.asList(adminsInArray));
        String betasWithCommas = getSetting("beta");
        betasInArray = betasWithCommas.split(",");
        betasInSet = new HashSet<>(Arrays.asList(betasInArray));
        try {
            cartasconfig.save(cartas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Set<String> getAdmins() {
        return adminsInSet;
    }

    public static String getAdmin(int admin) {
        return adminsInArray[admin];
    }

    public static Set<String> getBetas() { return betasInSet; }

    public static String getBeta(int beta) { return betasInArray[beta]; }

    public static Logger getLogger() {
        return logger;
    }

    public static String getSetting(String setting) {
        return config.getString(setting);
    }

    public static FileConfiguration getConfig() {
        return config;
    }

    public JavaPlugin getBot() {
        return bot;
    }
}
