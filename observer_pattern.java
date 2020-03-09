package com.vanaja.maven.observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.*;
interface Subject 
{ 
    public void registerObserver(Observer o); 
    public void unregisterObserver(Observer o); 
    public void notifyObservers(); 
} 
  
class CricketData implements Subject 
{ 
    int runs; 
    int wickets; 
    float overs; 
    ArrayList<Observer> observerList; 
  
    public CricketData() { 
        observerList = new ArrayList<Observer>(); 
    } 
  
    @Override
    public void registerObserver(Observer o) { 
        observerList.add(o); 
    } 
  
    @Override
    public void unregisterObserver(Observer o) { 
        observerList.remove(observerList.indexOf(o)); 
    } 
  
    @Override
    public void notifyObservers() 
    { 
        for (Iterator<Observer> it = 
              observerList.iterator(); it.hasNext();) 
        { 
            Observer o = it.next(); 
            o.update(runs,wickets,overs); 
        } 
    } 
    private int getLatestRuns() 
    { 
        return 90; 
    } 
    private int getLatestWickets() 
    { 
        return 2; 
    } 
    private float getLatestOvers() 
    { 
        return (float)10.2; 
    }
    public void dataChanged() 
    { 
        runs = getLatestRuns(); 
        wickets = getLatestWickets(); 
        overs = getLatestOvers(); 
  
        notifyObservers(); 
    } 
} 
interface Observer 
{ 
    public void update(int runs, int wickets,float overs); 
} 
  
class AverageScoreDisplay implements Observer 
{ 
    private float runRate; 
    private int predictedScore; 
  
    public void update(int runs, int wickets, float overs) 
    { 
        this.runRate =(float)runs/overs; 
        this.predictedScore = (int)(this.runRate * 50); 
        display(); 
    } 
  
    public void display() 
    { 
        logger.log("\nAverage Score Display: \n"+ "Run Rate: " + runRate +"\nPredictedScore: " +predictedScore); 
    } 
} 
  
class CurrentScoreDisplay implements Observer 
{ 
    private int runs, wickets; 
    private float overs; 
  
    public void update(int runs, int wickets, 
                       float overs) 
    { 
        this.runs = runs; 
        this.wickets = wickets; 
        this.overs = overs; 
        display(); 
    } 
  
    public void display() 
    { 
        logger.log("\nCurrent Score Display:\n"+ "Runs: " + runs +"\nWickets:" + wickets + "\nOvers: " + overs ); 
    } 
} 
 
class Main 
{ 
    public static void main(String args[]) 
    { 
   
Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
        AverageScoreDisplay averageScoreDisplay =new AverageScoreDisplay(); 
        CurrentScoreDisplay currentScoreDisplay=new CurrentScoreDisplay(); 
        CricketData cricketData = new CricketData(); 
        cricketData.registerObserver(averageScoreDisplay); 
        cricketData.registerObserver(currentScoreDisplay);
        cricketData.dataChanged(); 
        cricketData.unregisterObserver(averageScoreDisplay); 
        cricketData.dataChanged(); 
    } 
} 