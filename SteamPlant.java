public class SteamPlant {
	private static SteamPlant uniqueInstance;
 
	private static final double MAX_PRESSURE = 12;
    private static final double MIN_PRESSURE = 1;
    private static final int INITIAL_HEAT_AVAILABLE = 1000;
    private static final double INITIAL_PRESSURE = 7.0;
    private double currentPressure;
    private int heatAvailable;
    
    private SteamPlant() {
        currentPressure = INITIAL_PRESSURE;
        heatAvailable = INITIAL_HEAT_AVAILABLE;
    }
 
	public static SteamPlant getSteamPlant() { //USE double checked locking.
		if (uniqueInstance == null) {
			uniqueInstance = new SteamPlant();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
	public synchronized int consumeHeat(int h) {
		int temp;
        if (heatAvailable < h){
            temp = heatAvailable;
            heatAvailable = 0;
        }
        else{ 
            temp = h;
            heatAvailable -= h;
        }
        System.out.println("consumeHeat(int " + h + "x 10^3 BTUs): Heat Available = " + heatAvailable +
            ", Current Pressure = " + currentPressure + ", Heat Consumed = " + temp);
        return temp;
	}

    public void setCurrentPressure(double p){// Just the two conditionals?
        if (p > MAX_PRESSURE) currentPressure = MAX_PRESSURE;
        else if (p < MIN_PRESSURE) currentPressure = MIN_PRESSURE;
        else currentPressure = p;
    }

    public double changeCurrentPressure(double p){
        setCurrentPressure(currentPressure + p);
        return currentPressure;
    }

    public synchronized void timeTick(){
        heatAvailable = ((currentPressure - 2) * 500 > 0) ?  
            (int)(currentPressure - 2) * 500 : 0;
        System.out.println("timeTick(): Heat Available = " + heatAvailable +
            ", Current Pressure = " + currentPressure);
    }

}
