package me.vv.ctf.Flags;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;


public class FlagCarrierDead implements Listener {
	
	@EventHandler 
	public void onPlayerDeath(PlayerDeathEvent e) {
		
    Player p = (Player)e.getEntity();
    Material banner;
    Team opposingTeam = null;
    if(Globals.safeGetName(Globals.red_flag_holder).equals(p.getName())) {
    	Globals.red_flag_holder = null;
    	banner = Material.RED_BANNER;
    	opposingTeam = Globals.blue_team;
    } 
    else if(Globals.safeGetName(Globals.blue_flag_holder).equals(p.getName())) {
    	Globals.blue_flag_holder = null;
    	banner = Material.BLUE_BANNER;
    	opposingTeam = Globals.red_team;
    } 
    else {
    	return;
    }
    p.getInventory().remove(banner);
    p.getLocation().getBlock().setType(banner);
    Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was dropped at " +
    Globals.getNiceLocation(p.getLocation()) + ".");
    	
  }
}


