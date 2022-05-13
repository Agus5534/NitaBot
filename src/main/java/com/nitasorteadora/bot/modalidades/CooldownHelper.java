package com.nitasorteadora.bot.modalidades;

import static com.nitasorteadora.bot.Main.cooldowns;
import static com.nitasorteadora.bot.Main.cooldownsconfig;

public class CooldownHelper {
        public boolean hasCooldown(long id) {
            if(!cooldownsconfig.contains("Cooldown.Modalidad."+id)) {
                return false;
            } else {
                long ms = 0;
                ms = (long) cooldownsconfig.get("Cooldown.Modalidad."+id);
                if(ms - System.currentTimeMillis() <= 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        public void setCooldown(long id) {
            long cooldown = System.currentTimeMillis() + 86400000;
            cooldownsconfig.set("Cooldown.Modalidad."+id,cooldown);
            save();
        }

        public void removeCooldown(long msToRemove,long id) {
            long cooldown = getCooldownLong(id) - msToRemove;
            cooldownsconfig.set("Cooldown.Modalidad."+id,cooldown);
            save();
        }

        public long getCooldownLong(long id) {
            long ms = 0;
            ms = (long) cooldownsconfig.get("Cooldown.Modalidad."+id);
            return ms;
        }
        private void save() {
            try {
                cooldownsconfig.save(cooldowns);
            } catch (Exception e){
                e.printStackTrace();
            }
    }
}
