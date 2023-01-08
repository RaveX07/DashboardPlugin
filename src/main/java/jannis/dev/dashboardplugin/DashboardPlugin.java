package jannis.dev.dashboardplugin;

import jannis.dev.dashboardplugin.listeners.DeathListener;
import jannis.dev.dashboardplugin.listeners.JoinListener;
import jannis.dev.dashboardplugin.listeners.QuitListener;
import jannis.dev.dashboardplugin.scoreboard.StatsScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DashboardPlugin extends JavaPlugin {

    private static DashboardPlugin instance;
    public StatsScoreboard statsScoreboard = new StatsScoreboard();

    @Override
    public void onLoad() {
        instance = this;
    }
    @Override
    public void onEnable() {

        System.out.println("###########################################");
        System.out.println("Plugin enabled");
        System.out.println("###########################################");

        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Dashboard-plugin succesfully enabled");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
        manager.registerEvents(new DeathListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DashboardPlugin getInstance() {
        return instance;
    }
}
