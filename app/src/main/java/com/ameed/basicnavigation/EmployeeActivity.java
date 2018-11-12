package com.ameed.basicnavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class EmployeeActivity extends AppCompatActivity {

    public static final String EMPLOYEE_NAME = "EMPLOYEE_NAME";
    public static final String EMPLOYEE_SALARY = "EMPLOYEE_SALARY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        final int taxPercent = getIntent().getExtras().getInt(MainActivity.TAX_PERCENT);
        final EditText taxEdit = findViewById(R.id.taxPercent);
        taxEdit.setText(String.valueOf(taxPercent));

        final Button addBtn = findViewById(R.id.addEmployee);
        addBtn.setOnClickListener(v -> {
            final EditText employeeName = findViewById(R.id.employeeName);
            getIntent().putExtra(EMPLOYEE_NAME, employeeName.getText().toString());
            final EditText employeeSalary = findViewById(R.id.employeeSalary);
            final int calculatedSalary = Integer.parseInt(employeeSalary.getText().toString()) * (100 - taxPercent) / 100;
            getIntent().putExtra(EMPLOYEE_SALARY, calculatedSalary);
            setResult(RESULT_OK, getIntent());
            finish();
        });
    }
}
