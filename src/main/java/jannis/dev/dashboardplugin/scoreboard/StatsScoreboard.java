package jannis.dev.dashboardplugin.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class StatsScoreboard {
    public void setScoreboard(Player player) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("stats", "dummy", "stats");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.AQUA.toString() + ChatColor.UNDERLINE + "  9d Gang Server  ");

        String playerDeaths = String.valueOf(player.getStatistic(Statistic.DEATHS));
        String playerMobKills = String.valueOf(player.getStatistic(Statistic.MOB_KILLS));
        String playerPlayerKills = String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS));

        Team deaths = scoreboard.registerNewTeam("deaths");
        Team playerKills = scoreboard.registerNewTeam("playerKills");
        Team mobKills = scoreboard.registerNewTeam("mobKills");

        obj.getScore(ChatColor.RED.toString() + ChatColor.UNDERLINE + "Deaths: ").setScore(7);
        obj.getScore(ChatColor.RED.toString()).setScore(6);
        obj.getScore(ChatColor.AQUA.toString()).setScore(5);
        obj.getScore(ChatColor.LIGHT_PURPLE.toString() + ChatColor.UNDERLINE + "Player Kills:").setScore(4);
        obj.getScore(ChatColor.LIGHT_PURPLE.toString()).setScore(3);
        obj.getScore(ChatColor.AQUA.toString()).setScore(2);
        obj.getScore(ChatColor.GREEN.toString() + ChatColor.UNDERLINE + "Mob Kills:").setScore(1);
        obj.getScore(ChatColor.GREEN.toString()).setScore(0);

        deaths.addEntry(ChatColor.RED.toString());
        deaths.setPrefix(ChatColor.GRAY + playerDeaths);

        playerKills.addEntry(ChatColor.LIGHT_PURPLE.toString());
        playerKills.setPrefix(ChatColor.GRAY + playerPlayerKills);

        mobKills.addEntry(ChatColor.GREEN.toString());
        mobKills.setPrefix(ChatColor.GRAY + playerMobKills);

        player.setScoreboard(scoreboard);

    }
    public void update(Player player) {
        String playerDeaths = String.valueOf(player.getStatistic(Statistic.DEATHS));
        String playerMobKills = String.valueOf(player.getStatistic(Statistic.MOB_KILLS));
        String playerPlayerKills = String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS));

        Scoreboard scoreboard = player.getScoreboard();

        Team deaths = scoreboard.getTeam("deaths");
        Team playerKills = scoreboard.getTeam("playerKills");
        Team mobKills = scoreboard.getTeam("mobKills");

        deaths.setPrefix(ChatColor.GRAY + playerDeaths);
        playerKills.setPrefix(ChatColor.GRAY + playerPlayerKills);
        mobKills.setPrefix(ChatColor.GRAY + playerMobKills);

    }
}
