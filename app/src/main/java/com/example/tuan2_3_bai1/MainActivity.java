package com.example.tuan2_3_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtID , edtTen;
    RadioGroup rdg;
    Button btnNhap, btnXoa;
    RadioButton rbNam, rbNu;
    ArrayList<NhanVIen> arrayListnv;
    MyArrayAdapter adapter;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        arrayListnv = new ArrayList<>();

        adapter = new MyArrayAdapter(this, R.layout.my_item_layout,arrayListnv);
        lv.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nhap();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Xoa();
            }
        });


    }
    public void AnhXa(){
        edtID = findViewById(R.id.editTextID);
        edtTen = findViewById(R.id.editTextTen);
        btnNhap = findViewById(R.id.buttonNhap);
        btnXoa = findViewById(R.id.buttonXoa);
        rbNam = findViewById(R.id.radioButtonNam);
        rbNu = findViewById(R.id.radioButtonNu);
        lv = findViewById(R.id.listview);
        rdg = findViewById(R.id.radioGroup2);


    }
    public  void Nhap(){
        String ma = edtID.getText().toString();
        String ten = edtTen.getText().toString();
        boolean gender  = false;
        if(rdg.getCheckedRadioButtonId() == R.id.radioButtonNu){
            gender = true;
        }
//        else {
//            gender = false;
//        }
        NhanVIen nv = new NhanVIen();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gender);
        arrayListnv.add(nv);
        adapter.notifyDataSetChanged();
        edtID.setText("");
        edtTen.setText("");
        edtID.requestFocus();


    }
    public void Xoa(){
        for(int i = lv.getChildCount() - 1; i >=0; i--)
        {
            View view = lv.getChildAt(i);
            CheckBox chk = findViewById(R.id.cbx_item);
            if(chk.isChecked()){
                arrayListnv.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
