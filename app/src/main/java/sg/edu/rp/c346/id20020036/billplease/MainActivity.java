package sg.edu.rp.c346.id20020036.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tvAmount;
    EditText etAmount;
    TextView tvPax;
    EditText etPax;
    ToggleButton tBtnSVS;
    ToggleButton tBtnGST;
    TextView tvDiscount;
    EditText etDiscount;
    RadioGroup rgPayBy;
    Button btnSplit;
    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAmount = findViewById(R.id.TextViewAmount);
        etAmount = findViewById(R.id.editTextNumberDecimal);
        tvPax = findViewById(R.id.textViewPax);
        etPax = findViewById(R.id.editTextNumber);
        tBtnSVS = findViewById(R.id.toggleButtonSVS);
        tBtnGST = findViewById(R.id.toggleButtonGST);
        tvDiscount = findViewById(R.id.textViewDiscount);
        etDiscount = findViewById(R.id.editTextDiscount);
        rgPayBy = findViewById(R.id.RadioGroupPayBy);
        btnSplit = findViewById(R.id.buttonSplit);
        btnReset = findViewById(R.id.buttonReset);

        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = etAmount.

                double total = (etAmount - ((etAmount / 100) * etDiscount));
                double eachPays = (total / etPax)
            }
        });
    }
}