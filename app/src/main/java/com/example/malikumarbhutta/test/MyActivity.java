package com.example.malikumarbhutta.test;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyActivity extends Activity {

    EditText mEditText;
    TextView mTextView;
    Button mButton;
    ListView mListView;
    ArrayAdapter<String> mAdapter;
    ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mEditText=(EditText)findViewById(R.id.editText);
        mTextView=(TextView)findViewById(R.id.textView);
        mButton=(Button)findViewById(R.id.button);
        mListView=(ListView)findViewById(R.id.listView);
        mData = new ArrayList<String>();
        mAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,mData);
        mListView.setAdapter(mAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Text= mEditText.getText().toString();
                if(!TextUtils.isEmpty(Text)){
                    mTextView.setText(Text);
                    mData.add(Text);
                    mAdapter.notifyDataSetChanged();
                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
