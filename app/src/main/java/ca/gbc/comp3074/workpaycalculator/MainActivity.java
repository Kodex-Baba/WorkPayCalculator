package ca.gbc.comp3074.workpaycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHoursWorked, editTextHourlyRate;
    private TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextHoursWorked = findViewById(R.id.editTextHoursWorked);
        editTextHourlyRate = findViewById(R.id.editTextHourlyRate);
        textViewResults = findViewById(R.id.textViewResults);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        // Set OnClickListener for the Calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePay();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.action_about) {
            // Launch AboutActivity when "About" menu item is selected
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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

        // Set the result to TextView
        textViewResults.setText(resultMessage);

        // Load and start the fade-in animation
        Animation fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        textViewResults.startAnimation(fadeIn);  // Apply fade-in animation
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
        double totalPayBeforeTax = regularPay + overtimePay;
        double tax = totalPayBeforeTax * 0.18;
        double totalPayAfterTax = totalPayBeforeTax - tax; // Subtract tax

        // Prepare result message
        String resultMessage = "Regular Pay: $" + regularPay + "\n" +
                "Overtime Pay: $" + overtimePay + "\n" +
                "Total Pay (Before Tax): $" + totalPayBeforeTax + "\n" +
                "Tax: $" + tax + "\n" +
                "Total Pay (After Tax): $" + totalPayAfterTax;

        return resultMessage;
    }
}
