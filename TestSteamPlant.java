import java.util.Scanner;

public class TestSteamPlant {
    public static void main(String args[]) {
         Scanner in = new Scanner(System.in);
         System.out.print("Enter the building size, thermostat setting, and outside temperature for Building 1: ");
         int size1 = in.nextInt();
         int thermostat1 = in.nextInt();
         int outsideTemperature1 = in.nextInt();
         
         System.out.print("Enter the building size, thermostat setting, and outside temperature for Building 2: ");
         int size2 = in.nextInt();
         int thermostat2 = in.nextInt();
         int outsideTemperature2 = in.nextInt();

         System.out.print("Enter the building size, thermostat setting, and outside temperature for Building 2: ");
         int size3 = in.nextInt();
         int thermostat3 = in.nextInt();
         int outsideTemperature3 = in.nextInt();


        Clock myClock = new Clock ();
        Thread t1 = new Thread(myClock);
        t1.start();

        Building myBuilding1 = new Building(size1, thermostat1, outsideTemperature1);
        Thread t2 = new Thread(myBuilding1);
        t2.start();

        Building myBuilding2 = new Building(size2, thermostat2, outsideTemperature2);
        Thread t3 = new Thread(myBuilding2);
        t3.start();

        Building myBuilding3 = new Building(size3, thermostat3, outsideTemperature3);
        Thread t4 = new Thread(myBuilding3);
        t4.start();

    }    
}
