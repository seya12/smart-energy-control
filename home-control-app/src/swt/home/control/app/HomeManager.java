package swt.home.control.app;

import swt.ac.control.*;
import swt.balcony.powerplant.*;
import swt.timer.beans.Timer;
import swt.timer.beans.*;

import java.util.*;

public class HomeManager {
  public static void main(String[] args) {
    Timer timer = ServiceLoader.load(TimerProvider.class)
      .findFirst()
      .orElseThrow()
      .createTimer(5, 10);

    InverterApi inverterApi = ServiceLoader.load(InverterApiProvider.class)
      .findFirst()
      .orElseThrow()
      .createInverterApi();

    AirConditionApi airConditionApi = ServiceLoader.load(AirConditionApiProvider.class)
      .findFirst()
      .orElseThrow()
      .createAirConditionApi();
  }
}
