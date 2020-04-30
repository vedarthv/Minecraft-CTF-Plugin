package me.vv.ctf.Flags;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import me.vv.ctf.Globals.Globals;


public class FlagCarrierNoDrop implements Listener {
	
	@EventHandler 
	public void onEntityDamage(EntityDamageByEntityEvent e) {
    if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {  
    	Player p = (Player)e.getEntity();
      
    	if(Globals.red_flag_holder.getName().equals(p.getName()) || Globals.blue_flag_holder.getName().equals(p.getName())) {
    		p.sendMessage(ChatColor.RED + "You are holding a flag and hence cannot fight!");
    		e.setCancelled(true);
      }
    }
  }
}
