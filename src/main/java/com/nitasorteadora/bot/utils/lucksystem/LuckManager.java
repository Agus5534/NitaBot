package com.nitasorteadora.bot.utils.lucksystem;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.entities.Member;

import static com.nitasorteadora.bot.Main.cartasconfig;

public class LuckManager {

    public static int getLuckfortarget(Member target) {
        int luck = 0;
        checkLuckforTarget(target);
        luck = (int) cartasconfig.get("Suerte."+target.getId(), luck);
        return luck;
    }

    public static int getLuck(CommandEvent commandEvent) {
       int luck = 0;
        checkLuck(commandEvent);
        luck = (int) cartasconfig.get("Suerte."+commandEvent.getAuthor().getId(), luck);
        return luck;
    }

    public static void addLuck(CommandEvent commandEvent, int lucktoadd) {
        checkLuck(commandEvent);
        int luck = 0;
        luck = (int) cartasconfig.get("Suerte."+commandEvent.getAuthor().getId(), luck);
        int lucktoset = luck + lucktoadd;
        cartasconfig.set("Suerte."+commandEvent.getAuthor().getId(), lucktoset);
        saveData();

    }
    public static void resetLuck(CommandEvent commandEvent) {
        checkLuck(commandEvent);
        int luck = 1;
        cartasconfig.set("Suerte."+commandEvent.getAuthor().getId(), luck);
        saveData();
    }
    private static void removeLuck(CommandEvent commandEvent, int lucktoremove) {
        checkLuck(commandEvent);
        int luck = 0;
        luck = (int) cartasconfig.get("Suerte."+commandEvent.getAuthor().getId(), luck);
        int lucktoset = luck - lucktoremove;
        cartasconfig.set("Suerte."+commandEvent.getAuthor().getId(), lucktoset);
        saveData();
    }
    public static void randomLuck(CommandEvent commandEvent){
        int random = (int) (Math.random() * 100 + 1);
        if(random < 40) {
            addLuck(commandEvent, 1);
        } else if(random < 80) {
            if(getLuck(commandEvent) >= 2) {
                removeLuck(commandEvent, 1);
            } else {
                resetLuck(commandEvent);
                //addLuck(commandEvent, 1);
            }
        } else {
            resetLuck(commandEvent);
        }
    }
    public static void randomLuck2(CommandEvent commandEvent) {
        int random = (int) (Math.random() * 100 + 1);
        if(random < 35) {
            addLuck(commandEvent, 1);
        } else if(random < 95) {
                resetLuck(commandEvent);
               // addLuck(commandEvent, 1);
        } else {
           if(getLuck(commandEvent) >= 2) {
               removeLuck(commandEvent, 1);
           } else {
               resetLuck(commandEvent);
           }
        }
    }

    public static void checkLuck(CommandEvent commandEvent) {
        if(!cartasconfig.contains("Suerte."+commandEvent.getMessage().getAuthor().getId())) {
            int suerte = 1;
            cartasconfig.set("Suerte." + commandEvent.getMessage().getAuthor().getId(), suerte);
            saveData();
        }
    }

    public static void checkLuckforTarget(Member target) {
        if(!cartasconfig.contains("Suerte."+target.getId())) {
            int suerte = 1;
            cartasconfig.set("Suerte." + target.getId(), suerte);
            saveData();
        }
    }
    private static void saveData() {
        try {
            cartasconfig.save(Main.cartas);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
