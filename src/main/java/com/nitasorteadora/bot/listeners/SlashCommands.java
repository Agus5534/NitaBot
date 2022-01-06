package com.nitasorteadora.bot.listeners;

import com.nitasorteadora.bot.ConfigHandler;
import com.nitasorteadora.bot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;

import static com.nitasorteadora.bot.Main.cartasconfig;
import static com.nitasorteadora.bot.utils.cartashelper.RemovedReset.resetdawe;
import static com.nitasorteadora.bot.utils.lucksystem.LuckManager.getLuckfortarget;
@Deprecated
/**
 * @ForRemoval("deadline" = "2.1.0")
 *
 *
 */
public class SlashCommands extends ListenerAdapter {
    public static HashMap<String, String> pregunta = new HashMap<>();
    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        if (event.getGuild() == null) {
            return;
    }
        if(event.getName().equals("backup")){
        event.deferReply().queue();
            if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                event.getJDA().getGuildById("754918107587543043").getTextChannelById("898314646170271774").sendMessage("Claimed.yml:").addFile(Main.claimed).queue();
                event.getJDA().getGuildById("754918107587543043").getTextChannelById("898314646170271774").sendMessage("Cartas.yml:").addFile(Main.cartas).queue();
                event.getHook().sendMessage("¡Backup realizado, revisa <#898314646170271774>!").setEphemeral(true).queue();

            } else {
                event.getHook().sendMessage("No tienes permisos de hacer esto!").setEphemeral(true).queue();
            }
        } else if(event.getName().equals("8ball")) {
            resetdawe(event.getMember());
            pregunta.put(event.getMember().getUser().getId(), event.getOption("pregunta").getAsString());
            event.deferReply().queue();
           String[] respuestas = {"Si", "No, A menos que seas el Ivo", "No hay duda de ello", "¡Por supuesto!", "Probablemente no", "No", "Jamás", "Obvio", "De momento no", "No lo se", "Cierto", "Falso", "Verdadero", "Puede ser", "Mis cálculos dicen que si", "Mis cálculos dicen que no", "Diria que si pero mi código dice que no", "Eso es imposible", "No tengo idea", "No se, espero haberte ayudado", "No se, solo se que **NO ganarás tu próximo uhc**", "Claro que no! No quiero que Uimpi me haga otro video D:", "¡Por supuesto! que no", "No no todo mal todo mal", "Parece que no puedo responder esta pregunta >.<", "Probablemente Improbable", "Pensándolo bien, creo que no", "Diria que si en un 3%", "No le encuentro la lógica a esa pregunta", "Está claro que no","253ms","respuestas[randomNumber]","¿Para qué preguntas si sabes que no?","Soy una entidad y por eso digo que no.. No, no, no, así no era... Digo que si...","¿51?"};
           Random random = new Random();
           int randomNumber = random.nextInt(respuestas.length);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("\uD83C\uDFB1 ¡8BALL! \uD83C\uDFB1");
            eb.setColor(Color.cyan);
            eb.addField(event.getMember().getUser().getName() + " Pregunta:", pregunta.get(event.getMember().getUser().getId()), false);
            eb.addField("Mi respuesta:",respuestas[randomNumber],false);
            event.getHook().sendMessageEmbeds(eb.build()).addActionRow(
                    Button.primary("repeat","Repetir Pregunta")
            ).queue();

        } else if(event.getName().equals("perfil")) {
           if(event.getOption("usuario") == null) {
               Member member = event.getMember();
               resetdawe(member);
               perfil(event, member);

           } else {
               Member member = event.getOption("usuario").getAsMember();
               resetdawe(member);
               perfil(event, member);

           }
        } else if(event.getName().equals("cartas")) {
            if(event.getOption("usuario") == null) {
                Member member = event.getMember();
                resetdawe(member);
                cartas(event,member);
            } else {
                Member member = event.getOption("usuario").getAsMember();
                resetdawe(member);
                cartas(event,member);
            }
        } else if(event.getName().equals("dbedit")) {
            event.deferReply().queue();
            if(event.getMember().getId().equals("621875607839440916")) {
                    String path = event.getOption("path").getAsString();
                    long value = event.getOption("value").getAsLong();
                    cartasconfig.set(path, value);
                event.getHook().sendMessage("Acción ejecutada!").setEphemeral(true).queue();

                try {
                        cartasconfig.save(Main.cartas);
                    } catch (Exception e) {
                        event.getHook().sendMessage("No se ha podido guardar la base de datos!").setEphemeral(true).queue();
                        e.printStackTrace();
                    }
            } else {
                event.getHook().sendMessage("No tienes permisos para hacer esto").setEphemeral(true).queue();
            }
        }
    }
    private void cartas(SlashCommandEvent event, Member target) {
        event.deferReply().queue();
        int cevil = 0;
        int cfirre = 0;
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
        cfirre = (int) cartasconfig.get("CartaFirre." + target.getId(), cfirre);
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
        String firre = "El Aficionado: " + cfirre;
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
        String comunes = magic + "\n " + maurito + "\n " + zijhyan + "\n " + zeqia + "\n " + soul + "\n " + evil + "\n " + firre + "\n " + gersoon + "\n " + tamara + "\n " + andrew + "\n " + xrayos + "\n " + tatu + "\n " + charly + "\n " + mrcomegatos + "\n " + spiker + "\n " + starr + "\n " + flowii + "\n " + juuzo + "\n " + goge + "\n " + giantek + "\n " + lexan + "\n " + ayden;

        String cuchi = "La Pequeña: " + ccuchi;
        String uimpi = "La Animadora: " + cuimpi;
        String arnick = "El Comunista: " + carnick;
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
        String luqui = "El Tranquilo: " + cluqui;
        String ivo = "El Turro: " + civoo;
        String iki = "El Guardián: " + ciki;
        String cel = "El Escandaloso: " + ccel;
        String juanjo = "El Técnico: " + cjuanjo;
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
    private void perfil(SlashCommandEvent event, Member target) {
        event.deferReply().queue();
        String badges = "Usuario :pick: ";
        if (ConfigHandler.getBetas().contains(target.getId())) {
            badges = badges + "\n" + "Beta Tester :star: ";
        }
        if(ConfigHandler.getAdmins().contains(target.getId())) {
            badges = badges + "\n" + "Bot Co-Owner :gem: ";
        }
        if(target.getId().equalsIgnoreCase("621875607839440916")) {
            badges = badges + "\n" + "Bot Owner :crown: " + "\n" + "Bot Developer :wrench: ";
        }
        if(target.getId().equalsIgnoreCase("326879991629479936")) {
            badges = badges + "\n" + "Coleccionista Raro :sparkles: ";
        }
        if(target.getId().equalsIgnoreCase("223909547054465024")) {
            badges = badges + "\n" + "Coleccionista Épico :sparkles: ";
        }
        if(target.getId().equalsIgnoreCase("475432942215102465")) {
            badges = badges + "\n" + "Coleccionista Legendario :sparkles: ";
        }
        if(target.getId().equalsIgnoreCase("599632807299383316")) {
            badges = badges + "\n" + "Coleccionista Común :sparkles: ";
        }

        int totalidad = 0;
        int desbloqueadas = 0;
        int tokens = 0;
        totalidad = (int) cartasconfig.get("Total." + target.getId(), totalidad);
        desbloqueadas = (int) cartasconfig.get("Desbloqueadas." + target.getId(), desbloqueadas);
        tokens = (int) cartasconfig.get("Tokens."+target.getId(),tokens);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Perfil de **" + target.getUser().getName() + "**:");
        eb.setDescription("Cuenta creada el " + target.getTimeCreated().format(fmt));
        //eb.addField("Discord:", "", false);
        //eb.addField("")
        eb.addField("Rango en el BOT:", badges, false);
        eb.addField("Estado:", estado(target), true);
        eb.addField("Cartas obtenidas: ", String.valueOf(totalidad), true);
        eb.addField("Cartas Desbloqueadas:", String.valueOf(desbloqueadas + "/47"), true);
        eb.addField("Tokens:", String.valueOf(tokens), true);
        eb.addField("Suerte:",luckidentifiertarget(target), true);
        eb.setThumbnail(target.getUser().getAvatarUrl());
        event.getHook().sendMessageEmbeds(eb.build()).queue();
    }
    private String estado(Member target) {
        String status = target.getOnlineStatus().toString();
        if(status.equalsIgnoreCase("DO_NOT_DISTURB")) {
            return "No Molestar";
        } else {
            if(status.equalsIgnoreCase("IDLE")) {
                return "Ausente";
            } else {
                if(status.equalsIgnoreCase("ONLINE")) {
                    return "Conectado";
                } else {
                    if(status.equalsIgnoreCase("OFFLINE")) {
                        return "Desconectado";
                    } else {
                        return "No se encontró";
                    }
                }
            }
        }
    }
    private String luckidentifiertarget(Member target) {
        if(getLuckfortarget(target) >= 1 && getLuckfortarget(target) <= 4) {
            return "Super Baja";
        } else if(getLuckfortarget(target) >=5 && getLuckfortarget(target) <=8) {
            return "Baja";
        } else if(getLuckfortarget(target) >= 9 && getLuckfortarget(target) <=12) {
            return "Normal";
        } else if(getLuckfortarget(target) >=13 && getLuckfortarget(target) <= 16) {
            return "Alta";
        } else if(getLuckfortarget(target) >= 17 && getLuckfortarget(target) <= 20){
            return "Super Alta";
        } else if(getLuckfortarget(target) >= 21) {
            return "Extremadamente Alta";
        } else {
            return "No se encontró";
        }
    }
}
