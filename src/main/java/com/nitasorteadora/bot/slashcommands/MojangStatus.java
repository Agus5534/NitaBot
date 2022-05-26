package com.nitasorteadora.bot.slashcommands;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jagrosh.jdautilities.command.SlashCommand;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MojangStatus extends SlashCommand {
    public MojangStatus() {
        this.name = "mojangstatus";
        this.help = "Revisa el estado de la API de Mojang";
    }

    @Override
    protected void execute(SlashCommandEvent event) {
    }
}
class APIFetcher {
    private JsonArray JsonReader() throws IOException {
        URL url = new URL("https://mojan.ga/api/check");
        URLConnection request = url.openConnection();
        request.connect();
        JsonParser jsonParser = new JsonParser();
        JsonElement root = jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonArray rootarray = root.getAsJsonArray();
        return rootarray;
    }
    public boolean isOperational(APILink apiLink) throws IOException{
        return JsonReader().get(apiLink.getIndex()).getAsJsonObject().get(apiLink.getKey()).getAsString().equals("green");
    }
}
enum APILink {
    MinecraftDotNet(0,"minecraft.net"),
    SessionDotMinecraftDotNet(1, "session.minecraft.net"),
    @Deprecated AccountDotMojangDotCom(2, "account.mojang.com"),
    AuthserverDotMojangDotCom(3,"authserver.mojang.com"),
    SessionserverDotMojangDotCom(4,"sessionserver.mojang.com"),
    ApiDotMojangDotCom(5,"api.mojang.com"),
    TexturesDotMinecraftDotNet(6,"textures.minecraft.net"),
    @Deprecated MojangDotCom(7,"mojang.com");



    private int index;
    private String key;

    APILink(int index, String key) {
        this.index = index;
        this.key = key;
    }
    public int getIndex() {
        return index;
    }

    public String getKey() {
        return key;
    }

}
