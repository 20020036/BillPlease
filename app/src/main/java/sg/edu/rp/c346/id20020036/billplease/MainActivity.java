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
    TextView tvTotal;
    TextView tvBill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAmount = findViewById(R.id.TextViewAmount);
        etAmount = findViewById(R.id.editTextAmount);
        tvPax = findViewById(R.id.textViewPax);
        etPax = findViewById(R.id.editTextNumber);
        tBtnSVS = findViewById(R.id.toggleButtonSVS);
        tBtnGST = findViewById(R.id.toggleButtonGST);
        tvDiscount = findViewById(R.id.textViewDiscount);
        etDiscount = findViewById(R.id.editTextDiscount);
        rgPayBy = findViewById(R.id.RadioGroupPayBy);
        btnSplit = findViewById(R.id.buttonSplit);
        btnReset = findViewById(R.id.buttonReset);
        tvTotal = findViewById(R.id.textViewTotal);
        tvBill = findViewById(R.id.textViewBill);

        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etAmount.getText().toString().trim().length() != 0 && etPax.getText().toString().trim().length() != 0) {
                    Double amount = Double.parseDouble(etAmount.getText().toString());
                    Double newAmount = 0.0;
                    if (tBtnSVS.isChecked() == false && tBtnGST.isChecked() == false) {
                        newAmount = amount;
                    } else if (tBtnSVS.isChecked() == false && tBtnGST.isChecked() == true) {
                        newAmount = amount + (amount * 0.07);
                    } else if (tBtnSVS.isChecked() == true && tBtnGST.isChecked() == false) {
                        newAmount = amount + (amount * 1.10);
                    } else if (tBtnSVS.isChecked() == true && tBtnGST.isChecked() == true) {
                        newAmount = amount + (amount * 1.17);
                    }

                }

                String mode


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAmount.setText("");
                etDiscount.setText("");
                etPax.setText("");
                tBtnGST.setChecked(false);
                tBtnSVS.setChecked(false);
                tvTotal.setText("");
                tvBill.setText("");
            }
        });
    }
}