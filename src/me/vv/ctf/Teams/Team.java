package me.vv.ctf.Teams;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;



public class Team {
	String name;
	ChatColor colour;
	ArrayList<Player> members;
	Location flagSpawn;
	Location flagScore;

	public Team(String n, ChatColor c) {
		this.name = n;
		this.colour = c;
		this.members = new ArrayList<Player>();
		this.flag_holder = null;
		this.flagSpawn = getRespawnLocation();
		this.flagScore = getRespawnLocation();
	}

	public String getName() {
		return this.name;
	}

	public ChatColour getColour() {
		return this.colour;
	}

	public Location getFlagSpawnLocation() {
		return flagSpawn;
	}

	public Location getFlagScoreLocation() {
		return flagScore;
	}

	public void setFlagSpawnLocation(Location loc) {
		this.flagSpawn = loc;
		this.flagScore = new Location(loc.getWorld(), loc.getX()-1, loc.getY(), loc.getZ()-1);
	}
	
	public void addMember(Player player) {
		this.members.add(player);
	}

	public void removeMember(Player player) {
		this.members.remove(player);
	}

	public boolean isPlayerInTeam(Player player) {
		return this.members.contains(player);
	}
	
	public String stringOfMembers() {
		String retval = "";
		for(int i = 0; i < this.members.size(); i++) {
			retval += this.members.get(i).getName();
			if(i != this.members.size() -1) {
				retval += ", ";
			}
		}
		return retval;
	}		
}





