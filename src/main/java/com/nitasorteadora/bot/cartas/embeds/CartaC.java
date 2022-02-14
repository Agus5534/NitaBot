package com.nitasorteadora.bot.cartas.embeds;

import java.util.Arrays;

public enum CartaC {
    //Comunes
    EVIL("El Dasher","Evil","<:Evil:793945486109179904>","https://cdn.discordapp.com/attachments/818613273813319781/872308037484945438/1eldasher.jpg","CartaEvil.",1,CalidadC.COMUN, "793945486109179904"),
    MAGIC("El Modder","Magic","<:Magic:788433576848261130>","https://cdn.discordapp.com/attachments/818613273813319781/871973224005640212/1elmodder.jpg","CartaMagic.",1, CalidadC.COMUN,"788433576848261130"),
    MAURITO("El Mayor","Maurito","<:Maurito:788421660620881920>","https://cdn.discordapp.com/attachments/818613273813319781/871973273431326740/1elmayor.jpg","CartaMaurito.",1,CalidadC.COMUN,"788421660620881920"),
    ZIJHYAN("El Mago Ingeniero","Zijhyan","<:Zijhyan:788421732125507595>","https://cdn.discordapp.com/attachments/818613273813319781/872201410341658674/1elingeniero.jpg","CartaZij.",1,CalidadC.COMUN,"788421732125507595"),
    AYDEN("El Entusiasta","Ayden","<:Ayden:895019810449158155>","https://cdn.discordapp.com/attachments/818613273813319781/895150877919301652/1elentusiasta.jpg","CartaAyden.",3,CalidadC.COMUN,"895019810449158155"),
    CHARLYDAVID("El Multiestilo","Charly","<:Charly:864214891275223070>","https://cdn.discordapp.com/attachments/818613273813319781/879875055620874301/1elmultiestilo.jpg","CartaCharly.",3,CalidadC.COMUN,"864214891275223070"),
    FLOWII("La Cantante","Flowii","<:Flowii:864240761573998593>","https://cdn.discordapp.com/attachments/818613273813319781/884606533923639296/1lacantante.jpg","CartaFlowii.",3,CalidadC.COMUN,"864240761573998593"),
    GOGETA1956("El Referencias","Goge","<:Goge:864242052559667210>","https://cdn.discordapp.com/attachments/818613273813319781/884606642707103814/1elreferencias.jpg","CartaGoge.",3,CalidadC.COMUN,"864242052559667210"),
    SPIKER("El Boomer","Spiker","<:Spiker:864214891458986034>","https://cdn.discordapp.com/attachments/818613273813319781/884575316805308436/1elboomer.jpg","CartaSpiker.",3,CalidadC.COMUN,"864214891458986034"),
    SRLEXAN("El Distraido","Lexan","<:Lexan:892154822277619722>","https://cdn.discordapp.com/attachments/818613273813319781/892875761189519411/1eldistraido.jpg","CartaLexan.",3,CalidadC.COMUN,"892154822277619722"),
    STARRFALLZ("La Indecisa","Starr","<:Starrzfall:864216141685456956>","https://cdn.discordapp.com/attachments/818613273813319781/884575359788535869/1laindecisa.jpg","CartaStarr.",3,CalidadC.COMUN,"864216141685456956"),
    TATURC("El Boludo","Tatu","<:Tatu:864214891249139772>","https://cdn.discordapp.com/attachments/818613273813319781/879509809580367902/1elboludo.jpg","CartaTatu.",3,CalidadC.COMUN,"864214891249139772"),
    JANETHY("La Tierna","Janethy","<:Janethy:940699211576537148>","https://cdn.discordapp.com/attachments/818995908779835393/941523918278258748/1latierna.jpg","CartaJanethy.",0,CalidadC.COMUN,"940699211576537148"),
    //Raras
    CUCHI("La Pequeña","Cuchi","<:Cuchi:864245161993961473>","https://cdn.discordapp.com/attachments/818613273813319781/871923636737564693/1lapequena.jpg","CartaCuchi.",1,CalidadC.RARA,"864245161993961473"),
    UIMPI("La Animadora","Uimpi","<:Uimpi:799828322287747092>","https://cdn.discordapp.com/attachments/818613273813319781/872201333636222976/1laanimadora.jpg","CartaUimpi.",1,CalidadC.RARA,"799828322287747092"),
    PATO("El Discreto","Pato","<:Pato:822562210554445845>","https://cdn.discordapp.com/attachments/818613273813319781/873422071340884029/1eldiscreto.jpg","CartaPato.",2,CalidadC.RARA,"822562210554445845"),
    SALVADOR("El Impaciente","Salvi","<:Salvador:819332288759332864>","https://cdn.discordapp.com/attachments/818613273813319781/873350979045711943/1elimpaciente.jpg","CartaSalvi.",2,CalidadC.RARA,"819332288759332864"),
    AZGALORD("La Tele","Azga","<:Azgalord:879875183572287518>","https://cdn.discordapp.com/attachments/818613273813319781/879874891472588860/1latele.jpg","CartaAzga.",3,CalidadC.RARA,"879875183572287518"),
    HEIS("El Sicario","Heis","<:Heis:864214891493326878>","https://cdn.discordapp.com/attachments/818613273813319781/879509720266862662/1elsicario.jpg","CartaHeis.",3,CalidadC.RARA,"864214891493326878"),
    INFERNAL("El Loco","Infernal","<:Infernal:864214891149262859>","https://cdn.discordapp.com/attachments/818613273813319781/879874620407300096/1elloco.jpg","CartaInfer.",3,CalidadC.RARA,"864214891149262859"),
    MARIO("El Pokemaníaco","Mario","<:Mario:864214891283349505>","https://cdn.discordapp.com/attachments/818613273813319781/884575253915926588/1elpokemaniaco.jpg","CartaMario.",3,CalidadC.RARA,"864214891283349505"),
    YURI("El Valerense","Yuri","<:Yuri:864214891538677780>","https://cdn.discordapp.com/attachments/818613273813319781/879874807427104768/elvarelense.jpg","CartaYuri.",3,CalidadC.RARA,"864214891538677780"),
    CARMENED("El Espontáneo","Carmened","<:Carmened:935644590441107556>","https://cdn.discordapp.com/attachments/818995908779835393/936805180731699230/1elespontaneo.jpg","CartaCarmened.",0,CalidadC.RARA,"935644590441107556"),
    FABO("El Asustadizo","Fabo","<:Fabo:935644590680199179>","https://cdn.discordapp.com/attachments/818995908779835393/936805180408733706/1elasustadizo.jpg","CartaFabo.",0,CalidadC.RARA,"935644590680199179"),
    HERMES("El Pistolero","Hermes","<:Hermes:940737531916451881>","https://cdn.discordapp.com/attachments/818995908779835393/941523919322628126/1elpistolero.jpg","CartaHermes.",0,CalidadC.RARA,"940737531916451881"),
    ZAPATA("El Trickster","Zapata","<:Zapata:940699523599204392>","https://cdn.discordapp.com/attachments/818995908779835393/941523918836076614/1eltrickster.jpg","CartaZapata.",0,CalidadC.RARA,"940699523599204392"),
    //Epicas
    AUGUSIMPERIAL("El Imperial","AugusImperial","<:Augus:804429263431532605>","https://cdn.discordapp.com/attachments/818613273813319781/871972935185879070/1elimperial.jpg","CartaAugus.",1,CalidadC.EPICA,"804429263431532605"),
    IKI("El Guardián","Iki","<:Iki:830295031319101471>","https://cdn.discordapp.com/attachments/818613273813319781/872201470202753065/1elguardian.jpg","CartaIki.",1,CalidadC.EPICA,"830295031319101471"),
    IVOO("El Turro","Ivoo","<:Ivo:788418435590914058>","https://cdn.discordapp.com/attachments/818613273813319781/872201224819200080/1elturro.jpg","CartaIvo.",1,CalidadC.EPICA,"788418435590914058"),
    LUQUIMC("El Tranquilo","LuquiMC","<:Luqui:851185434284916787>","https://cdn.discordapp.com/attachments/818613273813319781/871973173573324840/1eltranquilo.jpg","CartaLuqui.",1,CalidadC.EPICA,"851185434284916787"),
    NITA("La Artista","Nita","<:Nita:864245827891363871>","https://cdn.discordapp.com/attachments/818613273813319781/871923529573105714/1laartista.jpg","CartaNita.",1,CalidadC.EPICA,"864245827891363871"),
    SUBXASO("El Comediante","SubXaso","<:Sub:931371258703118366>","https://cdn.discordapp.com/attachments/818995908779835393/936797199231254619/1elcomediante.jpg","CartaSub.",1,CalidadC.EPICA,"931371258703118366"),
    THEBOYPANDA("El Paciente","TheBoyPanda","<:Panda:871861308251856936>","https://cdn.discordapp.com/attachments/818613273813319781/871923579388821564/1elpaciente.jpg","CartaPanda.",1,CalidadC.EPICA,"871861308251856936"),
    CONNG("La Editora","ConnG","<:Conn:852972434188795915>","https://cdn.discordapp.com/attachments/818613273813319781/873351022221856768/1laeditora.jpg","CartaConn.",2,CalidadC.EPICA,"852972434188795915"),
    RUFK("El Inquieto","Rufk","<:Rufk:819332353939210241>","https://cdn.discordapp.com/attachments/818613273813319781/873422021311221800/1elinquieto.jpg","CartaRufk.",2,CalidadC.EPICA,"819332353939210241"),
    APOCALIX("El Cortés","Apocalix","<:Apocalix:940737531828371506>","https://cdn.discordapp.com/attachments/818995908779835393/941523919804981318/1elcortes.jpg","CartaApocalix.",0,CalidadC.EPICA,"940737531828371506"),
    MAGE("El Payaso","Mage","<:UNKMage:940699211731718144>","https://cdn.discordapp.com/attachments/818995908779835393/941523917816877077/1elpayaso.jpg","CartaMage.",0,CalidadC.EPICA,"940699211731718144"),

