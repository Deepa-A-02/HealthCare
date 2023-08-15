package com.example.healthinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctordetails1=
            {
                    {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No : 9885697482 ","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs ","Mobile No : 9925874135","900"},
                    {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 8yrs","Mobile No : 8857436954","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchwad","Exp : 6yrs","Mobile No : 9632587412","500"},
                    {"Doctor Name : Ashok Panda","Hospital Address : Katraj","Exp : 7yrs","Mobile No : 7753698241","800"}
            };
    private String[][] doctordetails2=
            {
                    {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile No : 9885697482 ","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs ","Mobile No : 9925874135","900"},
                    {"Doctor Name : Swapnil Kale","Hospital Address : Pune","Exp : 8yrs","Mobile No : 8857436954","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchwad","Exp : 6yrs","Mobile No : 9632587412","500"},
                    {"Doctor Name : Ashok Panda","Hospital Address : Katraj","Exp : 7yrs","Mobile No : 7753698241","800"}
            };
    private String[][] doctordetails3=
            {
                    {"Doctor Name : Seema Patil","Hospital Address : Pimpri","Exp : 5yrs","Mobile No : 9885697482 ","200"},
                    {"Doctor Name : Pankaj Parab","Hospital Address : Nigdi","Exp : 15yrs ","Mobile No : 9925874135","300"},
                    {"Doctor Name : Monish Jain","Hospital Address : Pune","Exp : 8yrs","Mobile No : 8857436954","300"},
                    {"Doctor Name : Vishal Deshmukh","Hospital Address : Chinchwad","Exp : 6yrs","Mobile No : 9632587412","500"},
                    {"Doctor Name : Shrikant Pandey","Hospital Address : Katraj","Exp : 7yrs","Mobile No : 7753698241","600"}
            };
    private String[][] doctordetails4=
            {
                    {"Doctor Name : Nilesh Borate","Hospital Address : Pimpri","Exp : 5yrs","Mobile No : 9885697482 ","600"},
                    {"Doctor Name : Pankaj Pawar","Hospital Address : Nigdi","Exp : 15yrs ","Mobile No : 9925874135","900"},
                    {"Doctor Name : Nilesh Kale","Hospital Address : Pune","Exp : 8yrs","Mobile No : 8857436954","300"},
                    {"Doctor Name : Deepak Deshpandey","Hospital Address : Chinchwad","Exp : 6yrs","Mobile No : 9632587412","500"},
                    {"Doctor Name : Ankur Panda","Hospital Address : Katraj","Exp : 7yrs","Mobile No : 7753698241","800"}
            };
    private String[][] doctordetails5=
            {
                    {"Doctor Name : Amol Gawde","Hospital Address : Pimpri","Exp : 5yrs","Mobile No : 9885697482 ","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Nigdi","Exp : 15yrs ","Mobile No : 9925874135","900"},
                    {"Doctor Name : Nilesh Kale","Hospital Address : Pune","Exp : 8yrs","Mobile No : 8857436954","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchwad","Exp : 6yrs","Mobile No : 9632587412","500"},
                    {"Doctor Name : Ashok Singh","Hospital Address : Katraj","Exp : 7yrs","Mobile No : 7753698241","800"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewHADTitle);
        btn=findViewById(R.id.buttonHADBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctordetails1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctordetails2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctordetails3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctordetails4;
        else
            doctor_details=doctordetails5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line1","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);

        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst=findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}