package com.example.noam_the_king;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button addStudentBtn;
    Button checkStudentBtn;
    Button logSortedGradesBtn;
    EditText etStudentName;
    EditText etGrade;
    EditText etStudentQuery;
    TextView tvStudentGrade;
    ArrayList<Student> studentsList = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addStudentBtn = findViewById(R.id.addStudentBtn);
        checkStudentBtn =findViewById(R.id.checkStudentBtn);
        logSortedGradesBtn =findViewById(R.id.logSortedGradesBtn);
        etStudentName=findViewById(R.id.etStudentName);
        etGrade=findViewById(R.id.etGrade);
        etStudentQuery=findViewById(R.id.etStudentQuery);
        tvStudentGrade=findViewById(R.id.tvStudentGrade);

        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student tempStudent = new Student();
                tempStudent.name=etStudentName.getText().toString();
                tempStudent.grade= Integer.parseInt(etGrade.getText().toString());
                studentsList.add(tempStudent);
                Log.d("MainActivity", "Student add: "+tempStudent.name+" "+tempStudent.grade);
            }
        });
        checkStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Student st : studentsList)
                {
                    if(st.name.equals(etStudentQuery.getText().toString()))
                    {
                        tvStudentGrade.setText(st.grade.toString());
                    }
                }


            }
        });
    }
}