package com.nitasorteadora.bot.utils.cartashelper;

import static com.nitasorteadora.bot.Main.cooldowns;
import static com.nitasorteadora.bot.Main.cooldownsconfig;

public class CooldownManager {
    public static boolean hasCooldown(long id) {
        if(!cooldownsconfig.contains("Cooldown.Dailycard."+id)) {
            return false;
        } else {
            long ms = 0;
            ms = (long) cooldownsconfig.get("Cooldown.Dailycard."+id);
           if(ms - System.currentTimeMillis() <= 0) {
               return false;
           } else {
               return true;
           }
        }
    }

    public static void setCooldown(long id) {
        long cooldown = System.currentTimeMillis() + 14400000;
        cooldownsconfig.set("Cooldown.Dailycard."+id,cooldown);
        save();
    }

    public static long getCooldownLong(long id) {
        long ms = 0;
        ms = (long) cooldownsconfig.get("Cooldown.Dailycard."+id);
        return ms;
    }
    private static void save() {
        try {
            cooldownsconfig.save(cooldowns);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
