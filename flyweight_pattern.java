package com.vanaja.maven.player;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.Random; 
import java.util.HashMap; 
interface Player 
{ 
    public void assignWeapon(String weapon); 
    public void mission(); 
} 
class Terrorist implements Player 
{
    private final String TASK; 
    private String weapon; 
  
    public Terrorist() 
    { 
        TASK = "PLANT A BOMB"; 
    } 
    public void assignWeapon(String weapon) 
    { 
        this.weapon = weapon; 
    } 
    public void mission() 
    { 
        logger.log("Terrorist with weapon "
                           + weapon + "|" + " Task is " + TASK); 
    } 
} 
class CounterTerrorist implements Player 
{
    private final String TASK;  
    private String weapon; 
  
    public CounterTerrorist() 
    { 
        TASK = "DIFFUSE BOMB"; 
    } 
    public void assignWeapon(String weapon) 
    { 
        this.weapon = weapon; 
    } 
    public void mission() 
    { 
        logger.log("Counter Terrorist with weapon "+ weapon + "|" + " Task is " + TASK); 
    } 
} 
class PlayerFactory 
{
    private static HashMap <String, Player> hm = new HashMap<String, Player>(); 
  
    public static Player getPlayer(String type) 
    { 
        Player p = null; 
         if (hm.containsKey(type)) 
                p = hm.get(type); 
        else
        { 
            switch(type) 
            { 
            case "Terrorist": 
                logger.log("Terrorist Created"); 
                p = new Terrorist(); 
                break; 
            case "CounterTerrorist": 
                logger.log("Counter Terrorist Created"); 
                p = new CounterTerrorist(); 
                break; 
            default : 
               logger.log("Unreachable code!"); 
            } 
            hm.put(type, p); 
        } 
        return p; 
    } 
}  
public class CounterStrike 
{ 
    private static String[] playerType = {"Terrorist", "CounterTerrorist"}; 
    private static String[] weapons = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"}; 
   
    public static void main(String args[]) 
    { 
Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
        for (int i = 0; i < 10; i++) 
        { 
            Player p = PlayerFactory.getPlayer(getRandPlayerType()); 
            p.assignWeapon(getRandWeapon()); 
            p.mission(); 
        } 
    } 
    public static String getRandPlayerType() 
    { 
        Random r = new Random(); 
        int randInt = r.nextInt(playerType.length); 
        return playerType[randInt]; 
    } 
    public static String getRandWeapon() 
    { 
        Random r = new Random(); 
        int randInt = r.nextInt(weapons.length); 
        return weapons[randInt]; 
    } 
}