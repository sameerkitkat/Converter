package calculator.sameer.com.mycalc;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class Converter {
        private double valueTwo;
        private double convertedValue;

        public double createConversion(String sourceValue, String targetValue, double valueOne){
        DecimalFormat decimalformat = new DecimalFormat("#0.#####");
        String key = sourceValue +" "+targetValue;
        Map<String,Double> map = new HashMap();

        /* MILIMETERS TO OTHER UNITS CONVERSION */
        map.put("milimeters centimeters",0.1);   map.put("milimeters meters",0.001);
        map.put("milimeters inches",0.0393701);  map.put("milimeters kilometers",0.000001);
        map.put("milimeters feet", 0.00328084);  map.put("milimeters yards", 0.00109361);
        map.put("milimeters miles",0.000000621); map.put("milimeters nautical miles",0.00000054);

        /* CENTIMETERS TO OTHER UNITS CONVERSION */
        map.put("centimeters milimeters",10.0);  map.put("centimeters meters",0.01);
        map.put("centimeters inches",0.393701);  map.put("centimeters kilometers",0.00001);
        map.put("centimeters feet",0.0328084);   map.put("centimeters yards",0.0109361);
        map.put("centimeters miles",0.00000621); map.put("centimeters nautical miles",0.0000054);

        /* METERS TO OTHER UNITS CONVERSION */
        map.put("meters milimeters",1000.0);     map.put("meters centimeters",100.0);
        map.put("meters inches",39.3701);        map.put("meters kilometers",0.001);
        map.put("meters feet",3.28084);          map.put("meters yards",1.09361);
        map.put("meters miles", 0.000621371);    map.put("meters nautical miles", 0.000539957);

        /* INCHES TO OTHER UNITS CONVERSION */
        map.put("inches milimeters",25.4);       map.put("inches centimeters",2.54);
        map.put("inches meters",0.0254);         map.put("inches kilometers",0.0000254);
        map.put("inches feet",0.0833333);        map.put("inches yards",0.0277778);
        map.put("inches miles", 0.00001578);     map.put("inches nautical miles", 0.00001371);

        /* KILOMETERS TO OTHER UNIT CONVERSION */
        map.put("kilometers milimeters",1000000.0); map.put("kilometers centimeters",100000.0);
        map.put("kilometers meters",1000.0);        map.put("kilometers inches",39370.1);
        map.put("kilometers feet",3280.84);         map.put("kilometers yards",1093.61);
        map.put("kilometers miles", 0.621371);      map.put("kilometers nautical miles",0.539957);

        /* FEET to OTHER UNIT CONVERSION */
        map.put("feet milimeters",304.8);     map.put("feet centimeters",30.48);
        map.put("feet meters",0.3048);        map.put("feet inches",12.0);
        map.put("feet kilometers",0.0003048); map.put("feet yards",0.333333);
        map.put("feet miles", 0.000189394);   map.put("feet nautical miles",0.000164579);

        /* YARDS TO OTHER UNIT CONVERSION */
        map.put("yards milimeters",914.4);     map.put("yards centimeters",91.44);
        map.put("yards meters",0.9144);        map.put("yards inches",36.0);
        map.put("yards kilometers",0.0009144); map.put("yards feet",3.0);
        map.put("yards miles", 0.000568182);   map.put("yards nautical miles",0.000493737);

        /* MILES TO OTHER UNIT CONVERSION */
        map.put("miles milimeters",1609340.0); map.put("miles centimeters",160934.0);
        map.put("miles meters",1609.34);       map.put("miles inches",63360.0);
        map.put("miles kilometers",1.60934);   map.put("miles feet",5280.0);
        map.put("miles yards", 1760.0);        map.put("miles nautical miles",0.868976);

        /* NAUTICAL MILES TO OTHER UNIT CONVERSION */
        map.put("nautical miles milimeters",1852000.0); map.put("nautical miles centimeters",185200.0);
        map.put("nautical miles meters",1852.0);        map.put("nautical miles inches",72913.4);
        map.put("nautical miles kilometers",1.852);     map.put("nautical miles feet",6076.12);
        map.put("nautical miles yards", 2025.37);       map.put("nautical miles miles",1.15078);

        /* SQUARE METERS TO OTHER UNIT CONVERSION */
        map.put("square meters square kilometers",0.000001); map.put("square meters square feet",10.7639);
        map.put("square meters square inches",1550.0);        map.put("square meters square yards",1.19599);
        map.put("square meters square miles",0.00000038610); map.put("square meters hectares",0.0001);
        map.put("square meters acres",0.000247105);

        /* SQUARE KILOMETERS TO OTHER UNIT CONVERSION */
        map.put("square kilometers square meters",1000000.0);        map.put("square kilometers square feet",10763910.41671);
        map.put("square kilometers square inches",1550003100.01);    map.put("square kilometers square yards",1195990.05);
        map.put("square kilometers square miles",0.386102);          map.put("square kilometers hectares",100.0);
        map.put("square kilometers acres",247.105);

        /* Calculate Converted Value and Return it to TextBox*/
        valueTwo=map.get(key) * valueOne;
        valueTwo=Double.parseDouble(decimalformat.format(valueTwo));
        return valueTwo;
    }
}
