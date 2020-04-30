package me.vv.ctf.FlagBreak;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;


public class flagplace  implements Listener {
	
	
	
	@EventHandler 
	public void onBlockPlace(BlockPlaceEvent flag_place) {
		
		Player p = flag_place.getPlayer();
		
	    if (flag_place.getBlockPlaced().getType().equals(Material.RED_BANNER)) {
	        Material belowType = flag_place.getBlockPlaced().getRelative(BlockFace.DOWN).getType();
	        if(belowType.equals(Material.LAPIS_BLOCK)) {
	        	Bukkit.broadcastMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "The Blue team has scored a point!");
	        	Bukkit.broadcastMessage(ChatColor.BLUE + "" + ChatColor.BOLD + p.getName() + " scored the  point!");
	        	}
	    	}
	    if (flag_place.getBlockPlaced().getType().equals(Material.BLUE_BANNER)) {
	        Material belowType = flag_place.getBlockPlaced().getRelative(BlockFace.DOWN).getType();
	        if(belowType.equals(Material.NETHERRACK)) {
	        	Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "The Red team has scored a point!");
	        	Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD +  p.getName() + " scored the  point!");
	        	}
	        }	

	}	

}


