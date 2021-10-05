package alarmsystem;

public class SmokeSensor implements Sensor {
  private double  batteryPercentage;
  private final String sensorLocation;
  private final String sensorType;
  private final Boolean isTriggered;

  public SmokeSensor(String sensorLocation){
    batteryPercentage = 100.00;
    this.sensorLocation = sensorLocation;
    sensorType = "Smoke Sensor";
    isTriggered = false;

  }

  @Override
  public boolean isTriggered() {
    if (batteryPercentage < 20){
      return true;
    }
    batteryPercentage -= 20;

    //Returns true if the random number used for probability is under the constraint
    Probability fireprob = new Probability();
    if( fireprob.getProbability(10)){
      return true;
    }

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
