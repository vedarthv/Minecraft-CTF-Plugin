package me.vv.ctf.Flags;

import com.sun.xml.internal.bind.v2.runtime.Location;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;

public class FlagCarrierNoDrop implements Listener {
	
	@EventHandler 
	public void onEntityDamage(EntityDamageByEntityEvent e) {
    
    if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {  
      Player p = e.getPlayer();
      if(Globals.red_flag_holder.getName().equals(p.getName()) || Globals.blue_flag_holder.getName().equals(p.getName())) {
        p.sendMessage(ChatColor.RED + "You are holding a flag and hence cannot fight!");
        e.setCancelled(true);
      }
    }
  }
}
