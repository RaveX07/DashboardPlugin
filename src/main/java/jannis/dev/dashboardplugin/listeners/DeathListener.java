package jannis.dev.dashboardplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class DeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();

        event.setDeathMessage(ChatColor.DARK_RED.toString() + ChatColor.UNDERLINE + "Haha ... " + event.getDeathMessage());
    }
}
