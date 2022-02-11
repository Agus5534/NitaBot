package com.nitasorteadora.bot.utils.cartashelper;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.Main;
import com.nitasorteadora.bot.cartas.embeds.CartaC;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;
import net.dv8tion.jda.api.EmbedBuilder;
import okhttp3.internal.http2.ErrorCode;

import java.awt.*;

import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.*;


public class CartasHelper {
    String nombrecarta;
    String autorcarta;
    Color color;
    String imagencalidad;
    String imagencarta;
    String footer;
    String emote;
    String nombrebasedatos;
    String title = "¡Carta diaria!";
    char calidad;
    int season;
    int cantcartas = 0;
    int total = 0;
    int desbloqueadas = 0;
    CartaC carta;
    @Deprecated()
    public CartasHelper(CommandEvent commandEvent) {
        super();
    }

    public CartasHelper(CommandEvent commandEvent, CartaC carta) {
        super();
        this.carta = carta;
    }


    public CartasHelper cardName(String _nombrecarta) {
        if(!_nombrecarta.isEmpty()) {
            nombrecarta = _nombrecarta;
        } else {
            throw new StringIndexOutOfBoundsException("No se proporcionó un nombre de la carta!");
        }
        return this;
    }
    public CartasHelper author(String _autocarta) {
        if(!_autocarta.isEmpty()) {
            autorcarta = _autocarta;
        } else {
            throw new StringIndexOutOfBoundsException("No se proporcionó un nombre de la carta!");
        }
        return this;
    }
    public CartasHelper emote(String emoteid) {
        if(!emoteid.isEmpty()) {
            emote = emoteid;
        } else {
            throw new StringIndexOutOfBoundsException("No se proporcionó un emote!");
        }
        return this;
    }
    public CartasHelper image(String _imagencarta) {
        if(!_imagencarta.isEmpty()) {
            imagencarta = _imagencarta;
        } else {
            throw new StringIndexOutOfBoundsException("No se proporcionó una imagen!");
        }

        return this;
    }
    public CartasHelper dbName(String _dbname) {
        if(_dbname.startsWith("Carta") && _dbname.endsWith(".")) {
            nombrebasedatos = _dbname;
        } else {
            throw new StringIndexOutOfBoundsException("Nombre de base de datos inválido");
        }
        return this;
    }
    public CartasHelper season(int _season) {
        if(_season >= 0 && _season <= 3) {
            season = _season;
        } else {
            throw new IndexOutOfBoundsException(String.format("No existe la season %s", _season));
        }


        return this;
    }

    //CALIDADES
    public CartasHelper esComun() {
        imagencalidad = "https://cdn.discordapp.com/attachments/818995908779835393/835349936568401939/comun.png";
        calidad = 'c';
        color = Color.GRAY;
        if(carta.getSeason() == 0) {
            footer = "Carta Común | Out of season";
        } else {
            footer = "Carta Común | Season " + carta.getSeason();
        }
        return this;
    }
    public CartasHelper esRara() {
        imagencalidad = "https://cdn.discordapp.com/attachments/818995908779835393/835349958122143825/raro.png";
        calidad = 'r';
        color = Color.BLUE;
        if(carta.getSeason() == 0) {
            footer = "Carta Rara | Out of season";
        } else {
            footer = "Carta Rara | Season " + carta.getSeason();
        }
        return this;
    }
    public CartasHelper esEpica() {
        imagencalidad = "https://cdn.discordapp.com/attachments/818995908779835393/835349972265205769/epico.png";
        calidad = 'e';
        color = Color.MAGENTA;
        if(carta.getSeason() == 0) {
            footer = "Carta Épica | Out of season";
        } else {
            footer = "Carta Épica | Season " + carta.getSeason();
        }
        return this;
    }
    public CartasHelper esLegendaria() {
        imagencalidad = "https://cdn.discordapp.com/attachments/818995908779835393/835349989952978994/legendario.png";
        calidad = 'l';
        color = Color.ORANGE;
        if(carta.getSeason() == 0) {
            footer = "Carta Legendaria | Out of season";
        } else {
            footer = "Carta Legendaria | Season " + carta.getSeason();
        }
        return this;
    }
    public CartasHelper esSecreta() {
        imagencalidad = "https://nullxd";
        calidad = 's';
        color = Color.BLACK;
        footer = "Carta Secreta | Season " + season;
        return this;
    }
    public CartasHelper esMitica() {
        imagencalidad = "https://cdn.discordapp.com/attachments/818995908779835393/939229794455924816/miticathumbnail.png";
        calidad = 'm';
        color = Color.BLACK;
        if(carta.getSeason() == 0) {
            footer = "Carta Mítica | Out of season";
        } else {
            footer = "Carta Mítica | Season " + carta.getSeason();
        }
        return this;
    }


