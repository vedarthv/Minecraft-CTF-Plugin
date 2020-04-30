package me.vv.ctf.Globals;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import me.vv.ctf.Teams.Team;


public class Globals {
  public static Team red_team;
  public static Team blue_team;
  public static ArrayList<Team> teams;
  public static Player red_flag_holder;		// Holds the RED flag
  public static Player blue_flag_holder;		// Holds the BLUE flag

  public static void initGlobals(String redName, ChatColor redColour, String blueName, ChatColor blueColour) {
    red_team = new Team(redName, redColour);
    blue_team = new Team(blueName, blueColour);
    teams = new ArrayList<Team>();
    teams.add(red_team);
    teams.add(blue_team);
    red_flag_holder = null;
    blue_flag_holder = null;
  }

}