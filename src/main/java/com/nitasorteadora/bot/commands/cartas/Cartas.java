package com.nitasorteadora.bot.commands.cartas;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.JDAHandler;
import com.nitasorteadora.bot.cartas.embeds.CartaC;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;

import java.awt.*;

import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.cartashelper.CartasData.totaldesbloqueadas;
import static com.nitasorteadora.bot.utils.cartashelper.RemovedReset.resetdawe;

public class Cartas extends Command {
    public Cartas() {
        this.name = "cartas";
        this.help = "Muestra tus cartas o las de otros!";
    }
    @Override
    protected void execute(CommandEvent commandEvent) {
        if(JDAHandler.devonly){
            if(!JDAHandler.executedevonly(commandEvent)) {
                return;
            }
        }
        try {
            Member target = commandEvent.getMessage().getMentionedMembers().get(0);
            resetdawe(target);
            resetdawe(commandEvent);
            ExecuteCommand(commandEvent, target);

        } catch (Exception e) {
            resetdawe(commandEvent);
            ExecuteCommandOwn(commandEvent);
        }

    }
    private void ExecuteCommand(CommandEvent commandEvent, Member target) {
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
        String magic = "El Modder: " + cmagic;
        String maurito = "El Mayor: " + cmaurito;
        String zijhyan = "El Mago Ingeniero: " + czij;
        String evil = "El Dasher: " + cevil;
        String tatu = "El Boludo: " + ctatu;
        String charly = "El Multiestilo: " + ccharly;
        String spiker = "El Boomer: " + cspiker;
        String starr = "La Indecisa: " + cstarr;
        String flowii = "La Cantante: " + cflowii;
        String goge = "El Referencias: " + cgoge;
        String lexan = "El Distraído: " + clexan;
        String ayden = "El Entusiasta: " + cayden;
        String comunes = magic + "\n " + maurito + "\n " + zijhyan + "\n " + evil + "\n " + tatu + "\n " + charly + "\n " + spiker + "\n " + starr + "\n " + flowii + "\n "  + goge + "\n " + lexan + "\n " + ayden;

        String cuchi = "La Pequeña: " + ccuchi;
        String uimpi = "La Animadora: " + cuimpi;
        String salvi = "El Impaciente: " + csalvi;
        String pato = "El Discreto: " + cpato;
        String heis = "El Sicario: " + cheis;
        String infer = "El Loco: " + cinfer;
        String azga = "La Tele: " + cazga;
        String yuri = "El Varelense: " + cyuri;
        String mario = "El Pokemaníaco: " + cmario;
        String fabo = "El Asustadizo: " + cfabo;
        String carmened = "El Espontáneo: "+ ccarmened;

        String raras = cuchi + "\n " + uimpi  + "\n "  + salvi + "\n " + pato +  "\n " + heis + "\n " + infer + "\n " + azga + "\n " + yuri + "\n " + mario + "\n " + fabo + "\n " + carmened;


        String nita = "La Artista: " + cnita;
        String panda = "El Paciente: " + cpanda;
        String sub = "El Comediante: " + csub;
        String augus = "El Imperial: " + caugus;
        String luqui = "El Tranquilo: " + cluqui;
        String ivo = "El Turro: " + civoo;
        String iki = "El Guardián: " + ciki;
        String conn = "La Editora: " + cconn;
        String rufk = "El Inquieto: " + crufk;

        String epicas = nita + "\n " + panda + "\n " + sub + "\n " + augus + "\n " + luqui + "\n " + ivo + "\n " + iki + "\n " + conn + "\n " + rufk;

        String lucmus = "El Admin: " + clucmus;
        String nyrem = "El Callado: " + cnyrem;
        String agus = "El Programador: " + cagus5534;

        String legendarias = lucmus + "\n " + nyrem + "\n " + agus;

        String LaEntidad = "La Entidad: " + laentidad;
        String NitaBot = "NitaBot: " + nitabot;

        String miticas = LaEntidad + "\n " + NitaBot;
        int total = 0;
        int desbloqueadas = 0;
        int tokens = 0;
        total = (int) cartasconfig.get("Total."+target.getId(),total);
        desbloqueadas = (int) cartasconfig.get("Desbloqueadas."+target.getId(),desbloqueadas);
        tokens = (int) cartasconfig.get("Tokens."+target.getId(), tokens);
        String ebfooter = "Cartas que tienes: " + total + " | Desbloqueadas: " + desbloqueadas + totaldesbloqueadas +" | Tokens: " + tokens;
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Cartas de " + target.getUser().getName());
        eb.addField("Comunes:", comunes, true);
        eb.addField("Raras:", raras, true);
        eb.addField("Épicas:", epicas, true);
        eb.addField("Legendarias:",legendarias, true);
        eb.addField("Míticas:",miticas,true);
        eb.setColor(Color.RED);
        eb.setFooter(ebfooter);
        try {
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
        } catch (Exception e){
            e.printStackTrace();
            Throwable cause = e.getCause();
            commandEvent.getChannel().sendMessage("Ha ocurrido un error:");
            commandEvent.getChannel().sendMessage("```" + cause + "```");
        }

    }
    private void ExecuteCommandOwn(CommandEvent commandEvent) {
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
        cevil = (int) cartasconfig.get("CartaEvil." + commandEvent.getMessage().getAuthor().getId(), cevil);
        cmagic = (int) cartasconfig.get("CartaMagic." + commandEvent.getMessage().getAuthor().getId(), cmagic);
        cmaurito = (int) cartasconfig.get("CartaMaurito." + commandEvent.getMessage().getAuthor().getId(), cmaurito);
        czij = (int) cartasconfig.get("CartaZij." + commandEvent.getMessage().getAuthor().getId(), czij);
        ccuchi = (int) cartasconfig.get("CartaCuchi." + commandEvent.getMessage().getAuthor().getId(), ccuchi);
        cuimpi = (int) cartasconfig.get("CartaUimpi." + commandEvent.getMessage().getAuthor().getId(), cuimpi);
        caugus = (int) cartasconfig.get("CartaAugus." + commandEvent.getMessage().getAuthor().getId(), caugus);
        ciki = (int) cartasconfig.get("CartaIki." + commandEvent.getMessage().getAuthor().getId(), ciki);
        civoo = (int) cartasconfig.get("CartaIvo." + commandEvent.getMessage().getAuthor().getId(), civoo);
        cluqui = (int) cartasconfig.get("CartaLuqui." + commandEvent.getMessage().getAuthor().getId(), cluqui);
        cnita = (int) cartasconfig.get("CartaNita." + commandEvent.getMessage().getAuthor().getId(), cnita);
        csub = (int) cartasconfig.get("CartaSub." + commandEvent.getMessage().getAuthor().getId(), csub);
        cpanda = (int) cartasconfig.get("CartaPanda." + commandEvent.getMessage().getAuthor().getId(), cpanda);
        clucmus = (int) cartasconfig.get("CartaLucmus." + commandEvent.getMessage().getAuthor().getId(), clucmus);
        cnyrem = (int) cartasconfig.get("CartaNyrem." + commandEvent.getMessage().getAuthor().getId(), cnyrem);
        cpato = (int) cartasconfig.get("CartaPato."+commandEvent.getMessage().getAuthor().getId(),cpato);
        crufk = (int) cartasconfig.get("CartaRufk."+commandEvent.getMessage().getAuthor().getId(),crufk);
        csalvi = (int) cartasconfig.get("CartaSalvi."+commandEvent.getMessage().getAuthor().getId(),csalvi);
        cconn = (int) cartasconfig.get("CartaConn."+commandEvent.getMessage().getAuthor().getId(),cconn);
        ccharly = (int) cartasconfig.get("CartaCharly."+commandEvent.getMessage().getAuthor().getId(),ccharly);
        cflowii = (int) cartasconfig.get("CartaFlowii."+commandEvent.getMessage().getAuthor().getId(),cflowii);
        cgoge = (int) cartasconfig.get("CartaGoge."+commandEvent.getMessage().getAuthor().getId(),cgoge);
        cspiker = (int) cartasconfig.get("CartaSpiker."+commandEvent.getMessage().getAuthor().getId(),cspiker);
        clexan = (int) cartasconfig.get("CartaLexan."+commandEvent.getMessage().getAuthor().getId(),clexan);
        cstarr = (int) cartasconfig.get("CartaStarr."+commandEvent.getMessage().getAuthor().getId(),cstarr);
        ctatu = (int) cartasconfig.get("CartaTatu."+commandEvent.getMessage().getAuthor().getId(),ctatu);
        cazga = (int) cartasconfig.get("CartaAzga."+commandEvent.getMessage().getAuthor().getId(),cazga);
        cheis = (int) cartasconfig.get("CartaHeis."+commandEvent.getMessage().getAuthor().getId(),cheis);
        cinfer = (int) cartasconfig.get("CartaInfer."+commandEvent.getMessage().getAuthor().getId(),cinfer);
        cmario = (int) cartasconfig.get("CartaMario."+commandEvent.getMessage().getAuthor().getId(),cmario);
        cyuri = (int) cartasconfig.get("CartaYuri."+commandEvent.getMessage().getAuthor().getId(),cyuri);
        cagus5534 = (int) cartasconfig.get("CartaAgus5534."+commandEvent.getMessage().getAuthor().getId(),cagus5534);
        cayden = (int) cartasconfig.get("CartaAyden."+commandEvent.getMessage().getAuthor().getId(),cayden);
        laentidad = (int) cartasconfig.get(CartaC.LaEntidad.getDBName()+commandEvent.getAuthor().getId(),laentidad);
        nitabot = (int) cartasconfig.get(CartaC.NitaBot.getDBName()+commandEvent.getAuthor().getId(),nitabot);
        cfabo = (int) cartasconfig.get("CartaFabo."+commandEvent.getAuthor().getId(),cfabo);
        ccarmened = (int) cartasconfig.get("CartaCarmened."+commandEvent.getAuthor().getId(),ccarmened);
        String magic = "El Modder: " + cmagic;
        String maurito = "El Mayor: " + cmaurito;
        String zijhyan = "El Mago Ingeniero: " + czij;
        String evil = "El Dasher: " + cevil;
        String tatu = "El Boludo: " + ctatu;
        String charly = "El Multiestilo: " + ccharly;
        String spiker = "El Boomer: " + cspiker;
        String starr = "La Indecisa: " + cstarr;
        String flowii = "La Cantante: " + cflowii;
        String goge = "El Referencias: " + cgoge;
        String lexan = "El Distraído: " + clexan;
        String ayden = "El Entusiasta: " + cayden;
        String comunes = magic + "\n " + maurito + "\n " + zijhyan + "\n " + evil + "\n " + tatu + "\n " + charly + "\n "  + spiker + "\n " + starr + "\n " + flowii +  "\n " + goge + "\n " + lexan + "\n " + ayden;

        String cuchi = "La Pequeña: " + ccuchi;
        String uimpi = "La Animadora: " + cuimpi;
        String salvi = "El Impaciente: " + csalvi;
        String pato = "El Discreto: " + cpato;
        String heis = "El Sicario: " + cheis;

        String infer = "El Loco: " + cinfer;
        String azga = "La Tele: " + cazga;
        String yuri = "El Varelense: " + cyuri;
        String mario = "El Pokemaníaco: " + cmario;
        String fabo = "El Asustadizo: " + cfabo;
        String carmened = "El Espontáneo: "+ ccarmened;

        String raras = cuchi + "\n " + uimpi  + "\n "  + salvi + "\n " + pato +  "\n " + heis + "\n " + infer + "\n " + azga + "\n " + yuri + "\n " + mario + "\n " + fabo + "\n " + carmened;

        String nita = "La Artista: " + cnita;
        String panda = "El Paciente: " + cpanda;
        String sub = "El Comediante: " + csub;
        String augus = "El Imperial: " + caugus;
        String luqui = "El Tranquilo: " + cluqui;
        String ivo = "El Turro: " + civoo;
        String iki = "El Guardián: " + ciki;
        String conn = "La Editora: " + cconn;
        String rufk = "El Inquieto: " + crufk;

        String epicas = nita + "\n " + panda + "\n " + sub + "\n " + augus + "\n " + luqui + "\n " + ivo + "\n " + iki + "\n " + conn + "\n " + rufk;


        String lucmus = "El Admin: " + clucmus;
        String nyrem = "El Callado: " + cnyrem;
        String agus = "El Programador: " + cagus5534;

        String legendarias = lucmus + "\n " + nyrem + "\n " + agus;

        String LaEntidad = "La Entidad: " + laentidad;
        String NitaBot = "NitaBot: " + nitabot;

        String miticas = LaEntidad + "\n " + NitaBot;

        int total = 0;
        int desbloqueadas = 0;
        int tokens = 0;
        total = (int) cartasconfig.get("Total."+commandEvent.getMessage().getAuthor().getId(),total);
        desbloqueadas = (int) cartasconfig.get("Desbloqueadas."+commandEvent.getMessage().getAuthor().getId(),desbloqueadas);
        tokens = (int) cartasconfig.get("Tokens."+commandEvent.getMessage().getAuthor().getId(), tokens);
        String ebfooter = "Cartas que tienes: " + total + " | Desbloqueadas: " + desbloqueadas +  totaldesbloqueadas +" | Tokens: " + tokens;
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Cartas de " + commandEvent.getMessage().getAuthor().getName());
        eb.addField("Comunes:", comunes, true);
        eb.addField("Raras:", raras, true);
        eb.addField("Épicas:", epicas, true);
        eb.addField("Legendarias:",legendarias, true);
        eb.addField("Míticas:",miticas,true);
        eb.setFooter(ebfooter);
        eb.setColor(Color.RED);
        try {
            commandEvent.getChannel().sendMessageEmbeds(eb.build()).queue();
        } catch (Exception e){
            e.printStackTrace();
            Throwable cause = e.getCause();
            commandEvent.getChannel().sendMessage("Ha ocurrido un error:");
            commandEvent.getChannel().sendMessage("```" + cause + "```");
        }

    }
    }