    public final CartasHelper build(CommandEvent commandEvent) throws CreateCardException {
        title = "¡Carta diaria!";
        String desc = "Obtuviste: **"+ nombrecarta + "** ";
        if(nombrecarta.isEmpty() || autorcarta.isEmpty() || imagencarta.isEmpty() || emote.isEmpty()) {
            commandEvent.getChannel().sendMessage("Ha ocurrido un error grave").queue();
            String allinfo = "\n" + "NombreCarta: " + nombrecarta + "\n" + "AutorCarta: " + autorcarta + "\n" + "ImagenCarta: <" + imagencarta + ">" + "\n" + "Season: " + season + "\n" + "DataBaseName: " + nombrebasedatos;
            commandEvent.getJDA().getGuildById("779862254807547926").getTextChannelById("818993382910066688").sendMessage("Ha ocurrido un error fatal al construir un embed. He recopilado la siguiente info: " + allinfo).queue();

        }


        //TOKENS
        int random = (int) (Math.random() * 100 + 1);
        if(random >= 18 && random <= 32) {
            int random2 = (int) (Math.random() * 4 + 1);
            int gettokens = 0;
            gettokens = (int) cartasconfig.get("Tokens."+commandEvent.getAuthor().getId(), gettokens);
            int tokenstoset = gettokens + Integer.valueOf(random2);
            cartasconfig.set("Tokens."+commandEvent.getAuthor().getId(), tokenstoset);
            commandEvent.getChannel().sendMessage("Extra! Has ganado " + random2 + " tokens!").queue();
            try {
                cartasconfig.save(Main.cartas);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        //TOKENS

        //DATABASE
        cantcartas = (int) cartasconfig.get(nombrebasedatos+commandEvent.getAuthor().getId(), cantcartas);
        total = (int) cartasconfig.get("Total."+commandEvent.getAuthor().getId(),total);
        total++;
        cartasconfig.set("Total."+commandEvent.getAuthor().getId(),total);
        cantcartas++;
        cartasconfig.set(nombrebasedatos+commandEvent.getAuthor().getId(),cantcartas);
        if(cantcartas == 1) {
            desbloqueadas = (int) cartasconfig.get("Desbloqueadas."+commandEvent.getAuthor().getId(),desbloqueadas);
            desbloqueadas++;
            cartasconfig.set("Desbloqueadas."+commandEvent.getAuthor().getId(),desbloqueadas);
            title = ":sparkles: ¡Carta diaria! :sparkles:";
            desc = ":unlock: Obtuviste: **"+ nombrecarta + "** ";
        }
        try {
            cartasconfig.save(Main.cartas);
        } catch (Exception e){
            commandEvent.getChannel().sendMessage("No se pudo guardar en la base de datos!").queue();
            throw new CreateCardException("No se pudo crear la carta", e, ErrorCode.INTERNAL_ERROR);
        }

        if(calidad == 'c' || calidad == 'r') {
            addLuck(commandEvent, 1);
        } else if(calidad == 'e') {
            randomLuck(commandEvent);
        } else if(calidad == 'l') {
        randomLuck2(commandEvent);
        } else if(calidad == 's' || calidad == 'm') {
        resetLuck(commandEvent);
        } else {
            addLuck(commandEvent, 1);
        }
        //DATABASE

        //EMBED
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(title);
        eb.setDescription(desc);
        //https://cdn.discordapp.com/emojis/871851399628079184.png?size=80
        eb.setThumbnail("https://cdn.discordapp.com/emojis/"+carta.getEmoteid()+".png?size=80");
        eb.setImage(carta.getImage());
        eb.setFooter(footer);
        eb.setColor(color);
        commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
        //EMBED

        return this;
    }




}
