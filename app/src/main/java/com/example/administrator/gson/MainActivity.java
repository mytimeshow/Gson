package com.example.administrator.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView tv;
    String jsonStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student s1=new Student(001,"zhangsan",18);
        Student s2=new Student(002,"lisi",19);
        Student s3=new Student(003,"wangwu",20);
        final Student[] list={s1,s2,s3};
        btn1= (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArray array=new JSONArray();
                JSONObject obj;
                for(int i=0;i<list.length;i++){
                obj=getStudentJsonObj(list[i]);
                    array.put(obj);
                }
                JSONObject stuobj=new JSONObject();
                try {
                    stuobj.put("stulist",array);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jsonStr=stuobj.toString();
                tv.setText(stuobj.toString());
            }
        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    JSONObject obj = new JSONObject(jsonStr);
                    JSONArray array = obj.getJSONArray("stuList");

                    ArrayList<Student> stuList = new ArrayList<Student>();
                    for(int i=0; i<array.length(); i++){
                        JSONObject stuObj = array.getJSONObject(i);
                        int id = stuObj.getInt("id");
                        String name = stuObj.getString("name");
                        int age = stuObj.getInt("age");
                        Student s = new Student(id, name, age);
                        stuList.add(s);
                    }
                }catch (JSONException e){
                    Log.i("MainActivity", e.toString());
                }
            }
        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String jsonStr = "{\"id\":101,\"name\":\"mytime\",\"age\":21}";
                    Gson gson = new Gson();
                    Student s = gson.fromJson(jsonStr, Student.class);
                    tv.setText(s.getId()+"  "+s.getName() + "   " + s.getAge());

            }
        });

        initviews();
    }

    private void initviews() {
        tv= (TextView) findViewById(R.id.tv);

    }
    private JSONObject getStudentJsonObj(Student s) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("id", s.getId());
            obj.put("name", s.getName());
            obj.put("age", s.getAge());
        } catch (JSONException e){
            Log.i("MainActivity", e.toString());
        }
        return obj;
    }
}
