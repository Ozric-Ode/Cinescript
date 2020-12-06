package exceptionhandle;

import java.util.*;
import java.io.*;
import datatypes.Coredeclare;

public class CheckCompatibility extends Exception {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  String var1 = "";
  String var2 = "";
  double v1 = 0.0;
  double v2 = 0.0;
  int v3 = 0;
  int v4 = 0;

  CheckCompatibility(double v1, double v2) {
    this.v1 = v1;
    this.v2 = v2;
  }

  CheckCompatibility(int v3, int v4) {
    this.v3 = v3;
    this.v4 = v4;
  }

  CheckCompatibility(String var1, String var2) {
    this.var1 = var1;
    this.var2 = var2;
  }

  public String toString() {

    if (var1 != "")
      return ("Both " + var1 + " and " + var2 + " are not compatible together");
    else if (v1 != 0.0)
      return ("Both " + v1 + " and " + v2 + " are not compatible together");
    else
      return ("Both " + v3 + " and " + v4 + " are not compatible together");

  }

  // checkscope(String exceptionText)
  // {
  // // super(exceptionText);
  // }

}
// lIKE this, rest of the exception classes will be created in different java
// files.
// then there will be a parent final exception class in which we will make
// various functions which will throw various exceptions
// then from various files we will call functions from that parent exception
// classes.
// THATS IT!!!!
