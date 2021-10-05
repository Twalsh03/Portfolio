package alarmsystem;

public class FireSensor implements Sensor {
  private double  batteryPercentage;
  private final String sensorLocation;
  private final String sensorType;
  private final Boolean isTriggered;

  public FireSensor(String sensorLocation){
    batteryPercentage = 100.00;
    this.sensorLocation = sensorLocation;
    sensorType = "Fire Sensor";
    isTriggered = false;

  }

  @Override
  public boolean isTriggered() {
    if (batteryPercentage < 20){
      return true;
    }

    //reduce battery when polled
    batteryPercentage -= 10;

    //Returns true if the random number used for probability is under the constraint
    Probability fireprob = new Probability();
    if (fireprob.getProbability(5))
      return true;

    return isTriggered;
  }
  @Override
  public String getLocation() {
    return sensorLocation;
  }

  @Override
  public String getSensorType() {

    return sensorType;
  }

  @Override
  public double getBatteryPercentage() {

    return batteryPercentage;
  }
}
