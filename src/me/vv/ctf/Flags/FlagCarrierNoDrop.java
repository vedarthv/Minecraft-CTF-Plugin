package me.vv.ctf.Flags;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import me.vv.ctf.Globals.Globals;



public class FlagCarrierNoDrop implements Listener {
	
	@EventHandler 
	public void onPlayerDropItem(PlayerDropItemEvent e) {
		Player p = e.getPlayer();

    if(Globals.safeGetName(Globals.red_flag_holder).equals(p.getName()) || Globals.safeGetName(Globals.blue_flag_holder).equals(p.getName())) {
      if(e.getItemDrop().getItemStack().getType() == Material.RED_BANNER || e.getItemDrop().getItemStack().getType() == Material.BLUE_BANNER) {
          e.setCancelled(true);
      }
    }
  }
}
