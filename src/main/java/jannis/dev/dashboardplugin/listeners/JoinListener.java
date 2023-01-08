package jannis.dev.dashboardplugin.listeners;

import jannis.dev.dashboardplugin.DashboardPlugin;
import jannis.dev.dashboardplugin.scoreboard.StatsScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        event.setJoinMessage(ChatColor.GREEN.toString() + ChatColor.UNDERLINE + "Oh nooo ... " + player.getName() + " is back!!!");

        DashboardPlugin.getInstance().statsScoreboard.setScoreboard(player);

        Bukkit.getScheduler().runTaskTimer(DashboardPlugin.getInstance(), () -> {
            DashboardPlugin.getInstance().statsScoreboard.update(player);
        }, 0, 20);

    }

}
