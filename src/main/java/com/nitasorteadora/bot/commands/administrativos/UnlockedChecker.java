package com.nitasorteadora.bot.commands.administrativos;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Member;

import java.util.List;

public class UnlockedChecker extends Command {
    public UnlockedChecker() {
        this.name = "unlockedchecker";
        this.ownerCommand = true;
        this.hidden = true;
        this.help = "Chequea las cartas desbloqueadas de todos y las repará de ser incorrectas";
        this.cooldown = 15;
    }
    public void execute(CommandEvent commandEvent) {
        try {
            List<Member> memberList = commandEvent.getJDA().getGuildById("779862254807547926").getMembers();
            for(int i = 0; i < memberList.size();i++) {
                if(!memberList.get(i).getUser().isBot()) {
                    new com.nitasorteadora.bot.utils.UnlockedChecker().runChecker(memberList.get(i));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
