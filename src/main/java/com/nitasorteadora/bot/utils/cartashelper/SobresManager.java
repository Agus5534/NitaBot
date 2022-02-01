package com.nitasorteadora.bot.utils.cartashelper;

import com.nitasorteadora.bot.cartas.embeds.CartaC;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.nitasorteadora.bot.Main.cartas;
import static com.nitasorteadora.bot.Main.cartasconfig;

public class SobresManager {


    public int getCount(SobresType sobreType, Member member)  {
        int sc = 0;
        sc = (int) cartasconfig.get(sobreType.getDbName()+member.getId(),sc);
        return sc;
    }
    public String getCountString(SobresType sobreType, Member member) {
        int sc = 0;
        sc = (int) cartasconfig.get(sobreType.getDbName()+member.getId(),sc);
        return String.valueOf(sc);
    }

    public int getTokens(Member member) {
        int tks = 0;
        tks = (int) cartasconfig.get("Tokens."+member.getId(),tks);
        return tks;
    }
    public boolean canBuy(SobresType sobreType, Member member, long cantidad) {
        if(cantidad >= 1 && cantidad <= 50) {
            if(getTokens(member) >= (sobreType.getCoste() * cantidad)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public void giveSobre(SobresType sobreType, Member member, long cant) {
        int sobrecount = 0;
        sobrecount = (int) cartasconfig.get(sobreType.getDbName()+member.getId(),sobrecount);
        sobrecount = (int) (sobrecount + cant);
        cartasconfig.set(sobreType.getDbName()+member.getId(),sobrecount);
    }
    public void removeSobre(SobresType sobreType, Member member) {
        int sobrecount = 0;
        sobrecount = (int) cartasconfig.get(sobreType.getDbName()+member.getId(),sobrecount);
        sobrecount--;
        cartasconfig.set(sobreType.getDbName()+member.getId(),sobrecount);
    }
    public int getDesbloqueadas(Member member) {
        int desbloqueadas = 0;
        desbloqueadas = (int) cartasconfig.get("Desbloqueadas."+member.getId(),desbloqueadas);
        return desbloqueadas;
    }

    public void openSobre(SobresType sobreType, SlashCommandEvent event) {
        if(getCount(sobreType, event.getMember()) >= 1) {
            if(sobreType == SobresType.COMUN) {
                sobreComunRNG(event);
            } else if(sobreType == SobresType.RARO) {
                sobreRaroRNG(event);
            } else if(sobreType == SobresType.EPICO) {
                sobreEpicoRNG(event);
            }
            removeSobre(sobreType, event.getMember());
            event.reply("Abriendo sobre").queue();
        } else {
            event.reply("No tienes sobres suficientes").setEphemeral(true).queue();
        }
    }
    public int getCardCount(CartaC carta, Member member) {
        int ccount = 0;
        ccount = (int) cartasconfig.get(carta.getDBName()+member.getId(),ccount);

        return ccount;
    }
    private void sobreComunRNG(SlashCommandEvent event) {

        List<CartaC> clist = Arrays.asList(CartaC.values());
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        int randomg = (int) (Math.random() * 100 + 1);
        int random = (int) (Math.random() * 30 + 1);
        if(randomg <= 5) {
            if(getDesbloqueadas(event.getMember()) <= 35) {
                if(getCardCount(clist.get(random),event.getMember()) == 0) {
                    buildCarta(clist.get(random),event);
                }  else {
                    getNotFoundCard(event);
                }
            } else {
                buildCarta(clist.get(random),event);
                Collections.shuffle(clist);
                buildCarta(clist.get(random),event);
            }
        } else {
            buildCarta(clist.get(random),event);
            Collections.shuffle(clist);
            buildCarta(clist.get(random),event);

        }

    }
    private void sobreRaroRNG(SlashCommandEvent event){
        List<CartaC> clist = Arrays.asList(CartaC.values());
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        int randomg = (int) (Math.random() * 100 + 1);
        int random = (int) (Math.random() * 30 + 1);
        if(randomg <= 13) {
            if(getDesbloqueadas(event.getMember()) <= 35) {
                if(getCardCount(clist.get(random),event.getMember()) == 0) {
                    buildCarta(clist.get(random),event);
                }  else {
                    getNotFoundCard(event);
                }
            } else {
                buildCarta(clist.get(random),event);
                Collections.shuffle(clist);
                buildCarta(clist.get(random),event);
            }
        } else {
            buildCarta(clist.get(random),event);
            Collections.shuffle(clist);
            buildCarta(clist.get(random),event);

        }
    }
    private void sobreEpicoRNG(SlashCommandEvent event) {
        List<CartaC> clist = Arrays.asList(CartaC.values());
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        int randomg = (int) (Math.random() * 100 + 1);
        int random = (int) (Math.random() * 30 + 1);
        if(randomg <= 23) {
            if(getDesbloqueadas(event.getMember()) <= 35) {
                if(getCardCount(clist.get(random),event.getMember()) == 0) {
                    buildCarta(clist.get(random),event);
                }  else {
                    getNotFoundCard(event);
                }
            } else {
                buildCarta(clist.get(random),event);
                Collections.shuffle(clist);
                buildCarta(clist.get(random),event);
            }
        } else {
            buildCarta(clist.get(random),event);
            Collections.shuffle(clist);
            buildCarta(clist.get(random),event);

        }
    }
    public void getNotFoundCard(SlashCommandEvent event){
        List<CartaC> clist = Arrays.asList(CartaC.values());
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        Collections.shuffle(clist);
        int random = (int) (Math.random() * 30 + 1);
        if(getCardCount(clist.get(random), event.getMember()) == 0) {
            buildCarta(clist.get(random), event);
        } else {
            getNotFoundCard(event);
        }
    }
    private void buildCarta(CartaC carta, SlashCommandEvent event){
        if(getCardCount(carta, event.getMember()) == 0){
            int desbloqueadas = getDesbloqueadas(event.getMember());
            desbloqueadas++;
            cartasconfig.set("Desbloqueadas."+event.getMember().getId(),desbloqueadas);
        }
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("¡Carta Diaria!");
        eb.setDescription("Obtuviste: **"+carta.getName()+"** " + carta.getEmote());
        eb.setImage(carta.getImage());
        eb.setFooter("Carta "+carta.getCalidad().getName() + "| Season " + carta.getSeason());
        eb.setColor(carta.getCalidad().getColor());
       String channelid = event.getChannel().getId();
        event.getJDA().getTextChannelById(channelid).sendMessageEmbeds(eb.build()).queue();
        int cartaCount = getCardCount(carta, event.getMember());
        cartaCount++;
        cartasconfig.set(carta.getDBName()+event.getMember().getId(),cartaCount);
        int total = 0;
        total = (int) cartasconfig.get("Total."+event.getMember().getId(),total);
        total++;
        cartasconfig.set("Total."+event.getMember().getId(),total);
        try {
            cartasconfig.save(cartas);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
