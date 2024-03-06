package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
Connection connect;
String ConnectionResults="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("hola");
    }
    public void GetTextFromSql(View v){
System.out.println("sex");
        TextView tx1= (TextView) findViewById(R.id.txt1);
        TextView tx2= (TextView) findViewById(R.id.txt2);
        EditText ed1= (EditText) findViewById(R.id.editTextText2);
        EditText ed2= (EditText) findViewById(R.id.editTextText3);

        try{
          ConnectionHelper connectionHelper =new ConnectionHelper();
          connect = connectionHelper.connectionclass();
          if(connect!=null){
              String query = "Select *from carrera";
              Statement st= connect.createStatement();
              ResultSet rs= st.executeQuery(query);
              while(rs.next()) {
                  tx1.setText(rs.getString(2));
                  tx2.setText(rs.getString(3));

              }

          }
          else{
              ConnectionResults="check connection";
          }

        }
        catch(Exception ex){

        }

    }

}