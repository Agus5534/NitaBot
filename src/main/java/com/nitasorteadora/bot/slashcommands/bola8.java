package com.nitasorteadora.bot.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class bola8 extends SlashCommand {
    public static HashMap<String, String> pregunta = new HashMap<>();
    public bola8() {
        this.name = "bola8";
        this.help = "Predice algo";
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.STRING, "pregunta", "Una pregunta que tendré que responder").setRequired(true));
        this.options = options;
    }
    @Override
    public void execute(SlashCommandEvent event){

        pregunta.put(event.getMember().getUser().getId(), event.getOption("pregunta").getAsString());
        event.deferReply().queue();
        if(event.getOption("pregunta").getAsString().contains("Sub")) {

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("\uD83C\uDFB1 ¡8BALL! \uD83C\uDFB1");
            eb.setColor(Color.cyan);
            eb.addField(event.getMember().getUser().getName() + " Pregunta:", pregunta.get(event.getMember().getUser().getId()), false);
            eb.addField("Mi respuesta:","¿Sub? un precoz",false);
            event.getHook().sendMessageEmbeds(eb.build()).queue();
        } else {
            String[] respuestas = {"Si", "No, A menos que seas el Ivo", "No hay duda de ello", "¡Por supuesto!", "Probablemente no", "No", "Jamás", "Obvio", "De momento no", "No lo se", "Cierto", "Falso", "Verdadero", "Puede ser", "Mis cálculos dicen que si", "Mis cálculos dicen que no", "Diria que si pero mi código dice que no", "Eso es imposible", "No tengo idea", "No se, espero haberte ayudado", "No se, solo se que **NO ganarás tu próximo uhc**", "Claro que no! No quiero que Uimpi me haga otro video D:", "¡Por supuesto! que no", "No no todo mal todo mal", "Parece que no puedo responder esta pregunta >.<", "Probablemente Improbable", "Pensándolo bien, creo que no", "Diria que si en un 3%", "No le encuentro la lógica a esa pregunta", "Está claro que no","253ms","respuestas[randomNumber]","¿Para qué preguntas si sabes que no?","Soy una entidad y por eso digo que no.. No, no, no, así no era... Digo que si...","¿51?"};
            Random random = new Random();
            int randomNumber = random.nextInt(respuestas.length);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("\uD83C\uDFB1 ¡8BALL! \uD83C\uDFB1");
            eb.setColor(Color.cyan);
            eb.addField(event.getMember().getUser().getName() + " Pregunta:", pregunta.get(event.getMember().getUser().getId()), false);
            eb.addField("Mi respuesta:",respuestas[randomNumber],false);
            event.getHook().sendMessageEmbeds(eb.build()).queue();
        }

    }
}
