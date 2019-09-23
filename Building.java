import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Building implements Runnable
{
    public SteamPlant SP;
    public int size;
    public int thermostat;
    public int outsideTemp;

    public Building(int size, int thermostat, int outsideTemp)
    {
        SP = SteamPlant.getSteamPlant();
        this.size = size;
        this.thermostat = thermostat;
        this.outsideTemp = outsideTemp;
    }

    public void run()
    {
        Random rand = new Random();
        while(true)
        {
            try
            {
                TimeUnit.SECONDS.sleep(3);
                int heatDiff = thermostat - outsideTemp;
                heatDiff *= (size / 2400);
                if(heatDiff < 0)
                {
                    SP.consumeHeat(0);
                }
                else
                {
                    SP.consumeHeat(heatDiff);
                }
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
