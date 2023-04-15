package com.example.roommvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.roommvvm.database.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EmployeeAdapter adapter;
    private EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("UWC", "Activity created new");

        // Set up the RecyclerView to display the data
        RecyclerView rv = findViewById(R.id.item_list);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new EmployeeAdapter();
        rv.setAdapter(adapter);

        // Retrieve data from ViewModel and pass to RecyclerView
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        employeeViewModel.getEmployees().observe(this, employees -> {
            Log.i("UWC", "Employees live data changed");
            adapter.setEmployees(employees);
        });

        // Set up the search button and text field
        TextView searchBtn = findViewById(R.id.search_btn);
        EditText searchText = findViewById(R.id.search_bar);

        searchBtn.setOnClickListener(v -> {
            employeeViewModel.setSearchFilter(searchText.getText().toString());
        });
    }

    private class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeCardHolder> {
        private List<EmployeeEntity> employees;

        public void setEmployees(List<EmployeeEntity> employees) {
            this.employees = new ArrayList<>(employees);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public EmployeeCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EmployeeCardHolder(getLayoutInflater().inflate(R.layout.view_employee_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull EmployeeCardHolder holder, int position) {
            holder.id.setText(String.valueOf(employees.get(position).id));
            holder.name.setText(employees.get(position).name);
            holder.salary.setText(String.valueOf(employees.get(position).salary));
        }

        @Override
        public int getItemCount() {
            return employees != null ? employees.size() : 0;
        }

        class EmployeeCardHolder extends RecyclerView.ViewHolder {
            TextView id;
            TextView name;
            TextView salary;

            public EmployeeCardHolder(@NonNull android.view.View itemView) {
                super(itemView);
                id = itemView.findViewById(R.id.employee_id);
                name = itemView.findViewById(R.id.employee_name);
                salary = itemView.findViewById(R.id.employee_salary);
            }
        }
    }
}