package alarmsystem;

public class SensorFactory {

    public SensorFactory(){
    }

    public Sensor getInstance(String sensorType, String location){
            if(sensorType.equals("fire")){
                return new FireSensor(location);
            }else if(sensorType.equals("smoke")) {
                return new SmokeSensor(location);
            }
            return null;
    }
}
