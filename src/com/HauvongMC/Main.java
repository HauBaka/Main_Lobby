package com.HauvongMC;

import com.HauvongMC.Cmd.*;
import com.HauvongMC.Cmd.FunCommands.*;
import com.HauvongMC.Cmd.FunCommands.Snowball;
import com.HauvongMC.Cmd.MenuCommands.PunchMessagesMenuCommand;
import com.HauvongMC.Cmd.MenuCommands.RankColorMenuCommand;
import com.HauvongMC.Cmd.StaffCommands.*;
import com.HauvongMC.Events.*;
import com.HauvongMC.Events.MenuEvents.*;
import com.HauvongMC.Events.MenuEvents.SubMenuEvents.*;
import com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.PunchMessagesEvents;
import com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.RankColorEvents;
import com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.SubMenuEvents.GeneralStatusEvents;
import com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.SubMenuEvents.MVPPPStatusEvents;
import com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.StatusEvents;
import com.HauvongMC.Events.MenuEvents.SubMenuEvents.SubMenuEvents.SubMenuEvents.SkywarsStatusEvents;
import com.HauvongMC.Items.*;
import com.HauvongMC.Items.SubMenu.SubMenu.RankColorItems;
import com.HauvongMC.Items.SubMenu.SettingsItems;
import com.HauvongMC.Items.SubMenu.SubMenu.StatusItems;
import com.HauvongMC.Listener.BungeeListener;
import com.HauvongMC.Listener.PAPIHook;

import com.HauvongMC.Modules.Nick.Nick;
import com.HauvongMC.Modules.Nick.Unnick;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import java.io.File;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;



