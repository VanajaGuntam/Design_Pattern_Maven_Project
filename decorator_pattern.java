package com.vanaja.maven.pizza;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
abstract class Pizza 
{ 
    String description = "Unkknown Pizza"; 
  
    public String getDescription() 
    { 
        return description; 
    } 
  
    public abstract int getCost(); 
} 
abstract class ToppingsDecorator extends Pizza 
{ 
    public abstract String getDescription(); 
} 
class PeppyPaneer extends Pizza 
{ 
    public PeppyPaneer() { description = "PeppyPaneer"; } 
    public int getCost() {  return 100; } 
} 
class FarmHouse extends Pizza 
{ 
    public FarmHouse() {  description = "FarmHouse"; } 
    public int getCost() { return 200; } 
} 
class Margherita extends Pizza 
{ 
    public Margherita()  { description = "Margherita"; } 
    public int getCost() { return 100;  } 
} 
class ChickenFiesta extends Pizza 
{ 
    public ChickenFiesta() { description = "ChickenFiesta";} 
    public int getCost() { return 200; } 
} 
class SimplePizza extends Pizza 
{ 
public SimplePizza() { description = "SimplePizza"; } 
public int getCost() {  return 50;  } 
} 
class FreshTomato extends ToppingsDecorator 
{ 
    Pizza pizza; 
  
    public FreshTomato(Pizza pizza) { this.pizza = pizza; } 
    public String getDescription() { 
        return pizza.getDescription() + ", Fresh Tomato "; 
    } 
    public int getCost() { return 40 + pizza.getCost(); } 
} 
class Barbeque extends ToppingsDecorator 
{ 
    Pizza pizza; 
    public Barbeque(Pizza pizza) {  this.pizza = pizza;  } 
    public String getDescription() { 
        return pizza.getDescription() + ", Barbeque "; 
    } 
    public int getCost() { return 90 + pizza.getCost(); } 
} 
class Paneer extends ToppingsDecorator 
{ 
    Pizza pizza; 
    public Paneer(Pizza pizza)  {  this.pizza = pizza; } 
    public String getDescription() { 
        return pizza.getDescription() + ", Paneer "; 
    } 
    public int getCost()  {  return 70 + pizza.getCost(); } 
} 
 
class PizzaStore 
{ 
    public static void main(String args[]) 
    { 
        Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);  
        Pizza pizza = new Margherita(); 
        logger.log( pizza.getDescription() + " Cost :" + pizza.getCost()); 
        Pizza pizza2 = new FarmHouse(); 
        pizza2 = new FreshTomato(pizza2); 
        pizza2 = new Paneer(pizza2); 
  
        logger.log( pizza2.getDescription() + 
                         " Cost :" + pizza2.getCost()); 
        Pizza pizza3 = new Barbeque(null);    //no specific pizza 
        logger.log( pizza3.getDescription() + "  Cost :" + pizza3.getCost()); 
   } 
} 