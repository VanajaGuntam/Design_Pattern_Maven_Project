package com.vanajag.maven.plan;
import java.io.*;  
import java.util.logging.Level;
import java.util.logging.Logger;     
abstract class Plan<P>
{  
         T[] genericObject = (T[]) new Object[INITIAL_ARRAY_LENGTH];
        Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
         protected double rate;  
         abstract void getRate();  
   
         public void calculateBill(int units){  
              logger.log(units*rate);  
          }  
}
class  DomesticPlan extends Plan{  
        
         public void getRate(){  
             rate=3.50;              
        }  
   }  
class  CommercialPlan extends Plan{  
     
    public void getRate(){   
        rate=7.50;  
   }   

class  InstitutionalPlan extends Plan{  
     
    public void getRate(){   
        rate=5.50;  
   }   

class GetPlanFactory{  
      
   
       public Plan getPlan(String planType){  
            if(planType == null){  
             return null;  
            }  
          if(planType.equalsIgnoreCase("DOMESTICPLAN")) {  
                 return new DomesticPlan();  
               }   
           else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){  
                return new CommercialPlan();  
            }   
          else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {  
                return new InstitutionalPlan();  
          }  
      return null;  
   }  
}
   class GenerateBill{  
    public static void main(String args[])throws IOException{  
      GetPlanFactory planFactory = new GetPlanFactory();  
        
      logger.log("Enter the name of plan for which the bill will be generated: ");  
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
      String planName=br.readLine();  
      logger.log("Enter the number of units for bill will be calculated: ");  
      int units=Integer.parseInt(br.readLine());  
  
      Plan p = planFactory.getPlan(planName);    
  
       logger.log("Bill amount for "+planName+" of  "+units+" units is: ");  
           p.getRate();  
           p.calculateBill(units);  
            }  
    }