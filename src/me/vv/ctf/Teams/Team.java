package me.vv.ctf.Teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import java.util.ArrayList;



public class Team {
	
	public static Player red_flag_holder = null;	
	public static Player blue_flag_holder = null; 
	public static ArrayList<Player> blue_team = new ArrayList<Player>();
	public static ArrayList<Player> red_team = new ArrayList<Player>();
	
	public static boolean AssignTeam(String team, Player player) {
		
		if(team.equals("blue")) {
			if(blue_team.contains(player)) {

				for(int i = 0; i < blue_team.size(); i++) {
					
					Bukkit.broadcastMessage(ChatColor.BLUE + blue_team.get(i).getName());

				}
				for(int k = 0; k < red_team.size(); k++) {
					
					Bukkit.broadcastMessage(ChatColor.RED + red_team.get(k).getName());

				}

				return true;
			}
				red_team.remove(player);
				blue_team.add(player);

				for(int i = 0; i < blue_team.size(); i++) {
					
					Bukkit.broadcastMessage(ChatColor.BLUE + blue_team.get(i).getName());

				}
				for(int k = 0; k < red_team.size(); k++) {
					
					Bukkit.broadcastMessage(ChatColor.RED + red_team.get(k).getName());

				}
		
				return true;
		}
		else if(team.equals("red")) {
			if(red_team.contains(player)) {

				for(int i = 0; i < blue_team.size(); i++) {
					
					Bukkit.broadcastMessage(ChatColor.BLUE + blue_team.get(i).getName());

				}
				for(int k = 0; k < red_team.size(); k++) {
					
					Bukkit.broadcastMessage(ChatColor.RED + red_team.get(k).getName());

				}

	
				return true;
			}
			
				blue_team.remove(player);
				red_team.add(player);

				for(int i = 0; i < blue_team.size(); i++) {
					
					Bukkit.broadcastMessage(ChatColor.BLUE + blue_team.get(i).getName());

				}
				for(int k = 0; k < red_team.size(); k++) {
					
					Bukkit.broadcastMessage(ChatColor.RED + red_team.get(k).getName());

				}
				return true;
		}

		for(int i = 0; i < blue_team.size(); i++) {
			
			Bukkit.broadcastMessage(ChatColor.BLUE + blue_team.get(i).getName());

		}
		for(int k = 0; k < red_team.size(); k++) {
			
			Bukkit.broadcastMessage(ChatColor.RED + red_team.get(k).getName());

		}
		
		return false;
	} 
			
}





