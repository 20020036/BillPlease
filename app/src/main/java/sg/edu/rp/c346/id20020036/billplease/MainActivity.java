package sg.edu.rp.c346.id20020036.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
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

                Double newAmount = 0.0;
                if (etAmount.getText().toString().trim().length() != 0 && etPax.getText().toString().trim().length() != 0) {
                    Double amount = Double.parseDouble(etAmount.getText().toString());

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

                else
                {
                    Toast.makeText(MainActivity.this,"Please enter details!", Toast.LENGTH_LONG).show();
                }

                int pax = Integer.parseInt(etPax.getText().toString());

                if(etDiscount.getText().toString().trim().length()!=0)
                {
                    Double percentage = (Double.parseDouble(etDiscount.getText().toString()) / 100);
                    Double aftDiscount = newAmount * (1 - percentage);
                    Double eachAmount = aftDiscount / pax;
                    String totalbill = String.format("%.2f", aftDiscount);
                    String eachpays = String.format("%.2f", eachAmount);
                    if(rgPayBy.getCheckedRadioButtonId() == R.id.radioButtonCash)
                    {
                        tvTotal.setText("Total Bill: $" + totalbill);
                        tvBill.setText("Each Pays: $" + eachpays);
                    }
                    else
                    {
                        tvTotal.setText("Total Bill: $" + totalbill);
                        tvBill.setText("Each Pays: $" + eachpays + " via PayNow to 912345678");
                    }
                }


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