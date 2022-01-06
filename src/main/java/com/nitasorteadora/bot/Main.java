package com.nitasorteadora.bot;


import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.minecraft.commands.Verificar;
import com.nitasorteadora.bot.minecraft.events.DeathEvent;
import com.nitasorteadora.bot.minecraft.events.JoinEvent;
import com.nitasorteadora.bot.utils.sql.SqlConnector;
import com.nitasorteadora.bot.utils.version.Updateinador3500;
import net.dv8tion.jda.api.EmbedBuilder;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@SuppressWarnings("all")

public class Main extends JavaPlugin implements Listener {

    public static File cartas;
    public static FileConfiguration cartasconfig;
    public static File claimed;
    public static FileConfiguration claimedconfig;
    public static File cooldowns;
    public static FileConfiguration cooldownsconfig;
    public static File accounts;
    public static FileConfiguration accountsconfig;
    public static File tokens;
    public static FileConfiguration tokensconfig;
    public File sqldata;
    public FileConfiguration sqldataconfig;
    private ConfigHandler configHandler;
    private JDAHandler jdaHandler;
    public static String estados;
    private SqlConnector sqlConnector;
    private void createFiles() {
        sqldata = new File(getDataFolder() + File.separator + "sqldata.yml");
        if(!sqldata.exists()) {
            this.saveResource("sqldata.yml",true);
        }
        sqldataconfig = new YamlConfiguration();
        try {
            sqldataconfig.load(sqldata);
        }catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
        tokens = new File(getDataFolder() + File.separator + "nocompartas.yml");
        if(!tokens.exists()) {
            this.saveResource("nocompartas.yml", true);
        }

        tokensconfig = new YamlConfiguration();
        try {
            tokensconfig.load(tokens);
        }catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }


        cartas = new File(getDataFolder() + File.separator + "cartas.yml");
        if(!cartas.exists()) {
            getLogger().info("Creando base de datos...");

            this.saveResource("cartas.yml", false);
        }
            cartasconfig = new YamlConfiguration();
            try {
                cartasconfig.load(cartas);
            } catch (IOException | InvalidConfigurationException e){
                e.printStackTrace();
            }

            claimed = new File(getDataFolder() + File.separator + "claimed.yml");
            if(!claimed.exists()) {
                this.saveResource("claimed.yml", false);
            }
            claimedconfig = new YamlConfiguration();
            try {
                claimedconfig.load(claimed);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }

            cooldowns = new File(getDataFolder() + File.separator + "cooldowns.yml");
            if(!cooldowns.exists()){
                this.saveResource("cooldowns.yml",false);
            }
            cooldownsconfig = new YamlConfiguration();
            try {
                cooldownsconfig.load(cooldowns);
            }  catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
            accounts = new File(getDataFolder() + File.separator + "accounts.yml");
            if(!accounts.exists()) {
                this.saveResource("accounts.yml",false);
            }
            accountsconfig = new YamlConfiguration();
            try {
                accountsconfig.load(accounts);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void onEnable() {
        createFiles();
        configHandler = new ConfigHandler(this);
        initialize();
        getServer().getPluginManager().registerEvents(this, this);
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new JoinEvent(this), this);
        pm.registerEvents(new DeathEvent(),this);
        this.getCommand("verificar").setExecutor(new Verificar());
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () ->{
            new Updateinador3500(this).check();
        }, 1200L, 108000L);
        //new LowTps(this).lowTPSWarn();
    }
    @Override
    public void onDisable() {
        getLogger().severe("Desactivando NitaSorteadora");
        try {
            shutdown();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        jdaHandler = new JDAHandler(this);
        jdaHandler.startBot(configHandler);
        sqlConnector = new SqlConnector(this);
        sqlConnector.openConnection();
    }

    private void shutdown() throws SQLException {
        jdaHandler.shutdownBot();
        sqlConnector.closeConnection();
    }
    public Connection getConn() {
        return sqlConnector.getConnection();
    }
    public static void errorembed(CommandEvent commandEvent, String title, String description, String field1title, String field1body, String field2title, String field2body, String field3title, String field3body, String footer, @NotNull boolean enableddesc, @NotNull boolean field1, @NotNull boolean field2, @NotNull boolean field3, @NotNull boolean enabledfooter, Color embedcolor) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(title);
        eb.setColor(embedcolor);
        if(enableddesc) {
            eb.setDescription(description);
        }
        if(field1) {
            eb.addField(field1title, field1body, true);
        }
        if(field2) {
            eb.addField(field2title, field2body, true);
        }
        if(field3) {
            eb.addField(field3title, field3body, true);
        }
        if(enabledfooter) {
            eb.setFooter(footer);
        }
        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
    }






}
