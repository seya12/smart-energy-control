package swt.home.control.app;

import swt.ac.control.*;
import swt.balcony.powerplant.*;
import swt.timer.beans.Timer;
import swt.timer.beans.*;

import java.util.*;

public class HomeManager {

  private Timer timer;
  private InverterApi inverterApi;
  private AirConditionApi airConditionApi;
  private List<Double> currentTemperatures;
  private List<Double> producedPower;

  public HomeManager(){
     timer = ServiceLoader.load(TimerProvider.class)
            .findFirst()
            .orElseThrow()
            .createTimer(1000, 1000);

     inverterApi = ServiceLoader.load(InverterApiProvider.class)
            .findFirst()
            .orElseThrow()
            .createInverterApi();

     airConditionApi = ServiceLoader.load(AirConditionApiProvider.class)
            .findFirst()
            .orElseThrow()
            .createAirConditionApi();

    currentTemperatures = new CustomArrayList<>(10);
    producedPower = new CustomArrayList<>(10);
  }

  public void start(){
    timer.addTimerListener(this::performLogic);
    timer.start();
  }

  private void performLogic(TimerEvent timerEvent) {
    currentTemperatures.add(airConditionApi.getRoomTemperature());
    producedPower.add(inverterApi.getActualCurrent());

    var avgTemp = currentTemperatures.stream().mapToDouble(d -> d).average().orElse(0.0);
    var avgPower = producedPower.stream().mapToDouble(d -> d).average().orElse(0.0);
    boolean turnAirConditionOff = avgTemp < 22;
    boolean tooWarm = avgTemp > 24;
    boolean enoughPower = avgPower > 0.1;

    if(turnAirConditionOff){
      airConditionApi.turnOff();
    } else if (tooWarm && enoughPower) {
      airConditionApi.turnOn();
    }
  }

  public static void main(String[] args) {
    HomeManager manager = new HomeManager();
    manager.start();
  }
}
