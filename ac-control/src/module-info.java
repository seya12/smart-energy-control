import swt.ac.control.*;
import swt.ac.control.impl.*;

module swt.ac.control {
  exports swt.ac.control;
  provides AirConditionApiProvider with AirConditionApiProviderImpl;
}