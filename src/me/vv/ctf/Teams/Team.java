package me.vv.ctf.Teams;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

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
		this.flagSpawn = null;
		this.flagScore = null;
	}

	public String getName() {
		return this.name;
	}

	public ChatColor getColour() {
		return this.colour;
	}

	public Location getFlagSpawnLocation() {
		return flagSpawn;
	}

	public Location getFlagScoreLocation() {
		return flagScore;
	}

	public void setFlagSpawnLocation(Location loc) {
		  double a = Math.floor(loc.getX());
	      double b = Math.floor(loc.getY());
	      double c = Math.floor(loc.getZ());
		  this.flagSpawn = new Location(loc.getWorld(), a, b, c);
	      double x = Math.floor(loc.getX()-1);
	      double y = Math.floor(loc.getY()-1);
	      double z = Math.floor(loc.getZ()-1);
	      this.flagScore = new Location(loc.getWorld(), x, y, z);
	}
	
	public void addMember(Player player) {
		if(!(this.members.contains(player))) {
			this.members.add(player);
		}		
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





