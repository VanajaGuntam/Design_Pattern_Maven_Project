package com.vanaja.maven.prototype;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap; 
import java.util.Map; 
  
  
abstract class Color implements Cloneable 
{ 
      
    protected String colorName; 
       
    abstract void addColor(); 
       
    public Object clone() 
    { 
        Object clone = null; 
        try 
        { 
            clone = super.clone(); 
        }  
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
    } 
} 
  
class blueColor extends Color 
{ 
    public blueColor()  
    { 
        this.colorName = "blue"; 
    } 
    void addColor()  
    { 
        logger.log("Blue color added"); 
    } 
      
} 
  
class blackColor extends Color{ 
   
    public blackColor() 
    { 
        this.colorName = "black"; 
    } 
    void addColor()  
    { 
        logger.log("Black color added"); 
    } 
} 
   
class ColorStore { 
   
    private static Map<String, Color> colorMap = new HashMap<String, Color>();  
       
    static 
    { 
        colorMap.put("blue", new blueColor()); 
        colorMap.put("black", new blackColor()); 
    } 
       
    public static Color getColor(String colorName) 
    { 
        return (Color) colorMap.get(colorName).clone(); 
    } 
} 
  
class Prototype 
{ 
    public static void main (String[] args) 
    { 
Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        ColorStore.getColor("blue").addColor(); 
        ColorStore.getColor("black").addColor(); 
        ColorStore.getColor("black").addColor(); 
        ColorStore.getColor("blue").addColor(); 
    } 
} 