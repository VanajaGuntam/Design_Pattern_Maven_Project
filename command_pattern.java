package com.vanaja.maven.command;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
interface Command 
{ 
    public void execute(); 
} 
class Light 
{ 
    public void on() 
    { 
        logger.log("Light is on"); 
    } 
    public void off() 
    { 
       logger.log("Light is off"); 
    } 
} 
class LightOnCommand implements Command 
{ 
    Light light; 
    public LightOnCommand(Light light) 
    { 
       this.light = light; 
    } 
    public void execute() 
    { 
       light.on(); 
    } 
} 
class LightOffCommand implements Command 
{ 
    Light light; 
    public LightOffCommand(Light light) 
    { 
        this.light = light; 
    } 
    public void execute() 
    { 
         light.off(); 
    } 
} 
class Stereo 
{ 
    public void on() 
    { 
        logger.log("Stereo is on"); 
    } 
    public void off() 
    { 
        logger.log("Stereo is off"); 
    } 
    public void setCD() 
    { 
        logger.log("Stereo is set " + 
                           "for CD input"); 
    } 
    public void setDVD() 
    { 
        logger.log("Stereo is set"+ 
                         " for DVD input"); 
    } 
    public void setRadio() 
    { 
        logger.log("Stereo is set" + 
                           " for Radio"); 
    } 
    public void setVolume(int volume) 
    { 
       logger.log("Stereo volume set"
                          + " to " + volume); 
    } 
} 
class StereoOffCommand implements Command 
{ 
    Stereo stereo; 
    public StereoOffCommand(Stereo stereo) 
    { 
        this.stereo = stereo; 
    } 
    public void execute() 
    { 
       stereo.off(); 
    } 
} 
class StereoOnWithCDCommand implements Command 
{ 
     Stereo stereo; 
     public StereoOnWithCDCommand(Stereo stereo) 
     { 
         this.stereo = stereo; 
     } 
     public void execute() 
     { 
         stereo.on(); 
         stereo.setCD(); 
         stereo.setVolume(11); 
     } 
} 
class SimpleRemoteControl 
{ 
    Command slot;
  
    public SimpleRemoteControl() 
    { 
    } 
  
    public void setCommand(Command command) 
    { 
        slot = command; 
    } 
  
    public void buttonWasPressed() 
    { 
        slot.execute(); 
    } 
} 
  

class RemoteControlTest 
{ 
    public static void main(String[] args) 
    { 
        Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
        SimpleRemoteControl remote = new SimpleRemoteControl(); 
        Light light = new Light(); 
        Stereo stereo = new Stereo(); 
        remote.setCommand(new LightOnCommand(light)); 
        remote.buttonWasPressed(); 
        remote.setCommand(new StereoOnWithCDCommand(stereo)); 
        remote.buttonWasPressed(); 
        remote.setCommand(new StereoOffCommand(stereo)); 
        remote.buttonWasPressed(); 
     } 
  }