package me.vv.ctf.Flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import me.vv.ctf.Globals.Globals;


public class FlagCarrierNoPVP implements Listener {
	
	@EventHandler 
	public void onEntityDamage(EntityDamageByEntityEvent e) {
    if(e.getEntity() instanceof Player) {  
    	Player p = null;
    	if(e.getDamager() instanceof Player) {
    		p = (Player)e.getDamager();
    	} else if(e.getDamager() instanceof Arrow){
    		Arrow arrow = (Arrow)e.getDamager();
    		if(!(arrow.getShooter() instanceof Player)) {
    			return;
    		} else {
    			p = (Player)arrow.getShooter();
    		}
    	}

    	if(Globals.safeGetName(Globals.red_flag_holder).equals(p.getName()) || Globals.safeGetName(Globals.blue_flag_holder).equals(p.getName())) {
    		p.sendMessage(ChatColor.RED + "You are holding a flag and hence cannot fight!");
    		e.setCancelled(true);
      }
    }
  }
}
