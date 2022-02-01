package com.nitasorteadora.bot.utils;

import com.nitasorteadora.bot.cartas.embeds.CartaC;
import net.dv8tion.jda.api.entities.Member;
import org.bukkit.Bukkit;

import java.io.IOException;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;

public class UnlockedChecker {
    int cevil = 0;
    int cmagic = 0;
    int cmaurito = 0;
    int czij = 0;
    int ccuchi = 0;
    int cuimpi = 0;
    int caugus = 0;
    int ciki = 0;
    int civoo = 0;
    int cluqui = 0;
    int cnita = 0;
    int csub = 0;
    int cpanda = 0;
    int clucmus = 0;
    int cnyrem = 0;
    int cpato = 0;
    int crufk = 0;
    int csalvi = 0;
    int cconn = 0;
    int ccharly = 0;
    int cflowii = 0;
    int cgoge = 0;
    int cspiker = 0;
    int clexan = 0;
    int cstarr = 0;
    int ctatu = 0;
    int cazga = 0;
    int cheis = 0;
    int cinfer = 0;
    int cmario = 0;
    int cyuri = 0;
    int cagus5534 = 0;
    int cayden = 0;
    int laentidad = 0;
    int nitabot = 0;
    int cfabo = 0;
    int ccarmened = 0;
    int desbloqueadas = 0;
    public void runChecker(Member target) {
        cevil = (int) cartasconfig.get("CartaEvil." + target.getId(), cevil);
        cmagic = (int) cartasconfig.get("CartaMagic." + target.getId(), cmagic);
        cmaurito = (int) cartasconfig.get("CartaMaurito." + target.getId(), cmaurito);
        czij = (int) cartasconfig.get("CartaZij." + target.getId(), czij);
        ccuchi = (int) cartasconfig.get("CartaCuchi." + target.getId(), ccuchi);
        cuimpi = (int) cartasconfig.get("CartaUimpi." + target.getId(), cuimpi);
        caugus = (int) cartasconfig.get("CartaAugus." + target.getId(), caugus);
        ciki = (int) cartasconfig.get("CartaIki." + target.getId(), ciki);
        civoo = (int) cartasconfig.get("CartaIvo." + target.getId(), civoo);
        cluqui = (int) cartasconfig.get("CartaLuqui." + target.getId(), cluqui);
        cnita = (int) cartasconfig.get("CartaNita." + target.getId(), cnita);
        csub = (int) cartasconfig.get("CartaSub." + target.getId(), csub);
        cpanda = (int) cartasconfig.get("CartaPanda." + target.getId(), cpanda);
        clucmus = (int) cartasconfig.get("CartaLucmus." + target.getId(), clucmus);
        cnyrem = (int) cartasconfig.get("CartaNyrem." + target.getId(), cnyrem);
        cpato = (int) cartasconfig.get("CartaPato."+target.getId(),cpato);
        crufk = (int) cartasconfig.get("CartaRufk."+target.getId(),crufk);
        csalvi = (int) cartasconfig.get("CartaSalvi."+target.getId(),csalvi);
        cconn = (int) cartasconfig.get("CartaConn."+target.getId(),cconn);
        ccharly = (int) cartasconfig.get("CartaCharly."+target.getId(),ccharly);
        cflowii = (int) cartasconfig.get("CartaFlowii."+target.getId(),cflowii);
        cgoge = (int) cartasconfig.get("CartaGoge."+target.getId(),cgoge);
        cspiker = (int) cartasconfig.get("CartaSpiker."+target.getId(),cspiker);
        clexan = (int) cartasconfig.get("CartaLexan."+target.getId(),clexan);
        cstarr = (int) cartasconfig.get("CartaStarr."+target.getId(),cstarr);
        ctatu = (int) cartasconfig.get("CartaTatu."+target.getId(),ctatu);
        cazga = (int) cartasconfig.get("CartaAzga."+target.getId(),cazga);
        cheis = (int) cartasconfig.get("CartaHeis."+target.getId(),cheis);
        cinfer = (int) cartasconfig.get("CartaInfer."+target.getId(),cinfer);
        cmario = (int) cartasconfig.get("CartaMario."+target.getId(),cmario);
        cyuri = (int) cartasconfig.get("CartaYuri."+target.getId(),cyuri);
        cagus5534 = (int) cartasconfig.get("CartaAgus5534."+target.getId(),cagus5534);
        cayden = (int) cartasconfig.get("CartaAyden."+target.getId(),cayden);
        laentidad = (int) cartasconfig.get(CartaC.LaEntidad.getDBName()+target.getId(),laentidad);
        nitabot = (int) cartasconfig.get(CartaC.NitaBot.getDBName()+target.getId(),nitabot);
        cfabo = (int) cartasconfig.get("CartaFabo."+target.getId(),cfabo);
        ccarmened = (int) cartasconfig.get("CartaCarmened."+target.getId(),ccarmened);
        checker();
        int olddesbloqueadas = 0;
        olddesbloqueadas = (int) cartasconfig.get("Desbloqueadas."+target.getId(),olddesbloqueadas);
        if(olddesbloqueadas != desbloqueadas){
            Bukkit.getLogger().warning("El usuario " + target.getUser().getAsTag() + " tenía mal guardadas " + olddesbloqueadas + " desbloqueadas. Su cantidad se actualizó a " + desbloqueadas);
            cartasconfig.set("Desbloqueadas."+target.getId(),desbloqueadas);
            try {
                cartasconfig.save(cartas);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private void checker() {
         if(cevil >= 1){desbloqueadas++;}
         if(cmagic >= 1){desbloqueadas++;}
         if(cmaurito >= 1){desbloqueadas++;}
         if(czij >= 1){desbloqueadas++;}
         if(ccuchi >= 1){desbloqueadas++;}
         if(cuimpi >= 1){desbloqueadas++;}
         if(caugus >= 1){desbloqueadas++;}
         if(ciki >= 1){desbloqueadas++;}
         if(civoo >= 1){desbloqueadas++;}
         if(cluqui >= 1){desbloqueadas++;}
        if(cnita>= 1){desbloqueadas++;}
        if(csub >= 1){desbloqueadas++;}
        if(cpanda >= 1){desbloqueadas++;}
        if(clucmus >= 1){desbloqueadas++;}
        if(cnyrem >= 1){desbloqueadas++;}
        if(cpato >= 1){desbloqueadas++;}
        if(crufk >= 1){desbloqueadas++;}
        if(csalvi >= 1){desbloqueadas++;}
        if(cconn >= 1){desbloqueadas++;}
        if(ccharly >= 1){desbloqueadas++;}
        if(cflowii >= 1){desbloqueadas++;}
        if(cgoge >= 1){desbloqueadas++;}
        if(cspiker >= 1){desbloqueadas++;}
        if(clexan >= 1){desbloqueadas++;}
        if(cstarr >= 1){desbloqueadas++;}
        if(ctatu >= 1){desbloqueadas++;}
        if(cazga >= 1){desbloqueadas++;}
        if(cheis >= 1){desbloqueadas++;}
        if(cinfer >= 1){desbloqueadas++;}
        if(cmario >= 1){desbloqueadas++;}
        if(cyuri >= 1){desbloqueadas++;}
        if(cagus5534 >= 1){desbloqueadas++;}
        if(cayden >= 1){desbloqueadas++;}
        if(laentidad >= 1){desbloqueadas++;}
        if(nitabot >= 1){desbloqueadas++;}
        if(cfabo >= 1){desbloqueadas++;}
        if(ccarmened >= 1){desbloqueadas++;}









    }
}