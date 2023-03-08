import swt.balcony.powerplant.*;
import swt.balcony.powerplant.impl.*;

module swt.balcony.powerplant {
  exports swt.balcony.powerplant;
  provides InverterApiProvider with InverterApiProviderImpl;
}