package swt.ac.control.impl;

import swt.ac.control.*;

public class AirConditionApiImpl implements AirConditionApi {

  private boolean running = false;

  @Override
  public void turnOn() {
    this.running = true;
    System.out.println("Switched AC on");
  }

  @Override
  public void turnOff() {
    this.running = false;
    System.out.println("Switched AC off");
  }

  @Override
  public double getRoomTemperature() {
    return Math.random() * 11 + 19; //between 19.0 and 30.0
  }
}
