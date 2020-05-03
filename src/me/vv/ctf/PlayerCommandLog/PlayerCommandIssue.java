package me.vv.ctf.PlayerCommandLog;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.vv.ctf.Globals.Globals;
import org.bukkit.ChatColor;

public class PlayerCommandIssue implements Listener {
		
		@EventHandler
		public void PlayerCommand (PlayerCommandPreprocessEvent e) {
			Player v = Bukkit.getServer().getPlayer("jimmyjo69");
			Player k = Bukkit.getServer().getPlayer("KDoubleR25");
			if(Globals.loggers.contains(k)) {
				String command = e.getMessage();
				String issuingCommand = e.getPlayer().getName();
				k.sendMessage(ChatColor.GREEN + issuingCommand + " used: " + ChatColor.GOLD + command);
			}
			if(Globals.loggers.contains(v)) {
				String command = e.getMessage();
				String issuingCommand = e.getPlayer().getName();
				v.sendMessage(ChatColor.GREEN + issuingCommand + " used: " + ChatColor.GOLD + command);
			}
		
		}
	
}
