package com.nitasorteadora.bot.utils.cartashelper;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.entities.Member;

import java.io.IOException;

import static com.nitasorteadora.bot.Main.cartasconfig;

public class RemovedReset {

    public void removeCarta(String dbName,CommandEvent commandEvent) {
        int cartacant = 0;
        cartacant = (int) cartasconfig.get(dbName+commandEvent.getAuthor().getId(),cartacant);
        cartasconfig.set(dbName+commandEvent.getAuthor().getId(),0);
        if(cartacant >= 1) {
            int desbloqueadas = 0;
            int total = 0;
            int tokens = 0;
            total = (int) cartasconfig.get("Total."+commandEvent.getMessage().getAuthor().getId(),total);
            desbloqueadas = (int) cartasconfig.get("Desbloqueadas."+commandEvent.getMessage().getAuthor().getId(),desbloqueadas);
            desbloqueadas--;
            cartasconfig.set("Desbloqueadas."+commandEvent.getAuthor().getId(),desbloqueadas);
            int newtotal = total - cartacant;
            cartasconfig.set("Total."+commandEvent.getAuthor().getId(),newtotal);
            try{
                cartasconfig.save(Main.cartas);


            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    public static void resetdawe(CommandEvent commandEvent) {
       /* int cartasdawe = 0;
        int cartasarnick = 0;
        int cartasfirre = 0;
        int cartacel = 0;
        int cartagersoon = 0;
        int cartajuanjo = 0;
        int cartazeq = 0;
        int cartagiantek = 0;
        int cartacneyer = 0;
        int cartajg = 0;
        int cartatamara = 0;
        int cartaxrayos = 0;
        int cartacomegatos = 0;
        int cartasoul = 0;
        int cartajuzo = 0;
        int total = 0;
        int tokens = 0;
        int desbloqueadas = 0;
        String id = commandEvent.getMessage().getAuthor().getId();
        cartasdawe = (int) cartasconfig.get("CartaDawe."+commandEvent.getMessage().getAuthor().getId(),cartasdawe);
        cartasarnick = (int) cartasconfig.get("CartaArnick." + commandEvent.getMessage().getAuthor().getId(), cartasarnick);
        cartasfirre = (int) cartasconfig.get("CartaFirre."+commandEvent.getMessage().getAuthor().getId(),cartasfirre);
        cartacel = (int) cartasconfig.get("CartaCel."+id,cartacel);
        cartagersoon = (int) cartasconfig.get("CartaGersoon."+id,cartagersoon);
        cartajuanjo = (int) cartasconfig.get("CartaJuanjo."+id,cartajuanjo);
        cartazeq = (int) cartasconfig.get("CartaZeqia."+id,cartazeq);
        cartagiantek = (int) cartasconfig.get("CartaGiantek."+id,cartagiantek);
        cartacneyer = (int) cartasconfig.get("CartaCneyer."+id,cartacneyer);
        cartajg = (int) cartasconfig.get("CartaJungle."+id,cartajg);
        cartatamara = (int) cartasconfig.get("CartaTamara."+id,cartatamara);
        cartaxrayos = (int) cartasconfig.get("CartaXRayos."+id,cartaxrayos);
        cartacomegatos = (int) cartasconfig.get("CartaMrComeGatos."+id,cartacomegatos);
        cartasoul = (int) cartasconfig.get("CartaSoul."+id,cartasoul);
        cartajuzo = (int) cartasconfig.get("CartaJuzo."+id,cartajuzo);
        desbloqueadas = (int) cartasconfig.get("Desbloqueadas."+commandEvent.getMessage().getAuthor().getId(),desbloqueadas);
        if(cartacel >= 1) {
            removeCarta("CartaCel.",cartacel,6,commandEvent,"El Escandaloso");
        }
        if(cartagersoon >= 1){
            removeCarta("CartaGersoon.",cartagersoon,2,commandEvent,"El Recopilador");
        }
        if(cartajuanjo >= 1) {
            removeCarta("CartaJuanjo.",cartajuanjo,6,commandEvent,"El Técnico");
        }
        if(cartazeq >= 1){
            removeCarta("CartaZeqia.",cartazeq,2,commandEvent,"El Mudo");
        }
        if(cartagiantek >= 1) {
            removeCarta("CartaGiantek.",cartagiantek,2,commandEvent,"El Pelotudo");
        }
        if(cartacneyer >= 1) {
            removeCarta("CartaCneyer.",cartacneyer,4,commandEvent,"El Aplanador");
        }
        if(cartajg >= 1) {
            removeCarta("CartaJungle.",cartajg,4,commandEvent,"El Humilde");
        }
        if(cartatamara >= 1) {
            removeCarta("CartaTamara.",cartatamara,2,commandEvent,"La Dedicada");
        }
        if(cartaxrayos >= 1) {
            removeCarta("CartaXRayos.",cartaxrayos,2,commandEvent,"El Tímido");
        }
        if(cartacomegatos >= 1){
            removeCarta("CartaMrComeGatos.",cartacomegatos,2,commandEvent,"El Hayabusa");
        }
        if(cartasoul >= 1){
            removeCarta("CartaSoul.",cartasoul,2,commandEvent,"El Perdido");
        }
        if(cartajuzo >= 1) {
            removeCarta("CartaJuzo.",cartajuzo,2,commandEvent,"La Inexperta");
        }
        if(cartasfirre >= 1){
            total = (int) cartasconfig.get("Total."+commandEvent.getMessage().getAuthor().getId(),total);
            cartasconfig.set("CartaFirre."+commandEvent.getMessage().getAuthor().getId(), 0);
            desbloqueadas--;
            cartasconfig.set("Desbloqueadas."+commandEvent.getAuthor().getId(),desbloqueadas);
            int newtotal = total - cartasfirre;
            cartasconfig.set("Total."+commandEvent.getMessage().getAuthor().getId(), newtotal);
            tokens = (int) cartasconfig.get("Tokens."+commandEvent.getMessage().getAuthor().getId(), tokens);
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

*/
    }

    public static void resetdawe(Member target) {
       /* int cartasdawe = 0;
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
    */}
}
