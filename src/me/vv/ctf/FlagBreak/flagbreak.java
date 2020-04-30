package me.vv.ctf.FlagBreak;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class flagbreak implements Listener {


	@EventHandler 
	public void onPlayerBlockEvent(BlockBreakEvent e) {
	
	Player p = e.getPlayer();
	p.sendMessage("You have broken a " + e.getBlock().getType());
	
	if(e.getBlock().getType().equals(Material.BLUE_BANNER)) {
		p.sendMessage(ChatColor.GREEN + "You broke the Blue team's flag!");
		Bukkit.broadcastMessage(ChatColor.BLUE + "The Blue team's flag was broken "  + ChatColor.BOLD + p.getName() + "!");
		}
	
	else if (e.getBlock().getType().equals(Material.RED_BANNER)) {
		p.sendMessage(ChatColor.GREEN + "You broke the Red team's flag!");
		Bukkit.broadcastMessage(ChatColor.RED + "The Red team's flag was broken by " + ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + "!");
		}
	
	}
}