    //Legendarias
    LUCMUS("El Admin","Lucmus","<:Lucmus:867887798476472331>","https://cdn.discordapp.com/attachments/818613273813319781/871923482953392128/1eladmin.jpg","CartaLucmus.",1,CalidadC.LEGENDARIA,"867887798476472331"),
    NYREM("El Callado","Nyrem","<:Nyrem:842794066299191296>","https://cdn.discordapp.com/attachments/818613273813319781/871973314631970816/1elcallado.jpg","CartaNyrem.",1,CalidadC.LEGENDARIA,"842794066299191296"),
    AGUS("El Programador","Agus5534","<:Agus:873056466972581920>","https://cdn.discordapp.com/attachments/818613273813319781/884650845638103050/1elprogramador.jpg","CartaAgus5534.",3,CalidadC.LEGENDARIA,"873056466972581920"),

    //Miticas
    LaEntidad("La Entidad","LaEntidad","<:testemote:892895101527932991>","https://cdn.discordapp.com/attachments/818995908779835393/892876921438875648/1entidad.jpg","CartaLaEntidad.",3,CalidadC.MITICA,"892895101527932991"),
    NitaBot("NitaBot","NitaBot","<:testemote:892895101527932991>","https://cdn.discordapp.com/attachments/818995908779835393/892876959032414218/1nitabot.jpg","CartaNitaBot.",3,CalidadC.MITICA,"892895101527932991");


    private String name;
    private String author;
    private String emote;
    private String emoteid;
    private String image;
    private String dbName;
    private int season;
    private CalidadC calidad;
    private String frase;
    CartaC(String name, String author, String emote, String image, String dbName, int season, CalidadC calidad, String emoteid){
        this.name = name;
        this.author = author;
        this.emote = emote;
        this.image = image;
        this.dbName = dbName;
        this.season = season;
        this.calidad = calidad;
        this.emoteid = emoteid;
    }
    public String getName() { return name; }
    public String getAuthor() { return author; }
    public String getEmote() { return emote; }
    public String getImage() { return image; }
    public String getDBName() { return dbName; }
    public Integer getSeason() { return season; }
    public CalidadC getCalidad() { return calidad; }
    public String getFrase() { return frase; }
    public String getEmoteid() {
        return emoteid;
    }
    public static String[] getAll(Class<? extends Enum<?>> e){
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}
