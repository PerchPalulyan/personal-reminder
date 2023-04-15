package com.example.roommvvm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEmployeeFragment extends Fragment {
    private EditText nameEditText;
    private EditText salaryEditText;
    private Button addButton;
    private EmployeeViewModel employeeViewModel;

    public AddEmployeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize UI components
        nameEditText = view.findViewById(R.id.name_edit_text);
        salaryEditText = view.findViewById(R.id.salary_edit_text);
        addButton = view.findViewById(R.id.add_button);

        // Get the EmployeeViewModel
        employeeViewModel = new ViewModelProvider(requireActivity()).get(EmployeeViewModel.class);

        // Set the click listener for the Add button
        addButton.setOnClickListener(v -> {
            // Get the name and salary values from the EditText fields
            String name = nameEditText.getText().toString();
            String salaryString = salaryEditText.getText().toString();

            // Check if the name and salary fields are empty
            if (name.trim().isEmpty() || salaryString.trim().isEmpty()) {
                Toast.makeText(getContext(), "Please enter name and salary", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convert the salary value to a number
            double salary = Double.parseDouble(salaryString);

            // Add the new employee to the database
            Employee employee = new Employee(name, salary);
            employeeViewModel.insertEmployee(employee);

            // Clear the EditText fields
            nameEditText.setText("");
            salaryEditText.setText("");

            // Show a success message
            Toast.makeText(getContext(), "Employee added", Toast.LENGTH_SHORT).show();
        });
    }
}