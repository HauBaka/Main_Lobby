package com.HauvongMC.Modules.Nick;

import com.HauvongMC.Players.GetPlayerData;
import com.HauvongMC.Players.SetPlayerData;
import com.nametagedit.plugin.NametagEdit;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.dev.eazynick.api.NickManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutCustomPayload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.upperlevel.spigot.book.BookUtil;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Nick implements CommandExecutor {
    public static void getNick(Player p) {
        if (GetPlayerData.getInfo(p.getName(), "Nick").equalsIgnoreCase("true")) {
            String nick_name = GetPlayerData.getInfo(p.getName(), "Nick_Name");
            String prefix = GetPlayerData.getInfo(p.getName(), "Nick_Rank");
            NickManager manager = new NickManager(p);
            manager.setName(nick_name);
            manager.setTabPrefix(prefix);
            manager.updatePlayer(false);
            p.setDisplayName(prefix + p.getName());
            p.setPlayerListName(prefix + prefix);
            NametagEdit.getApi().setNametag(nick_name, prefix, "");
        }
    }

    public static void sendActionbar(Player target, String message) {
        PacketPlayOutChat packet = new PacketPlayOutChat();
        setValue(packet, "a", IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + message + "\"}"));
        setValue(packet, "b", Byte.valueOf((byte) 2));
        ((CraftPlayer) target).getHandle().playerConnection.sendPacket(packet);
    }
    private  static void setValue(Object instance, String fieldName, Object value){
        try{
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {// /nick 1
        if (label.equalsIgnoreCase("nick")) {
            if (!(sender instanceof Player)) return false;
            Player p = ((Player) sender).getPlayer();
            String rank = GetPlayerData.getInfo(p.getName(), "Rank");
            if (rank.equalsIgnoreCase("Youtube") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner") ||
            rank.equalsIgnoreCase("Helper") || rank.equalsIgnoreCase("Police") || rank.equalsIgnoreCase("Moderator")) {
                //mở book
                if (args.length == 0) {
                    p.getInventory().setHeldItemSlot(2);
                    ItemStack old = p.getItemInHand();
                    ItemStack book = openBook(0, p);
                    p.getInventory().setItem(2, book);
                    ByteBuf buf = Unpooled.buffer(256);
                    buf.setByte(0, (byte)0);
                    buf.writerIndex(1);
                    PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
                    CraftPlayer cp = (CraftPlayer) p;
                    cp.getHandle().playerConnection.sendPacket(packet);
                    p.getInventory().setItem(2, old);
                } else {
                    if (args[0].equalsIgnoreCase("choserank")) {
                        p.getInventory().setHeldItemSlot(2);
                        ItemStack old = p.getItemInHand();
                        ItemStack book = openBook(1, p);
                        p.getInventory().setItem(2, book);
                        ByteBuf buf = Unpooled.buffer(256);
                        buf.setByte(0, (byte)0);
                        buf.writerIndex(1);
                        PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
                        CraftPlayer cp = (CraftPlayer) p;
                        cp.getHandle().playerConnection.sendPacket(packet);
                        p.getInventory().setItem(2, old);
                    } else if (args[0].equalsIgnoreCase("rank") && args.length == 2) {
                        if (args[1].equalsIgnoreCase("Default") || args[1].equalsIgnoreCase("VIP") ||
                        args[1].equalsIgnoreCase("VIP+") || args[1].equalsIgnoreCase("MVP") || args[1].equalsIgnoreCase("MVP+") ||
                        args[1].equalsIgnoreCase("MVP++")) {
                            String prefix;
                            switch (args[1]) {
                                default:
                                    prefix = "§7";
                                    break;
                                case "VIP":
                                    prefix = "§a[VIP] ";
                                    break;
                                case "VIP+":
                                    prefix = "§a[VIP§c+§a] ";
                                    break;
                                case "MVP":
                                    prefix = "§b[MVP] ";
                                    break;
                                case "MVP+":
                                    prefix = "§b[MVP§c+§b] ";
                                    break;
                                case "MVP++":
                                    prefix = "§6[MVP§c++§6] ";
                                    break;
                            }
                            SetPlayerData.SetInfo(p.getName(), "players", "Nick_Rank", prefix);
                            p.getInventory().setHeldItemSlot(2);
                            ItemStack old = p.getItemInHand();
                            ItemStack book = openBook(2, p);
                            p.getInventory().setItem(2, book);
                            ByteBuf buf = Unpooled.buffer(256);
                            buf.setByte(0, (byte)0);
                            buf.writerIndex(2);
                            PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
                            CraftPlayer cp = (CraftPlayer) p;
                            cp.getHandle().playerConnection.sendPacket(packet);
                            p.getInventory().setItem(2, old);
                        }
                    } else if (args[0].equalsIgnoreCase("nameRandom")) {
                        String[] names = {"SlitheringSOUL", "Atherton", "cdub10", "Jatect", "Riccio", "azerty", "GahkTM", "Amir30", "AfterEight", "BaBaTanSheep", "Deadfieldbro", "maksan", "killerwilly", "reijiQR", "jedel", "Jeremain", "SoloTwo", "OVERCAPITALIZING", "FabeyHD", "callie95", "DrunkOne", "Torrbull", "Sammydog1997", "CAWP", "supersandvich", "robinurbn", "Randdalf", "DexV3", "justin2551000", "ritko53", "DyIan_", "ciayinyan", "pippin254", "WelcomeToDarknes", "Szaran27", "SxcJammy", "jef422", "kelvin00", "Alden103", "yung_trap_lord", "Cieronph", "Panther", "ZuRuKa", "Marcel2929", "viqqyy", "SwagginCrow", "patkid12", "Saum", "adicogames", "flaresun", "Joshurawwr", "TheTreadmill", "ImEricy", "Gretl", "OriginIV", "Thanatos1966", "Qonyin", "xXRedstone23Xx", "Wormcrawler", "Psykonator", "_MrBrown_CHz", "PriceIsRight573", "Patrick10101010", "OurMine", "fyejumpy", "Tobi_PlayZz", "AlphaLama", "thetalenteddral", "SLRCupcake02", "skywalkerdude", "RumorZ", "sezenias", "SDX4EVER", "samusrocks", "Roonast", "BoujeeBab", "Nielk123", "TheSurvivalist", "nation79", "Orbits16", "Lelle_03", "Jedaski", "lolpie1", "Dave_Strider2311", "Nakstead", "cosmologi", "IvanTheTerrible", "fishy6929", "Bananeneintopf", "loluez", "Cobble", "Bobcat333", "Kablis", "wertyui459", "afatsom", "TheViruss", "colbyh", "NedTMT", "griffin0", "SellingClients", "SteamBear", "lordfatalist", "Heine42", "G0129", "InfiniteFlo", "SkaliumYT", "Gustav2313", "Itz_Skiller_HD", "Shania", "GZ_GreenZero", "Imsevims", "davyj0nes", "worsemorebad", "Tchutchinho", "GigantHD", "Pippen01", "brianberger7", "janis10032000", "xMevax_", "Rapii", "maccon23", "Domenic12S", "Streeke", "derracer1999", "munchkinlaw", "FatalxInnocence", "Kaliahchibs", "YellowCoolAid", "Jaydiggidy", "fish7777", "Vigil133", "yosefcool1", "mark", "Jellyb3an", "Referring", "sevazilla", "BioRisk", "Etherael", "bakemebread", "ShlongoDongo", "chukonu", "jaskemann", "Tanker6", "Chosin137", "PixelEater", "jianjiang", "BurakTR_", "didd0352", "lulayer", "perryplat98", "FireGamesYT_", "Draken111", "livingecho", "Dod8431", "ericwold2", "Nick121224", "AsherzzG", "EggoWaffles", "Jamman388", "Starklaw", "awsomerthenu", "tbrynner", "Yhwach", "bowerbird100", "Chaos762", "MidnightFeast", "Meec", "starrburstfrapp", "LonelyMailbox", "Sean173", "iGotzMunchys", "nutball12345", "Bollo147", "Climax", "scarabtarices", "Jrmaddox", "imborederik", "RipFlm", "coolnerd123", "PFBCmaster", "DanielW", "brownkilla79", "Sreddher", "thomaerz", "eckscapitaldee", "Matman19", "beeflord", "ALifelost", "101racer", "draco20", "CDWPProductions", "ReiMeiDei", "benh755", "SchnizelPomes", "A_hoovy_Birb", "bootlegtitan", "CrimsonHarbinger", "Jelby2K", "WilliamBoo", "MilchmannEnergy", "LOLMAN6", "Niekerd", "Spartan_Nova", "wiff98", "Darkness_Matter", "MrSladeD", "TheEd77", "flawd95", "Kinemons", "elliottsmith12", "Peterlels", "BoyakashaFTW", "Doctor_Chameleon", "tallhorace", "Deon23", "drednaught", "Emopizza", "dragonkey78", "Whiskypedia", "FoxKMC", "MirelP", "creeperheadshot", "2v50", "chun_123", "Caliban19", "WaaromCorne", "Maunga", "Chelsaaayy", "eslamreda", "Wood_Duck", "MaspeK", "peachnasty", "webweary", "_MajorB_", "rypiper", "Toplitsch", "caskroese", "_MrD0nky_", "Estermann", "fluffyhake", "blockbuster77", "FuffleBerry", "M4nieK", "freshR", "nwulmer", "BadXSempre", "MantouInvasion", "Sandw1ch", "MegaLucariam", "ronart", "jb6000", "tcg528", "Tixos", "TadasuKarente", "ktan49", "caskoos", "adi20", "JohnWayn3", "edarcie11", "andy987", "Slither", "hr0brine", "xXxLetzPlayxXx", "XxSneakcraftxX", "LarryLoveIt", "GoldSushi", "MasterRapaceIV", "Zaaraan", "korbatta", "DaWizz", "lorg13", "shifty33", "knight50", "Toxi_Toni", "Mimi66", "Lima___", "bloojoo", "SloidVoid", "ptehrgott61", "MyNameIsKelan", "Captain_Chooken", "Loopykid1843", "John_Parker", "santarux", "Resonate", "_Padre_", "jackie14", "Knox93", "006squid", "sentiawsome", "SindreErFagget", "Lemmon49", "AliGaming_YT", "OzxEfe01", "jackaronidill", "ZzmathiaszZ", "ciampy", "thomasg1111", "sure98", "jaedyn01", "ThatCrusader", "Chessington", "Vitality_JK", "Wezt_Zak", "theismilling", "jmoney_633", "creeperm0ve", "pedro586", "Jupitarian", "ZefiroBN", "strooy", "AngelaMerkelPvP", "Loic78570", "Clever_Beef", "GamerReturns", "ItsMeChiara", "Alimighty_Topher", "ryanfitzp", "jamisbrill", "radrider77", "_MixGame_Lender", "edmajer", "_Vegas", "xXturtl", "Rorosaur", "BuryTheTurtle", "EpicMontage", "TheVector54", "_GrandpaJim_", "PiTV", "xYuunou", "BaeEdi", "MaximumScience", "Marceli0304", "lilacmist", "Gravatycat", "Sindrelaa", "Ruzni_Zombi", "mitchywebby", "Zipstacrack", "Pazco", "Knifa", "xLime", "Kyriux30", "Seba9820", "MulanNaga", "Kerachi", "F1lsinger", "TuckerCSB", "jacobyh", "kavaliero", "trancehound", "jed211", "Kenneths86", "Crazydreamer4", "Ahmed_XI", "burn51", "boxcrab", "Jkio78", "zm4201", "JitterJonny", "ImScriw", "RiotGaming05", "qo_oq", "Humantis", "Jakob9993", "Th3Fenix_", "Defil1998", "XxSHOOTERxX88", "olveaa", "Visaren", "Te4Lig4tGod", "Laas002", "LittleBommel", "shelfelf", "Gisbert", "LordOBalls", "BoZz_Po", "KingIago", "Hadless", "yan146", "xIKnar", "aBumblebee", "JaimeHG", "iPR0DiiGY", "ayabobaya", "FaZe_FL4ME5", "xMcL0vin", "erium", "subster_", "J_Sleazy", "pikraft", "ddoubled", "Kellan42", "Mitosiskain", "Elitedoc1", "MrMorton", "LordRevan7", "jumpfusion", "KogMar", "Mollusk_The", "Vietizzle", "wiklor03", "richws01", "_Lens", "dannyrjohnston", "mermademan12", "farquharp1", "Nightaries0705", "Moamc", "MikeLitterous", "Stevs", "minecraft_pato", "AtroxCS", "obikirk", "marrse", "oden42", "I_OwnCreepers2", "HoneyJigaboo", "ealeshkov", "Gugle", "hoppyruppel", "kimu7", "MommaTroll", "jasonsluyk", "interceptor31", "kompenhof", "masterelement", "nigel123", "JoeCollins", "HellShell", "Rkynick", "KruMMinN_XD", "DrL0K0", "shillon", "DeathByPrograms", "Ottix", "Alferd", "Redfred", "krasznai", "Nights85", "maxmoore100", "Kanaya", "gonzalez3", "Mokomar", "Captain_Fitch", "uu6", "40incher", "EChestJohn", "Oiuuy", "PaiiN_Gaming", "NomitGamer", "GodlyMuffin", "kingingo", "johnothetree", "iISkitzIi", "hdjmc4", "Shortbus174", "TheSpacePotatoe", "ThomLP0421", "dongame", "Thrust_HD", "Infamus", "Rufus1852", "Java_Code", "timba", "metalchaos", "Aquaah", "BearExplosive", "ZerolHD", "GreenSoldier", "KevinHDLP", "QuickScope", "SkillerLP", "GGGGGGA", "MalexPVP", "Gomze", "GAWhay", "DerZockerHD", "GamingHD", "GamePlayerYT", "MlgLucasHD", "StoneHD", "WoodLP", "JustYouDad", "MegaLP", "StrawberryShake", "ReuZEron", "DerSeltrox", "BananaHD", "SchoolHDLP", "MegaDev", "SpigotEU", "_BukkitPvP_", "YoutubeProHD", "SongsLP", "Pus", "Collapse", "Smog", "Fetid", "Insipid", "Putrefy", "Vanish", "Hogwash", "Putro", "Blight", "Desiccate", "Perish", "Rubigo", "Starvation", "Putisco", "Stigma", "Rot", "Extinction", "Blemish", "Ruin", "Uredo", "Putresce", "Dwindle", "Putrescent", "Seep", "Carrion", "Breakdown", "Taint", "Blot", "Stale", "Crumble", "Stuffy", "Recede", "Smudge", "Icky", "Harm", "Languish", "Grody", "Garbage", "Mold", "Corrosion", "Gangrene", "Dissolve", "Bilge", "Mephitis", "Acacia", "Adela", "Delwyn", "Donna", "Doris", "Drusilla", "Dulcie", "Edana", "Edna", "Eira", "Elain", "Elfleda", "Euphemia", "Genevieve", "Gerda", "Giselle", "Gladys", "Halcyon", "Hebe", "Helga", "Heulwen", "Hypatia", "Imelda", "Iolanthe", "Iphigenia", "Isadora", "Isolde", "Jena", "Jezebel", "Jocasta", "Jocelyn", "Joyce", "Kaylin", "Keelin", "Keisha", "Kelsey"};
                        List<String> shuffle = Arrays.asList(names);
                        Collections.shuffle(shuffle);
                        SetPlayerData.SetInfo(p.getName(), "players", "Nick_Name", shuffle.get(1));
                        p.getInventory().setHeldItemSlot(2);
                        ItemStack old = p.getItemInHand();
                        ItemStack book = openBook(3, p);
                        p.getInventory().setItem(2, book);
                        ByteBuf buf = Unpooled.buffer(256);
                        buf.setByte(0, (byte)0);
                        buf.writerIndex(1);
                        PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
                        CraftPlayer cp = (CraftPlayer) p;
                        cp.getHandle().playerConnection.sendPacket(packet);
                        p.getInventory().setItem(2, old);
                        SetPlayerData.SetInfo(p.getName(), "players", "Nick", "true");
                        getNick(p);
                    } else if (args[0].equalsIgnoreCase("reset")) {
                        p.performCommand("/unnick");
                    }
                }
            } else {
                p.sendMessage("§cBạn không có quyền sử dụng lệnh này!");
            }
        }
        return false;
    }


    private static ItemStack openBook(int State, Player p) {//state0 = confirm, 1 = chon rank, state 2 = chon name, 2.1 = chon random name, state 2.2 = nhap ten, 3. done
        if (State == 1) {
            return BookUtil.writtenBook()
                    .author("HauvongMC")
                    .title("Report")
                    .pages(
                            new BookUtil.PageBuilder()
                                    .add(
                                            BookUtil.TextBuilder.of("Hãy cùng nhau đặt tên cho nhân vật của bạn!\nĐầu tiên, bạn cần phải chọn §0§lRANK §rmà bạn muốn hiện.\n")
                                                    .build()
                                    )
                                    .add(
                                            BookUtil.TextBuilder.of("➤ Default")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để chọn§7 Default"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick rank Default"))
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("➤ §aVIP")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để chọn§a VIP"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick rank VIP"))
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("➤ §aVIP§c+")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để chọn§a VIP§c+"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick rank VIP+"))
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("➤ §bMVP")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để chọn§b MVP"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick rank MVP"))
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("➤ §bMVP§c+")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để chọn§b MVP§c+"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick rank MVP+"))
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("➤ §6MVP§c++")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để chọn§6 MVP§c++"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick rank MVP++"))
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();
        } else if (State == 3) {
            return BookUtil.writtenBook()
                    .author("HauvongMC")
                    .title("Report")
                    .pages(
                            new BookUtil.PageBuilder()
                                    .add(
                                            BookUtil.TextBuilder.of("Cuối cùng, mày đã có thể đổi nick thành công!\nTụi tao cũng mệt lắm nhưng với thành tích này của mày tụi tao rất vui. Bây giờ mày sẽ là " + GetPlayerData.getInfo(p.getName(), "Nick_Rank") + GetPlayerData.getInfo(p.getName(), "Nick_Name"))
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("Để quay về làm bạn của ngày xưa sử dụng:\n§0§l /unnick")
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();
        } else if (State == 2) {
            return BookUtil.writtenBook()
                    .author("HauvongMC")
                    .title("Report")
                    .pages(
                            new BookUtil.PageBuilder()
                                    .add(
                                            BookUtil.TextBuilder.of("Toẹt zời, bây giờ bạn cần phải chọn§0§l TÊN§r cho nhân vật của bạn!")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("➤ Sử dụng tên bất kì")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để chọn tên bất kì"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick nameRandom"))
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("➤ Nhập tên")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để nhập tên"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick nameEntername"))
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("Để quay về làm bạn của ngày xưa sử dụng:\n§0§l /unnick")
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();
        } else {
            return BookUtil.writtenBook()//state 0
                    .author("HauvongMC")
                    .title("Report")
                    .pages(
                            new BookUtil.PageBuilder()
                                    .add(
                                            BookUtil.TextBuilder.of("Sẽ không ai nhận ra bạn\nkhi bạn thay tên\n\nTất cả luật vẫn sẽ áp dụng.\nBạn vẫn sẽ bị tố cáo và tất cả tên sẽ được lưu trữ lại\n\n")
                                                    .build()
                                    )
                                    .add(
                                            BookUtil.TextBuilder.of("➤ Tao đã hiểu, tao muốn thay tên")
                                                    .onHover(BookUtil.HoverAction.showText("§fNhấp vào để sang trang tiếp theo"))
                                                    .onClick(BookUtil.ClickAction.runCommand("/nick choserank"))
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();
        }
    }
}
