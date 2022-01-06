package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.cartashelper.RemovedReset.resetdawe;

public class Cartas extends SlashCommand {
    public static long interactionid = 0;
    public static HashMap<Long, Long> data = new HashMap<>();
    public static HashMap<Long, Long> data2 = new HashMap<>();

    public Cartas(){
        this.name = "cartas";
        this.help = "Mira tus cartas o las de alguien";
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.USER,"usuario","El usuario de quien quieres ver las cartas (opcional)").setRequired(false));
        this.options = options;
    }
    @Override
    public void execute(SlashCommandEvent event) {
        if(event.getOption("usuario") == null) {
            Member member = event.getMember();
            resetdawe(member);
            cartas(event,member);
        } else {
            Member member = event.getOption("usuario").getAsMember();
            resetdawe(member);
            cartas(event,member);
        }
    }
    private void cartas(SlashCommandEvent event, Member target) {
        event.deferReply().queue();
        interactionid++;
        data.put(interactionid, event.getMember().getIdLong());
        data2.put(event.getMember().getIdLong(), interactionid);

        int cevil = 0;
        int cmagic = 0;
        int cmaurito = 0;
        int csoul = 0;
        int czeqia = 0;
        int czij = 0;
        int carnick = 0;
        int ccneyer = 0;
        int ccuchi = 0;
        int cuimpi = 0;
        int caugus = 0;
        int ccel = 0;
        int ciki = 0;
        int civoo = 0;
        int cjuanjo = 0;
        int cluqui = 0;
        int cnita = 0;
        int csub = 0;
        int cpanda = 0;
        int clucmus = 0;
        int cnyrem = 0;
        int candrew = 0;
        int cgersoon = 0;
        int ctamara = 0;
        int cxrayos = 0;
        int cjungle = 0;
        int cpato = 0;
        int crufk = 0;
        int csalvi = 0;
        int cconn = 0;
        int ccharly = 0;
        int cflowii = 0;
        int cgiantek = 0;
        int cgoge = 0;
        int cjuuzo = 0;
        int cmrcomegatos = 0;
        int cspiker = 0;
        int clexan = 0;
        int cstarr = 0;
        int ctatu = 0;
        int cazga = 0;
        int cdawe = 0;
        int cheis = 0;
        int cinfer = 0;
        int cmario = 0;
        int cyuri = 0;
        int cagus5534 = 0;
        int cayden = 0;
        cevil = (int) cartasconfig.get("CartaEvil." + target.getId(), cevil);
        cmagic = (int) cartasconfig.get("CartaMagic." + target.getId(), cmagic);
        cmaurito = (int) cartasconfig.get("CartaMaurito." + target.getId(), cmaurito);
        csoul = (int) cartasconfig.get("CartaSoul." + target.getId(), csoul);
        czeqia = (int) cartasconfig.get("CartaZeqia." + target.getId(), czeqia);
        czij = (int) cartasconfig.get("CartaZij." + target.getId(), czij);
        carnick = (int) cartasconfig.get("CartaArnick." + target.getId(), carnick);
        ccneyer = (int) cartasconfig.get("CartaCneyer." + target.getId(), ccneyer);
        ccuchi = (int) cartasconfig.get("CartaCuchi." + target.getId(), ccuchi);
        cuimpi = (int) cartasconfig.get("CartaUimpi." + target.getId(), cuimpi);
        caugus = (int) cartasconfig.get("CartaAugus." + target.getId(), caugus);
        ccel = (int) cartasconfig.get("CartaCel." + target.getId(), ccel);
        ciki = (int) cartasconfig.get("CartaIki." + target.getId(), ciki);
        civoo = (int) cartasconfig.get("CartaIvo." + target.getId(), civoo);
        cjuanjo = (int) cartasconfig.get("CartaJuanjo." + target.getId(), cjuanjo);
        cluqui = (int) cartasconfig.get("CartaLuqui." + target.getId(), cluqui);
        cnita = (int) cartasconfig.get("CartaNita." + target.getId(), cnita);
        csub = (int) cartasconfig.get("CartaSub." + target.getId(), csub);
        cpanda = (int) cartasconfig.get("CartaPanda." + target.getId(), cpanda);
        clucmus = (int) cartasconfig.get("CartaLucmus." + target.getId(), clucmus);
        cnyrem = (int) cartasconfig.get("CartaNyrem." + target.getId(), cnyrem);
        candrew = (int) cartasconfig.get("CartaAndrew." + target.getId(), candrew);
        cgersoon = (int) cartasconfig.get("CartaGersoon." + target.getId(), cgersoon);
        ctamara = (int) cartasconfig.get("CartaTamara." + target.getId(), ctamara);
        cxrayos = (int) cartasconfig.get("CartaXRayos."+target.getId(),cxrayos);
        cjungle = (int) cartasconfig.get("CartaJungle."+target.getId(),cjungle);
        cpato = (int) cartasconfig.get("CartaPato."+target.getId(),cpato);
        crufk = (int) cartasconfig.get("CartaRufk."+target.getId(),crufk);
        csalvi = (int) cartasconfig.get("CartaSalvi."+target.getId(),csalvi);
        cconn = (int) cartasconfig.get("CartaConn."+target.getId(),cconn);
        ccharly = (int) cartasconfig.get("CartaCharly."+target.getId(),ccharly);
        cflowii = (int) cartasconfig.get("CartaFlowii."+target.getId(),cflowii);
        cgiantek = (int) cartasconfig.get("CartaGiantek."+target.getId(),cgiantek);
        cgoge = (int) cartasconfig.get("CartaGoge."+target.getId(),cgoge);
        cjuuzo = (int) cartasconfig.get("CartaJuzo."+target.getId(),cjuuzo);
        cmrcomegatos = (int) cartasconfig.get("CartaMrComeGatos."+target.getId(),cmrcomegatos);
        cspiker = (int) cartasconfig.get("CartaSpiker."+target.getId(),cspiker);
        clexan = (int) cartasconfig.get("CartaLexan."+target.getId(),clexan);
        cstarr = (int) cartasconfig.get("CartaStarr."+target.getId(),cstarr);
        ctatu = (int) cartasconfig.get("CartaTatu."+target.getId(),ctatu);
        cazga = (int) cartasconfig.get("CartaAzga."+target.getId(),cazga);
        cdawe = (int) cartasconfig.get("CartaDawe."+target.getId(),cdawe);
        cheis = (int) cartasconfig.get("CartaHeis."+target.getId(),cheis);
        cinfer = (int) cartasconfig.get("CartaInfer."+target.getId(),cinfer);
        cmario = (int) cartasconfig.get("CartaMario."+target.getId(),cmario);
        cyuri = (int) cartasconfig.get("CartaYuri."+target.getId(),cyuri);
        cagus5534 = (int) cartasconfig.get("CartaAgus5534."+target.getId(),cagus5534);
        cayden = (int) cartasconfig.get("CartaAyden."+target.getId(),cayden);


        String magic = "El Modder: " + cmagic;
        String maurito = "El Mayor: " + cmaurito;
        String zijhyan = "El Mago Ingeniero: " + czij;
        String zeqia = "El Mudo: " + czeqia;
        String soul = "El Perdido: " + csoul;
        String evil = "El Dasher: " + cevil;
        String gersoon = "El Recopilador: " + cgersoon;
        String tamara = "La Dedicada: " + ctamara;
        String andrew = "El Amable: " + candrew;
        String xrayos = "El Tímido: " + cxrayos;
        String tatu = "El Boludo: " + ctatu;
        String charly = "El Multiestilo: " + ccharly;
        String mrcomegatos = "El Hayabusa: " + cmrcomegatos;
        String spiker = "El Boomer: " + cspiker;
        String starr = "La Indecisa: " + cstarr;
        String flowii = "La Cantante: " + cflowii;
        String juuzo = "La Inexperta: " + cjuuzo;
        String goge = "El Referencias: " + cgoge;
        String giantek = "El Pelotudo: " + cgiantek;
        String lexan = "El Distraído: " + clexan;
        String ayden = "El Entusiasta: " + cayden;
        String comunes = magic + "\n " + maurito + "\n " + zijhyan + "\n " + zeqia + "\n " + soul + "\n " + evil + "\n "  + "\n " + gersoon + "\n " + tamara + "\n " + andrew + "\n " + xrayos + "\n " + tatu + "\n " + charly + "\n " + mrcomegatos + "\n " + spiker + "\n " + starr + "\n " + flowii + "\n " + juuzo + "\n " + goge + "\n " + giantek + "\n " + lexan + "\n " + ayden;

        String cuchi = "La Pequeña: " + ccuchi;
        String uimpi = "La Animadora: " + cuimpi;
        String cneyer = "El Aplanador: " + ccneyer;
        String salvi = "El Impaciente: " + csalvi;
        String rufk = "El Inquieto: " + crufk;
        String pato = "El Discreto: " + cpato;
        String jungle = "El Humilde: " + cjungle;
        String heis = "El Sicario: " + cheis;
        String infer = "El Loco: " + cinfer;
        String azga = "La Tele: " + cazga;
        String yuri = "El Varelense: " + cyuri;
        String mario = "El Pokemaníaco: " + cmario;

        String raras = cuchi + "\n " + uimpi  + "\n " + cneyer + "\n " + salvi + "\n " + rufk + "\n " + pato + "\n " + jungle + "\n " + heis + "\n " + infer + "\n " + azga + "\n " + yuri + "\n " + mario;

        String nita = "La Artista: " + cnita;
        String panda = "El Paciente: " + cpanda;
        String sub = "El Comediante: " + csub;
        String augus = "El Imperial: " + caugus;
        String ivo = "El Turro: " + civoo;
        String iki = "El Guardián: " + ciki;
        String cel = "El Escandaloso: " + ccel;
        String juanjo = "El Técnico: " + cjuanjo;
        String luqui = "El Tranquilo: " + cluqui;
        String conn = "La Editora: " + cconn;
        String epicas = nita + "\n " + panda + "\n " + sub + "\n " + augus + "\n " + luqui + "\n " + ivo + "\n " + iki + "\n " + cel + "\n " + juanjo + "\n " + conn;

        String lucmus = "El Admin: " + clucmus;
        String nyrem = "El Callado: " + cnyrem;
        String agus = "El Programador: " + cagus5534;

        String legendarias = lucmus + "\n " + nyrem + "\n " + agus;


        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Cartas de " + target.getUser().getName());
        eb.addField("Comunes:", comunes, true);
        eb.addField("Raras:", raras, true);
        eb.addField("Épicas:", epicas, true);
        eb.addField("Legendarias:",legendarias, true);
        eb.setColor(Color.RED);
        event.getHook().sendMessageEmbeds(eb.build()).addActionRow(SelectionMenu.create("Todas las cartas")
                .addOption("Todas las cartas","Todas las cartas")
                .addOption("Comunes","Comunes")
                .addOption("Raras","Raras")
                .addOption("Épicas","Épicas")
                .addOption("Legendarias","Legendarias")
                .build()
        ).setEphemeral(true).queue();
    }
}
