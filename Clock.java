import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Clock implements Runnable
{
    public SteamPlant SP;

    public Clock()
    {
        SP.getSteamPlant();
    }

    public void run()
    {
        Random rand = new Random();
        while(true)
        {
            try
            {
                TimeUnit.SECONDS.sleep(5);
                SP.timeTick();
                double p = rand.nextDouble();
                p *= 2;
                p -= 1;
                SP.setCurrentPressure(p);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
