package ca.gbc.comp3074.workpaycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHoursWorked, editTextHourlyRate;
    private TextView textViewResults;  // New TextView to show results

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextHoursWorked = findViewById(R.id.editTextHoursWorked);
        editTextHourlyRate = findViewById(R.id.editTextHourlyRate);
        textViewResults = findViewById(R.id.textViewResults);  // Initialize TextView
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        // Set OnClickListener for the Calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePay();
            }
        });
    }

    private void calculatePay() {
        // Get the input values
        String hoursWorkedStr = editTextHoursWorked.getText().toString();
        String hourlyRateStr = editTextHourlyRate.getText().toString();

        // Check if the inputs are valid
        if (hoursWorkedStr.isEmpty() || hourlyRateStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both hours worked and hourly rate", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert input values to numbers
        double hoursWorked = Double.parseDouble(hoursWorkedStr);
        double hourlyRate = Double.parseDouble(hourlyRateStr);

        // Calculate regular and overtime pay
        String resultMessage = getResultMessage(hoursWorked, hourlyRate);

        // Show results in TextView instead of Toast
        textViewResults.setText(resultMessage);
    }

    private static @NonNull String getResultMessage(double hoursWorked, double hourlyRate) {
        double regularPay, overtimePay = 0.0;
        if (hoursWorked <= 40) {
            regularPay = hoursWorked * hourlyRate;
        } else {
            regularPay = 40 * hourlyRate;
            overtimePay = (hoursWorked - 40) * hourlyRate * 1.5;
        }

        // Calculate total pay and tax
        double totalPay = regularPay + overtimePay;
        double tax = totalPay * 0.18;

        // Prepare result message
        String resultMessage = "Regular Pay: $" + regularPay + "\n" +
                "Overtime Pay: $" + overtimePay + "\n" +
                "Total Pay: $" + totalPay + "\n" +
                "Tax: $" + tax;
        return resultMessage;
    }
}
