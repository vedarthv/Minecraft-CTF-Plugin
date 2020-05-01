package me.vv.ctf;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.vv.ctf.Flags.FlagCarrierDead;
import me.vv.ctf.Flags.FlagCarrierNoDrop;
import me.vv.ctf.Flags.FlagCarrierNoPVP;
import me.vv.ctf.Flags.SetFlagSpawn;
import me.vv.ctf.Flags.flagbreak;
import me.vv.ctf.Flags.flagplace;
import me.vv.ctf.Teams.SetTeam;
import me.vv.ctf.Teams.PrintTeams;
import me.vv.ctf.Globals.Globals;



public class Main extends JavaPlugin implements Listener {
	
	@Override 
	public void onEnable() {
		Globals.initGlobals("Red", ChatColor.RED, "Blue", ChatColor.BLUE);
		getServer().getPluginManager().registerEvents(new flagbreak(), this);
		getServer().getPluginManager().registerEvents(new flagplace(), this);
		this.getCommand("setteam").setExecutor(new SetTeam());
		this.getCommand("teams").setExecutor(new PrintTeams());
		this.getCommand("setflagspawn").setExecutor(new SetFlagSpawn());
		getServer().getPluginManager().registerEvents(new FlagCarrierNoPVP(), this);
		getServer().getPluginManager().registerEvents(new FlagCarrierNoDrop(), this);
		getServer().getPluginManager().registerEvents(new FlagCarrierDead(), this);
	
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Bye");
	}
	
}

