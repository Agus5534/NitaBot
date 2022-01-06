package com.nitasorteadora.bot.utils.cartashelper;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.entities.Member;

import java.io.IOException;

import static com.nitasorteadora.bot.Main.cartasconfig;

public class RemovedReset {
    //OBFUSCATED VOID NAME. JUST IGNORE IT
    public static void resetdawe(CommandEvent commandEvent) {
        int cartasdawe = 0;
        int cartasarnick = 0;
        int cartasfirre = 0;
        int total = 0;
        int tokens = 0;
        int desbloqueadas = 0;
        cartasdawe = (int) cartasconfig.get("CartaDawe."+commandEvent.getMessage().getAuthor().getId(),cartasdawe);
        cartasarnick = (int) cartasconfig.get("CartaArnick." + commandEvent.getMessage().getAuthor().getId(), cartasarnick);
        cartasfirre = (int) cartasconfig.get("CartaFirre."+commandEvent.getMessage().getAuthor().getId(),cartasfirre);
        desbloqueadas = (int) cartasconfig.get("Desbloqueadas."+commandEvent.getMessage().getAuthor().getId(),desbloqueadas);
        if(cartasfirre >= 1){
            total = (int) cartasconfig.get("Total."+commandEvent.getMessage().getAuthor().getId(),total);
            cartasconfig.set("CartaFirre."+commandEvent.getMessage().getAuthor().getId(), 0);
            desbloqueadas--;
            cartasconfig.set("Desbloqueadas."+commandEvent.getAuthor().getId(),desbloqueadas);
            int newtotal = total - cartasfirre;
            cartasconfig.set("Total."+commandEvent.getMessage().getAuthor().getId(), newtotal);
            int tokenstogive = tokens + (cartasfirre * 2);
            cartasconfig.set("Tokens."+commandEvent.getMessage().getAuthor().getId(),tokenstogive);
            try {
                commandEvent.getJDA().openPrivateChannelById(commandEvent.getAuthor().getId()).complete().sendMessage("Se te han eliminado del inventario " + cartasfirre + " El Aficionado! A cambio recibiste "+ tokenstogive + " tokens").queue();

            } catch (Exception e){
                return;
            }
            try{
                cartasconfig.save(Main.cartas);


            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(cartasdawe >= 1) {
            total = (int) cartasconfig.get("Total."+commandEvent.getMessage().getAuthor().getId(),total);
            cartasconfig.set("CartaDawe."+commandEvent.getMessage().getAuthor().getId(), 0);
            desbloqueadas = desbloqueadas - 1;
            cartasconfig.set("Desbloqueadas."+commandEvent.getMessage().getAuthor().getId(),desbloqueadas);
            int newtotal = total - cartasdawe;
            cartasconfig.set("Total."+commandEvent.getMessage().getAuthor().getId(), newtotal);
            tokens = (int) cartasconfig.get("Tokens."+commandEvent.getMessage().getAuthor().getId(), tokens);
            int tokenstogive = tokens + (cartasdawe * 4);
            cartasconfig.set("Tokens."+commandEvent.getMessage().getAuthor().getId(),tokenstogive);
            try {
                commandEvent.getJDA().openPrivateChannelById(commandEvent.getAuthor().getId()).complete().sendMessage("Se han eliminado cartas de tu inventario, a cambio te di " + tokenstogive + " tokens").queue();

            } catch (Exception e){
                return;
            }
            try{
                cartasconfig.save(Main.cartas);


            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(cartasarnick >= 1){
            total = (int) cartasconfig.get("Total."+commandEvent.getMessage().getAuthor().getId(),total);
            cartasconfig.set("CartaArnick."+commandEvent.getMessage().getAuthor().getId(), 0);
            desbloqueadas = desbloqueadas - 1;
            cartasconfig.set("Desbloqueadas."+commandEvent.getMessage().getAuthor().getId(),desbloqueadas);
            int newtotal = total - cartasarnick;
            cartasconfig.set("Total."+commandEvent.getMessage().getAuthor().getId(), newtotal);
            tokens = (int) cartasconfig.get("Tokens."+commandEvent.getMessage().getAuthor().getId(), tokens);
            int tokenstogive = tokens + (cartasarnick * 4);
            cartasconfig.set("Tokens."+commandEvent.getMessage().getAuthor().getId(),tokenstogive);
            try {
                commandEvent.getJDA().openPrivateChannelById(commandEvent.getAuthor().getId()).complete().sendMessage("Se han eliminado cartas de tu inventario, a cambio te di " + tokenstogive + " tokens").queue();

            } catch (Exception e){
                return;
            }
            try{
                cartasconfig.save(Main.cartas);


            } catch (IOException e){
                e.printStackTrace();
            }
        }


    }

    public static void resetdawe(Member target) {
        int cartasdawe = 0;
        int cartasarnick = 0;
        int total = 0;
        int tokens = 0;
        int desbloqueadas = 0;
        cartasdawe = (int) cartasconfig.get("CartaDawe."+target.getId(),cartasdawe);
        cartasarnick = (int) cartasconfig.get("CartaArnick." + target.getId(), cartasarnick);
        desbloqueadas = (int) cartasconfig.get("Desbloqueadas."+target.getId(),desbloqueadas);


        if(cartasdawe >= 1) {
            total = (int) cartasconfig.get("Total."+target.getId(),total);
            cartasconfig.set("CartaDawe."+target.getId(), 0);
            desbloqueadas = desbloqueadas - 1;
            cartasconfig.set("Desbloqueadas."+target.getId(),desbloqueadas);
            int newtotal = total - cartasdawe;
            cartasconfig.set("Total."+target.getId(), newtotal);
            tokens = (int) cartasconfig.get("Tokens."+target.getId(), tokens);
            int tokenstogive = tokens + (cartasdawe * 4);
            cartasconfig.set("Tokens."+target.getId(),tokenstogive);
            try {
                target.getUser().openPrivateChannel().complete().sendMessage("Se han eliminado cartas de tu inventario, a cambio te di " + tokenstogive + " tokens").queue();

            } catch (Exception e) {
                return;
            }
            try{
                cartasconfig.save(Main.cartas);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(cartasarnick >= 1){
            total = (int) cartasconfig.get("Total."+target.getId(),total);
            cartasconfig.set("CartaArnick."+target.getId(), 0);
            int newtotal = total - cartasarnick;
            desbloqueadas = desbloqueadas - 1;
            cartasconfig.set("Desbloqueadas."+target.getId(),desbloqueadas);
            cartasconfig.set("Total."+target, newtotal);
            tokens = (int) cartasconfig.get("Tokens."+target.getId(), tokens);
            int tokenstogive = tokens + (cartasarnick * 4);
            cartasconfig.set("Tokens."+target.getId(),tokenstogive);
            try {
                target.getUser().openPrivateChannel().complete().sendMessage("Se han eliminado cartas de tu inventario, a cambio te di " + tokenstogive + " tokens").queue();

            } catch (Exception e){
                return;
            }
            try{
                cartasconfig.save(Main.cartas);


            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
