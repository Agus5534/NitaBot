package com.nitasorteadora.bot.commands.administrativos;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nitasorteadora.bot.utils.cartashelper.CartasHelper;
import com.nitasorteadora.bot.utils.exceptions.CreateCardException;

public class DevTest extends Command {
    public DevTest() {
        this.name = "devtest";
        this.help = "function test";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        CartasHelper cartadev = new CartasHelper(commandEvent);
        try {
            cartadev.cardName("Development Test")
                    .author("Develop")
                    .emote("<:emote:id>")
                    .image("https://cdn.discordapp.com/attachments/832638653921624095/901597412156657725/unknown.png")
                    .dbName("CartaDevelop.")
                    .season(3)
                    .esEpica()
                    .build(commandEvent);
        } catch (CreateCardException e) {
            e.printStackTrace();
        }
    }
}
