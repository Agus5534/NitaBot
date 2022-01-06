package com.nitasorteadora.bot.listeners;

import com.nitasorteadora.bot.ConfigHandler;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class GuildMemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        Member member = event.getMember();
        List<Role> roles = event.getGuild().getRoles();
        if(event.getGuild().getId().equals("754918107587543043")) {
           for(Role role : roles) {
               if(role.getName().equals("Invitado")) {
                   event.getGuild().addRoleToMember(member, role).queue();
                   return;
               }
           }
        } else {
            if(event.getGuild().getId().equals("779862254807547926") || event.getGuild().getId().equals("754918107587543043")) {
                return;
            } else {
                ConfigHandler.getLogger().warning("Se ha unido "+ event.getMember().getUser().getName() + " al servidor " + event.getGuild().getName() + " (owner:" + event.getGuild().getOwner().getUser().getName() + ") ");
                try {
                    //event.getGuild().getDefaultChannel().sendMessage( event.getGuild().getOwner().getUser().getAsMention() + " Se ha intentado agregar este servidor a la lista blanca pero ha ocurrido un error!").queue();
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setTitle("Unknown server log:");
                    eb.setThumbnail(event.getGuild().getIconUrl());
                    eb.addField("Nombre:", event.getGuild().getName(), true);
                    eb.addField("ID:", event.getGuild().getId(), true);
                    eb.addField("Owner:", event.getGuild().getOwner().getUser().getAsTag(), true);
                    eb.addField("Owner ID:", event.getGuild().getOwnerId(), true);
                    eb.addField("Se unió:", event.getMember().getUser().getAsTag() + " (" + event.getMember().getUser().getId() + ")", true);
                    event.getJDA().openPrivateChannelById("621875607839440916").complete().sendMessageEmbeds(eb.build()).queue();
                } catch (Exception e) {
                    return;
                }
            }

        }
    }
}
