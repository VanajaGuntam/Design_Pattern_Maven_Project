package com.vanaja.maven.chain;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
interface Chain 
{ 
    public abstract void setNext(Chain nextInChain); 
    public abstract void process(Number request); 
} 
  
class Number 
{ 
    private int number; 
  
    public Number(int number) 
    { 
        this.number = number; 
    } 
  
    public int getNumber() 
    { 
        return number; 
    } 
  
} 
  
class NegativeProcessor implements Chain 
{ 
    private Chain nextInChain; 
  
    public void setNext(Chain c) 
    { 
        nextInChain = c; 
    } 
  
    public void process(Number request) 
    { 
        if (request.getNumber() < 0) 
        { 
            logger.log("NegativeProcessor : " + request.getNumber()); 
        } 
        else
        { 
            nextInChain.process(request); 
        } 
    } 
} 
  
class ZeroProcessor implements Chain 
{ 
      
    private Chain nextInChain; 
  
    public void setNext(Chain c) 
    { 
        nextInChain = c; 
    } 
  
    public void process(Number request) 
    { 
        if (request.getNumber() == 0) 
        { 
            logger.log("ZeroProcessor : " + request.getNumber()); 
        } 
        else
        { 
            nextInChain.process(request); 
        } 
    } 
} 
  
class PositiveProcessor implements Chain 
{ 
  
    private Chain nextInChain; 
  
    public void setNext(Chain c) 
    { 
        nextInChain = c; 
    } 
  
    public void process(Number request) 
    { 
        if (request.getNumber() > 0) 
        { 
            logger.log("PositiveProcessor : " + request.getNumber()); 
        } 
        else
        { 
            nextInChain.process(request); 
        } 
    } 
} 
  
class TestChain 
{ 
    public static void main(String[] args) 
{
        Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
        //configure Chain of Responsibility 

        Chain c1 = new NegativeProcessor(); 
        Chain c2 = new ZeroProcessor(); 
        Chain c3 = new PositiveProcessor(); 
        c1.setNext(c2); 
        c2.setNext(c3); 
        c1.process(new Number(90)); 
        c1.process(new Number(-50)); 
        c1.process(new Number(0)); 
        c1.process(new Number(91)); 
    } 
} 