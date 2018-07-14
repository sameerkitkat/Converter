package calculator.sameer.com.mycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class Convert_Area_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Spinner areasourceSpinner,areatargetSpinner;
    private EditText areavalueOneTextbox,areavalueTwoTextbox;
    private double areaconvertedValue;
    private double areavalueOne,areavalueTwo;
    private Button areaconvertButton;
    public String areasourceValue,areatargetValue;
    public static final String SQUAREINCH ="square inches";
    public static final String SQUAREMETER ="square meters";
    public static final String SQUAREKILOMETER ="square kilometers";
    public static final String SQUAREFOOT ="square feet";
    public static final String SQUAREYARD ="square yards";
    public static final String SQUAREMILE ="square miles";
    public static final String HECTARE = "hectares";
    public static final String ACRE = "acres";
    public String[] areaunits ={SQUAREINCH,SQUAREMETER,SQUAREKILOMETER,SQUAREFOOT,SQUAREYARD,SQUAREMILE,HECTARE,ACRE};
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_area);
        areasourceSpinner = findViewById(R.id.Area_Value_One_Spinner);
        areatargetSpinner = findViewById(R.id.Area_Value_Two_Spinner);
        areaconvertButton = findViewById(R.id.Area_ConvertButton);
        areavalueOneTextbox = findViewById(R.id.Area_Value_One_Text_Box);
        areavalueTwoTextbox = findViewById(R.id.Area_Value_Two_Text_Box);
        areasourceSpinner.setOnItemSelectedListener(this);
        areatargetSpinner.setOnItemSelectedListener(this);
        selectAreaSpinner();
    }

    /* Identify Spinner and Set Values to each Spinner */
    public void selectAreaSpinner(){
        ArrayAdapter<String> areasourceadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,areaunits);
        ArrayAdapter<String> areatargetadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,areaunits);
        areasourceadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areatargetadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areasourceSpinner.setAdapter(areasourceadapter);
        areatargetSpinner.setAdapter(areatargetadapter);
    }


    /* Call createConversion method from Converter class and set result to second text box */
    public void convertValues(String areasourceValue,String areatargetValue){
        Converter conv = new Converter();
        if( !areavalueOneTextbox.getText().toString().equals("") && areavalueOneTextbox.getText().toString().length() > 0 ) {
            areavalueOne = Double.parseDouble(areavalueOneTextbox.getText().toString());
        }
        if (areasourceValue.equals(areatargetValue)) {
            areaconvertedValue = areavalueOne;
            setResult(areaconvertedValue);
        }
        else{
            areaconvertedValue=conv.createConversion(areasourceValue,areatargetValue,areavalueOne);
            setResult(areaconvertedValue);
        }
    }

    /* Set result method to display the result */
    public void setResult(final Double areaconvertedValue){
        areaconvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                areavalueTwoTextbox.setText(String.valueOf(areaconvertedValue));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        areasourceValue = String.valueOf(areasourceSpinner.getSelectedItem());
        System.out.print(areasourceValue);
        areatargetValue = String.valueOf(areatargetSpinner.getSelectedItem());
        System.out.print(areatargetValue);
        convertValues(areasourceValue, areatargetValue);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
