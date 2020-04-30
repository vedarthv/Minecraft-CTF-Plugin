package me.vv.ctf;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import me.vv.ctf.FlagBreak.flagbreak;
import me.vv.ctf.FlagBreak.flagplace;
import me.vv.ctf.Teams.SetTeam;



public class Main extends JavaPlugin implements Listener {
	
	@Override 
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new flagbreak(), this);
		getServer().getPluginManager().registerEvents(new flagplace(), this);
		this.getCommand("setteam").setExecutor(new SetTeam());
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Bye");
	}
	
	
	
	

}

