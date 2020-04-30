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
    if(Globals.red_flag_holder.getName().equals(p.getName())) {
      banner = Material.RED_BANNER;
    } else if(Globals.blue_flag_holder.getName().equals(p.getName())) {
      banner = Material.BLUE_BANNER;
    } else {
      return;
    }

		Team opposingTeam = null;
		if(Globals.red_team.isPlayerInTeam(p)) {
			opposingTeam = Globals.blue_team;
		} else if(Globals.blue_team.isPlayerInTeam(p)) {
			opposingTeam = Globals.red_team;
		}

    p.getInventory().remove(banner);
    p.getLocation().getBlock().setType(banner);
    Bukkit.broadcastMessage(opposingTeam.getColour() + "Team " + opposingTeam.getName() + "'s flag was dropped at " +
      p.getLocation().toString() + ".");
  }
}


