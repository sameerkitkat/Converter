package calculator.sameer.com.mycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class Convert_Area_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Spinner areasourceSpinner,areatargetSpinner;
    private EditText areavalueOneTextbox,areavalueTwoTextbox;
    private double convertedValue;
    private double areavalueOne,areavalueTwo;
    private Button areaconvertButton;
    public String sourceValue,targetValue;
    public static final String MILIMETER ="milimeters";
    public static final String CENTIMETER ="centimeters";
    public static final String INCH ="inches";
    public static final String METER ="meters";
    public static final String KILOMETER ="kilometers";
    public static final String FOOT ="feet";
    public static final String YARD ="yards";
    public static final String MILE ="miles";
    public static final String NAUTICALMILES ="nautical miles";
    public String[] units ={MILIMETER,CENTIMETER,INCH,METER,KILOMETER,FOOT,YARD,MILE,NAUTICALMILES};
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_length);
        areasourceSpinner = findViewById(R.id.Area_Value_One_Spinner);
        areatargetSpinner = findViewById(R.id.Area_Value_Two_Spinner);
        areaconvertButton = findViewById(R.id.Area_ConvertButton);
        areavalueOneTextbox = findViewById(R.id.Area_Value_One_Text_Box);
        areavalueTwoTextbox = findViewById(R.id.Area_Value_Two_Text_Box);
        areasourceSpinner.setOnItemSelectedListener(this);
        areatargetSpinner.setOnItemSelectedListener(this);
        selectSpinner();
    }

    /* Identify Spinner and Set Values to each Spinner */
    public void selectSpinner(){
        ArrayAdapter<String> sourceadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,units);
        ArrayAdapter<String> targetadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,units);
        sourceadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        targetadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areasourceSpinner.setAdapter(sourceadapter);
        areatargetSpinner.setAdapter(targetadapter);
    }


    /* Call createConversion method from Converter class and set result to second text box */
    public void convertValues(String sourceValue,String targetValue){
        Converter conv = new Converter();
        if( !areavalueOneTextbox.getText().toString().equals("") && areavalueOneTextbox.getText().toString().length() > 0 ) {
            areavalueOne = Double.parseDouble(areavalueOneTextbox.getText().toString());
        }
        if (sourceValue.equals(targetValue)) {
            convertedValue = areavalueOne;
            setResult(convertedValue);
        }
        else{
            convertedValue=conv.createConversion(sourceValue,targetValue,areavalueOne);
            setResult(convertedValue);
        }
    }

    /* Set result method to display the result */
    public void setResult(final Double convertedValue){
        areaconvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                areavalueTwoTextbox.setText(String.valueOf(convertedValue));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        sourceValue = String.valueOf(areasourceSpinner.getSelectedItem());
        System.out.print(sourceValue);
        targetValue = String.valueOf(areatargetSpinner.getSelectedItem());
        System.out.print(targetValue);
        convertValues(sourceValue, targetValue);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
