package alarmsystem;

import java.util.ArrayList;
import java.util.List;


public class ControlUnit {

  //create new sensors to be polled
      SensorFactory sensorFactory = new SensorFactory();
       Sensor FireHall = sensorFactory.getInstance("fire", "hall");
       Sensor SmokeHall =  sensorFactory.getInstance("smoke", "hall");
       Sensor fireKitchen = sensorFactory.getInstance("fire", "kitchen");
       Sensor smokeKitchen = sensorFactory.getInstance("smoke", "kitchen");
       Sensor FireOffice =  sensorFactory.getInstance("fire", "office");
       Sensor SmokeOffice = sensorFactory.getInstance("smoke", "office");

  public void pollSensors() {


    List<Sensor> sensors = new ArrayList<>();
          sensors.add(FireHall);
          sensors.add(SmokeHall);
          sensors.add(fireKitchen);
         sensors.add(smokeKitchen);
            sensors.add(FireOffice);
      sensors.add(SmokeOffice);

    for (Sensor sensor : sensors) {
          System.out.println("Location: " + sensor.getLocation() + "\n" +
                             "Type: " + sensor.getSensorType()+ "\n" +
                              "Battery % : " + sensor.getBatteryPercentage() + "\n"+
                              "Triggered: "+ sensor.isTriggered() + "\n" );
    }
  }
}
