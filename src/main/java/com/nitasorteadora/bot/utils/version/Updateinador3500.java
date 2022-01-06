package com.nitasorteadora.bot.utils.version;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nitasorteadora.bot.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Updateinador3500 {
    Main plugin;
    public Updateinador3500(Main plugin) {
        this.plugin = plugin;
    }
    public void check() {
        String latestversion = getLatestRelease().get("name").getAsString();
        PluginDescriptionFile pdf = plugin.getDescription();
        if(!latestversion.equalsIgnoreCase(pdf.getVersion())) {
            Bukkit.getLogger().warning("Se ha encontrado una nueva versión: " + latestversion + ". Usando actualmente: " + pdf.getVersion());
        } else {
            Bukkit.getLogger().info("Se está utilizando la última versión!");
        }
    }

    private JsonObject getLatestRelease() {
        try{
            URL url = new URL("https://api.github.com/repos/Agus5534/NitaBot/releases/latest");
            URLConnection request = url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootobj = root.getAsJsonObject();
            return rootobj;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
