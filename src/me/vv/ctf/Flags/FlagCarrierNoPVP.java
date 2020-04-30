package me.vv.ctf.Flags;

import com.sun.xml.internal.bind.v2.runtime.Location;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;

public class FlagCarrierNoPVP implements Listener {
	
	@EventHandler 
	public void onPlayerDropItem(PlayerDropItemEvent e) {

    if(Globals.red_flag_holder.getName().equals(p.getName()) || Globals.blue_flag_holder.getName().equals(p.getName())) {
      if(e.getItemDrop().getItemStack().getType() == Material.RED_BANNER ||
        e.getItemDrop().getItemStack().getType() == Material.BLUE_BANNER) {
          e.setCancelled(true);
      }
    }
  }
}
