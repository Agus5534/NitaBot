package com.nitasorteadora.bot;

import com.jagrosh.jdautilities.command.*;
import com.nitasorteadora.bot.commands.administrativos.Backup;
import com.nitasorteadora.bot.commands.administrativos.DevOnly;
import com.nitasorteadora.bot.commands.administrativos.GiveToken;
import com.nitasorteadora.bot.commands.administrativos.Reload;
import com.nitasorteadora.bot.commands.cartas.Dailycard;
import com.nitasorteadora.bot.commands.teams.Addteam;
import com.nitasorteadora.bot.commands.teams.AnnounceTeams;
import com.nitasorteadora.bot.commands.teams.Borrar;
import com.nitasorteadora.bot.commands.teams.ClearTeams;
import com.nitasorteadora.bot.commands.utils.Comandos;
import com.nitasorteadora.bot.listeners.GuildMemberJoin;
import com.nitasorteadora.bot.listeners.SelectionMenu;
import com.nitasorteadora.bot.slashcommands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.HashSet;
import java.util.Set;

import static com.nitasorteadora.bot.Main.tokensconfig;

public class JDAHandler {
    private String token = (String) tokensconfig.get("token");
    private String tokendev = (String) tokensconfig.get("tokendev");
    private Main plugin;
    public JDAHandler(Main plugin){
        this.plugin = plugin;
    }

    //IMPORTANTE
    public boolean devbot = false;
    //IMPORTANTE

    //PUC SI LEES ESTO, NO ME JUZGUES (Si podes hacer criticas constructivas acerca de lo pelotudo que soy uwu)

    public final Set<Command> commandSet = new HashSet<>();
    public final Set<SlashCommand> SlashSet = new HashSet<>();
    private JDA jda = null;
    public static boolean devonly = false;

    public static boolean executedevonly(CommandEvent commandEvent) {
        Member author = commandEvent.getMember();
        return ConfigHandler.getAdmins().contains(author.getId());
    }
    public void startBot(ConfigHandler configHandler) {
        if(!devbot) {
            token = token;
        } else {
            token = tokendev;
        }
        try {
            JDABuilder jdaBuilder = JDABuilder.createDefault(token);
            jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);
            jdaBuilder.enableIntents(GatewayIntent.GUILD_PRESENCES);
            jdaBuilder.enableCache(CacheFlag.ACTIVITY);
            jdaBuilder.addEventListeners(new GuildMemberJoin());
            jdaBuilder.addEventListeners(new SelectionMenu());
            jda = jdaBuilder.build();


        } catch (IllegalArgumentException | LoginException e) {
            System.out.println("NitaSorteadora: El token es inválido!");
        }
        if(jda != null && !token.equals("")) {
            CommandClientBuilder builder = new CommandClientBuilder();
            if(devbot){
                builder.forceGuildOnly("754918107587543043");
            }
            initializeCommandClientBuilder(builder);
                CommandClient commandClient = builder.build();
                addCommands(commandClient, configHandler);
                addSlashCommands(commandClient);
                jda.addEventListener(commandClient);




        }
    }
    private void initializeCommandClientBuilder(CommandClientBuilder builder) {builder.setPrefix("w/");
        builder.setActivity(Activity.playing("La entidad los obs...."));
        builder.setCoOwnerIds("247001108038418434", "222859650360541185", "247927675044233216","475432942215102465","326879991629479936","508118875192426516");
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setOwnerId(ConfigHandler.getAdmin(0));
        builder.setHelpWord("comandos");
        builder.setHelpConsumer(new Comandos(commandSet, plugin));
        if(!devbot) {
            builder.setAlternativePrefix("w!");
        } else {
            builder.setAlternativePrefix("w-");
        }
    }
    public void shutdownBot() {
        jda.shutdownNow();
    }
    private void addCommands(CommandClient commandClient, ConfigHandler configHandler) {
        commandSet.add(new Addteam());
        commandSet.add(new Dailycard());
       commandSet.add(new AnnounceTeams());
       commandSet.add(new ClearTeams());
       commandSet.add(new Reload(configHandler));
       commandSet.add(new Borrar());
      // commandSet.add(new Profile(plugin));
       //commandSet.add(new Cumples(plugin));
       commandSet.add(new Backup());
       commandSet.add(new GiveToken());
        commandSet.add(new DevOnly());
     //   commandSet.add(new LinkAccount());
        //commandSet.add(new UnlockedChecker());
        commandSet.forEach(commandClient::addCommand);

    }
    private void addSlashCommands(CommandClient commandClient) {
        SlashSet.add(new bola8());
        SlashSet.add(new com.nitasorteadora.bot.slashcommands.Backup());
        SlashSet.add(new com.nitasorteadora.bot.slashcommands.Cartas());
        SlashSet.add(new Dbedit());
        SlashSet.add(new Perfil());
        SlashSet.add(new com.nitasorteadora.bot.slashcommands.Sobres());
        SlashSet.add(new GameStats());
        SlashSet.add(new Verify());
      //  SlashSet.add(new SendMessage());
        SlashSet.forEach(commandClient::addSlashCommand);
    }


}
