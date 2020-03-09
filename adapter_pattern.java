package com.vanaja.maven.bird;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

interface Bird 
{  
    public void fly(); 
    public void makeSound(); 
} 
  
class Sparrow implements Bird 
{ 
    public void fly() 
    { 
        logger.log("Flying"); 
    } 
    public void makeSound() 
    { 
        logger.log("Chirp Chirp"); 
    } 
} 
  
interface ToyDuck 
{ 
  public void squeak(); 
} 
  
class PlasticToyDuck implements ToyDuck 
{ 
    public void squeak() 
    { 
       logger.log("Squeak"); 
    } 
} 
  
class BirdAdapter implements ToyDuck 
{  
    Bird bird; 
    public BirdAdapter(Bird bird) 
    { 
        this.bird = bird; 
    } 
  
    public void squeak() 
    {  
        bird.makeSound(); 
    } 
} 
  
class Main 
{ 
    public static void main(String args[]) 
    { 
        Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Sparrow sparrow = new Sparrow(); 
        ToyDuck toyDuck = new PlasticToyDuck(); 
  
        ToyDuck birdAdapter = new BirdAdapter(sparrow); 
  
        logger.log("Sparrow..."); 
        sparrow.fly(); 
        sparrow.makeSound(); 
  
        logger.log("ToyDuck..."); 
        toyDuck.squeak(); 
  
        
        logger.log("BirdAdapter..."); 
        birdAdapter.squeak(); 
    } 
} 