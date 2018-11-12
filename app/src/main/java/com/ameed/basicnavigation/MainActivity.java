package com.ameed.basicnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_EMPLOYEE_REQUEST_CODE = 1;
    public static final String TAX_PERCENT = "TAX_PERCENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button addButton = findViewById(R.id.addEmployeeBtn);
        addButton.setOnClickListener(v -> {
            final Intent intent = new Intent(this, EmployeeActivity.class);
            intent.putExtra(TAX_PERCENT, 10);
            startActivityForResult(intent, ADD_EMPLOYEE_REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_EMPLOYEE_REQUEST_CODE && resultCode == RESULT_OK) {
            final String name = data.getExtras().getString(EmployeeActivity.EMPLOYEE_NAME);
            final int calculatedSalary = data.getExtras().getInt(EmployeeActivity.EMPLOYEE_SALARY);
            final TextView employeeSummary = findViewById(R.id.employeeSummary);
            employeeSummary.setText(String.format("Hello '%s'.. Your salary is %d", name, calculatedSalary));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
