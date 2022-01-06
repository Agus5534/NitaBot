package com.nitasorteadora.bot.minecraft.commands;

import com.nitasorteadora.bot.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.nitasorteadora.bot.Main.*;
import static com.nitasorteadora.bot.commands.utils.LinkAccount.uuidCodeMap;
import static com.nitasorteadora.bot.commands.utils.LinkAccount.uuidIdMap;

public class Verificar implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            try {
                if (accountsconfig.contains("Accounts.Minecraft." + player.getUniqueId())) {
                    player.sendMessage(ChatColor.RED + "¡Ya has conectado tu cuenta!");
                } else {
                    if (args.length != 1) {
                        player.sendMessage(ChatColor.RED + "Uso: /link [code]");
                    } else {
                        String actualcode = uuidCodeMap.get(player.getUniqueId());
                        if (!actualcode.equals(args[0])) {
                            player.sendMessage(ChatColor.RED + "¡Ese código es inválido!");
                        } else {
                            String discordid = uuidIdMap.get(player.getUniqueId());
                            accountsconfig.set("Accounts.Minecraft." + player.getUniqueId().toString(), discordid);
                            accountsconfig.set("Accounts.Discord." + discordid, player.getUniqueId().toString());
                            player.sendMessage(ChatColor.GREEN + "Has vinculado correctamente tu usuario! A partir de ahora podrás recibir recompensas por jugar los UHC");
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[Nita Bot] &bSe te han otorgado 15 tokens por linkear tu cuenta!"));
                            int tokens = 0;
                            tokens = (int) cartasconfig.get("Tokens." + discordid);
                            cartasconfig.set("Tokens." + discordid, tokens + 15);
                            try {
                                cartasconfig.save(Main.cartas);
                                accountsconfig.save(accounts);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            uuidCodeMap.remove(player.getUniqueId());
                            uuidCodeMap.remove(player.getUniqueId());

                        }
                    }
                }
            } catch(Exception e){
                player.sendMessage(ChatColor.RED + "Ha ocurrido un error interno! Es probable que no hayas usado "+ ChatColor.GOLD + "w!link " + player.getName());
            }
        }
        return true;
    }
    }
