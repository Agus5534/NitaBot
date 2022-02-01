package com.nitasorteadora.bot;

import com.jagrosh.jdautilities.command.*;
import com.nitasorteadora.bot.commands.administrativos.*;
import com.nitasorteadora.bot.commands.cartas.AbrirSobre;
import com.nitasorteadora.bot.commands.cartas.Cartas;
import com.nitasorteadora.bot.commands.cartas.Dailycard;
import com.nitasorteadora.bot.commands.cartas.Sobres;
import com.nitasorteadora.bot.commands.extra.Cumples;
import com.nitasorteadora.bot.commands.teams.Addteam;
import com.nitasorteadora.bot.commands.teams.AnnounceTeams;
import com.nitasorteadora.bot.commands.teams.Borrar;
import com.nitasorteadora.bot.commands.teams.ClearTeams;
import com.nitasorteadora.bot.commands.utils.Comandos;
import com.nitasorteadora.bot.commands.utils.LinkAccount;
import com.nitasorteadora.bot.commands.utils.Profile;
import com.nitasorteadora.bot.listeners.GuildMemberJoin;
import com.nitasorteadora.bot.listeners.SelectionMenu;
import com.nitasorteadora.bot.slashcommands.Dbedit;
import com.nitasorteadora.bot.slashcommands.Perfil;
import com.nitasorteadora.bot.slashcommands.bola8;
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
    public boolean devbot = true;
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
           // jdaBuilder.addEventListeners(new SlashCommands());
            //jdaBuilder.addEventListeners(new ButtonClick());
            jdaBuilder.addEventListeners(new SelectionMenu());
            jda = jdaBuilder.build();
            /*
            List<CommandData> cmds = new ArrayList<CommandData>();
            List<CommandData> testcmds = new ArrayList<CommandData>();
           cmds.add(new CommandData("bola8", "Predice algo").addOption(OptionType.STRING, "pregunta", "Una pregunta que tendré que responder", true));
            cmds.add(new CommandData("backup","Haz un backup"));
            cmds.add(new CommandData("perfil","Mira el perfil tuyo o de alguien").addOption(OptionType.USER,"usuario","El usuario de quien quieres ver el perfil (opcional)",false));
            cmds.add(new CommandData("cartas","Mira las cartas tuyas o de alguien").addOption(OptionType.USER,"usuario","El usuario de quien quieres ver las cartas (opcional)", false));
            cmds.add(new CommandData("dbedit","Edita la base de datos").addOption(OptionType.STRING,"path","Database Path",true).addOption(OptionType.INTEGER, "value","To set value (Integer)", true));
            if(!devbot) {
                //jda.getGuildById("754918107587543043").updateCommands().addCommands(testcmds).queue();
                jda.updateCommands().addCommands(cmds).queue();
            }
*/


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
        builder.setActivity(Activity.playing("??/37"));
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
       commandSet.add(new Profile(plugin));
       commandSet.add(new Cumples(plugin));
       commandSet.add(new Cartas());
       commandSet.add(new Backup());
       commandSet.add(new Sobres());
       commandSet.add(new AbrirSobre());
       commandSet.add(new GiveToken());
      // commandSet.add(new DevTest());
        commandSet.add(new DevOnly());
        commandSet.add(new LinkAccount());
        commandSet.add(new UnlockedChecker());
        commandSet.forEach(commandClient::addCommand);

    }
    private void addSlashCommands(CommandClient commandClient) {
        SlashSet.add(new bola8());
        SlashSet.add(new com.nitasorteadora.bot.slashcommands.Backup());
        SlashSet.add(new com.nitasorteadora.bot.slashcommands.Cartas());
        SlashSet.add(new Dbedit());
        SlashSet.add(new Perfil());
        SlashSet.add(new com.nitasorteadora.bot.slashcommands.Sobres());
        SlashSet.forEach(commandClient::addSlashCommand);
    }


}
