package me.vv.ctf.Respawn;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import me.vv.ctf.Main;
import me.vv.ctf.Globals.Globals;
import me.vv.ctf.Teams.Team;


public class OnRespawnEvent implements Listener{
	
	Main plugin;
	
	public OnRespawnEvent(Main plugin) {
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onDeath (PlayerDeathEvent e) {
		Team team;
		if(Globals.respawn_time > 0) {
			final Player p = (Player) e.getEntity();
			if(Globals.blue_team.isPlayerInTeam(p)) {
				team = Globals.blue_team;
			}
			else {
				team = Globals.red_team;
			}
			
		    for(PotionEffect effect : p.getActivePotionEffects()){        
	           p.removePotionEffect(effect.getType());
	        }
			p.setGameMode(GameMode.SPECTATOR);
			p.setFlySpeed(0f);
			p.setHealth(20);
			p.setFoodLevel(20);

		    new BukkitRunnable(){
				@Override
				public void run() {						
					p.setGameMode(GameMode.SURVIVAL);
					p.setFlySpeed(0.1f);
					p.teleport(team.getFlagSpawnLocation());
					System.out.println("Fire ticks: " + p.getFireTicks());
					p.setFireTicks(0);
	
				}
				
			   }.runTaskLater(plugin, Globals.respawn_time * 20);
			   
			   new BukkitRunnable(){
					
					@Override
					public void run() {						
						p.setFireTicks(0);
						p.setHealth(20);
						p.setFoodLevel(20);
						System.out.println("Fire ticks2: " + p.getFireTicks());
					}
					
				   }.runTaskLater(plugin, (Globals.respawn_time + 1) * 20);
		
		}
		   
	}	

}