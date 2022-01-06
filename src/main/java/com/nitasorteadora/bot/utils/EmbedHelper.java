package com.nitasorteadora.bot.utils;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.time.Instant;

public class EmbedHelper extends EmbedBuilder{
    public EmbedHelper(final EmbedBuilder embedBuilder) {
        super(embedBuilder);

    }
    public EmbedHelper author(final String author, final String url, String iconurl) {
        if(url == null) {
            setAuthor(author, "https://asdd.com", iconurl);
            return this;
        } else if(iconurl == null) {
            setAuthor(author, url, "https://asdd.com");
            return this;
        } else {
            if(url == null && iconurl == null) {
                setAuthor(author);
                return this;
            } else {
                setAuthor(author, url, iconurl);
                return this;
            }

        }


    }
    public EmbedHelper title(final String title, final String url) {
        if(url == null) {
            setTitle(title);
            return this;
        } else {
            setTitle(title, url);
            return this;
        }


    }
    public EmbedHelper footer(final String footer, final String iconurl){
        if(iconurl == null) {
            setFooter(footer);
            return this;
        } else {
            setFooter(footer, iconurl);
            return this;
        }

    }
    public EmbedHelper fields(String[] fieldtitles, String[] fieldcontents){
        for (int x = 0; x < fieldcontents.length; x++) {
            for (int y = 0; y < fieldtitles.length; y++) {
                addField(fieldtitles[y + x], fieldcontents[x], false);
                break;
            }
        }
        return this;
    }
    public EmbedHelper color(final Color color) {
        setColor(color);
        return this;
    }
    public EmbedHelper timestamp(final Instant instant) {
        setTimestamp(instant);
        return this;
    }
    public EmbedHelper image(final String url) {
        setImage(url);
        return this;
    }
    public EmbedHelper thumbnail(final String url) {
        setThumbnail(url);
        return this;
    }


}