public class Main extends JavaPlugin {
    Logger log = Bukkit.getLogger();
    public static Main plugin;
    private static Location spawn;
    public static HashMap<Player, Integer> chatinput = new HashMap<>();// 0 = null, 1 = search friend, 2 = add friend, 3 = remove friend, 4 = search recent player, 5 = twitter, 6= yt, 7 = instagram, 8 = twitch, 9 = discord, 10 = forum, 11 = invite player to guild, 12 = create guild
    public static HashMap<Player, ArmorStand> head_status = new HashMap<>();
    public static HashMap<Player, Integer> taskid_gamemenu = new HashMap<>();
    public static HashMap<Player, Boolean> playervisibility_delay = new HashMap<>();
    public static List<ItemStack> updates = new ArrayList<>();
    public static HashMap<Player, Integer> head_status1 = new HashMap<>();
    public static HashMap<Player, Integer> head_status2 = new HashMap<>();
    @Override
    public void onEnable() {
        head_status1 = new HashMap<>();
        head_status2 = new HashMap<>();
        playervisibility_delay = new HashMap<>();
        chatinput = new HashMap<>();
        head_status = new HashMap<>();
        taskid_gamemenu = new HashMap<>();
        plugin = this;
        log.info("§aHauvongMC Enable");
        mysqlSetup();
        registerEvents();
        this.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", new BungeeListener());
        registerCommands();
        new PAPIHook().register();
        chatinput = new HashMap<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.kickPlayer("§aServer Reload\nPlease rejoin\nlmao.");
        }
        //register item
        registerItems();
        //get spawn
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC").getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        spawn = new Location(Bukkit.getWorld(config.getString("Spawn.world")), config.getInt("Spawn.x"), config.getInt("Spawn.y"), config.getInt("Spawn.z"), config.getInt("Spawn.yaw"), config.getInt("Spawn.pitch"));
        //remove armorstand
        for (Entity entity : spawn.getWorld().getEntities()) {
            if (entity.hasMetadata("Head_Status") || entity.getType() == EntityType.ARMOR_STAND) {
                entity.remove();
            }
        }
    }

    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            ArmorStand armorStand = head_status.get(p);
            if (armorStand != null) {
                armorStand.remove();
            }
        }
        log.info("§cHauvongMC Disable");
    }

    public static Connection connection;
    public String host, database, username, password;
    public int port;
    private static File file;
    public void mysqlSetup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC").getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        host = config.getString("mysql.host");
        port = config.getInt("mysql.port");
        database = config.getString("mysql.database");
        username = config.getString("mysql.user");
        password = config.getString("mysql.password");
        if (password == null) {
            password = "";
        }
        try{
            synchronized (this){
                if(getConnection() != null && !getConnection().isClosed()){
                    return;
                }
                Class.forName("com.mysql.jdbc.Driver");
                setConnection( DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password));
                connection = DriverManager.getConnection("jdbc:mysql://"+ this.host + ":" + this.port + "/" + this.database,this.username, this.password);
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[HauvongMC &8-&e SQL&a]&b Connected &djdbc:mysql://" + host + ":" + port + "/" + database + ", " + username + ", " + password));
            }
        }catch(SQLException e){
            e.printStackTrace();
            this.getPluginLoader().disablePlugin(this);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public void registerItems(){
        new JoinItem();
        //new MenuItems().MenuItems();
        //new FriendsItems().FriendsItems();
        //new PartyItems().PartyItems();
        //new GuildItems().GuildItems();
        //new RecentPlayersItems().RecentPlayersItems();
        //new AppearancesItems().AppearancesItems();
        new RankColorItems().RankColorItems();
        new StatusItems().StatusItems();
        new SettingsItems().SettingsItems();
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC").getDataFolder(), "updates.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        List<String> updatesd = config.getStringList("updatelists");
        for (String update : updatesd) {
            ItemStack item = new ItemStack(Material.getMaterial(config.getInt("Items." + update + ".ID")));
            String enchant = config.getString("Items." + update + ".Enchant");
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setLore(config.getStringList("Items." + update + ".Lore"));
            itemMeta.setDisplayName(config.getString("Items." + update + ".Name"));
            if (enchant.equalsIgnoreCase("true")) {
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            item.setItemMeta(itemMeta);
            System.out.println(itemMeta.getDisplayName());
            updates.add(item);
        }
    }

    public void registerEvents(){
            PluginManager pm = getServer().getPluginManager();
            pm.registerEvents(new PlayerJoin(),  this);
        pm.registerEvents(new PlayerQuit(),  this);
        pm.registerEvents(new Chat(),  this);
        pm.registerEvents(new LobbyEvent(),  this);
        pm.registerEvents(new myprofileEvent(),  this);
        pm.registerEvents(new friendmenuEvent(),  this);
        pm.registerEvents(new MenuHeader(),  this);
        pm.registerEvents(new guildevents(),  this);
        pm.registerEvents(new recentplayersmenuEvent(),  this);
        pm.registerEvents(new SocialMediaMenuEvents(), this);
        pm.registerEvents(new StatsViewerEvent(), this);
        pm.registerEvents(new AppearancesMenuEvents(), this);
        pm.registerEvents(new RankColorEvents(), this);
        pm.registerEvents(new PunchMessagesEvents(), this);
        pm.registerEvents(new MVPPPStatusEvents(), this);
        pm.registerEvents(new StatusEvents(), this);
        pm.registerEvents(new GeneralStatusEvents(), this);
        pm.registerEvents(new SkywarsStatusEvents(), this);
        pm.registerEvents(new SettingsMenuEvents(), this);
        pm.registerEvents(new GameMenuEvent(), this);
        pm.registerEvents(new UpdatesMenuEvents(), this);
        pm.registerEvents(new EntityDamage(),  this);
        pm.registerEvents(new ViewerSocialMediaEvent(),  this);
        pm.registerEvents(new ProfileViewerEvent(),  this);
    }

    public void registerCommands(){
        //cmd
        this.getCommand("profile").setExecutor(new ProfileCommand());
        this.getCommand("unnick").setExecutor(new Unnick());
        this.getCommand("nick").setExecutor(new Nick());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("updates").setExecutor(new UpdatesCommand());
        this.getCommand("Rule").setExecutor(new Rule());
        //staffcommands
        this.getCommand("Rank").setExecutor(new SetRank());
        this.getCommand("kaboom").setExecutor(new Kaboom());
        this.getCommand("cs").setExecutor(new ChangeServer());
        this.getCommand("setspawn").setExecutor(new SetSpawn());
        this.getCommand("NetworkLevelDataBase").setExecutor(new NetworkLevelDataBase());
        this.getCommand("SetPlayerEXP").setExecutor(new SetPlayerEXP());
        this.getCommand("SetPlayerData").setExecutor(new SetPlayerDataCommand());
        this.getCommand("CheckPlayers").setExecutor(new CheckPlayers());
        this.getCommand("SetStaffCode").setExecutor(new SetStaffCode());
        //funcommands
        this.getCommand("admin").setExecutor(new admin());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("garlicbread").setExecutor(new garlicbread());
        this.getCommand("hello").setExecutor(new hello());
        this.getCommand("mystery").setExecutor(new mystery());
        this.getCommand("opme").setExecutor(new opme());
        this.getCommand("pokemon").setExecutor(new pokemon());
        this.getCommand("rawr").setExecutor(new rawr());
        this.getCommand("removearenabrawl").setExecutor(new removearenabrawl());
        this.getCommand("Snowball").setExecutor(new Snowball());
        this.getCommand("thiscommandliterallydoesnothing").setExecutor(new thiscommandliterallydoesnothing());
        this.getCommand("whatdoyoudo").setExecutor(new whatdoyoudo());
        this.getCommand("PunchMessagesMenu").setExecutor(new PunchMessagesMenuCommand());
        this.getCommand("rankcolormenu").setExecutor(new RankColorMenuCommand());
    }
    public static Connection getConnection() {
        return connection;
    }

    public static Plugin getPlugin() {
        return plugin;
    }
    public static Location getSpawn() {
        return spawn;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
