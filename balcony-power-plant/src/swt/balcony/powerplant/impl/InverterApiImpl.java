package swt.balcony.powerplant.impl;

import swt.balcony.powerplant.*;

public class InverterApiImpl implements InverterApi {

  @Override
  public double getActualCurrent() {
    return Math.random() * 0.8;
  }

  public static void main(String[] args) {
    System.out.println(Math.random() * 0.8);
  }
}
