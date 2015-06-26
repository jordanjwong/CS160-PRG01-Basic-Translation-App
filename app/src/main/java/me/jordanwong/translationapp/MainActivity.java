package me.jordanwong.translationapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    String[] english_list = new String[5];
    String[] spanish_list = new String[5];
    String[] zulu_list = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner1();
        createSpinner2();
        createSpinner3();
        createSpinner4();
        populateLists();
    }

    public void createSpinner1() {
        Spinner spinner = (Spinner) findViewById(R.id.language1_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.language_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void createSpinner2() {
        Spinner spinner2 = (Spinner) findViewById(R.id.language2_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.language_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(1);
    }

    public void createSpinner3() {
        Spinner spinner3 = (Spinner) findViewById(R.id.language3_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.english_phrases, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
    }

    public void createSpinner4() {
        Spinner spinner4 = (Spinner) findViewById(R.id.language4_spinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.language_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setSelection(2);
    }

    public void changeSpinner(View view) {
        Spinner read = (Spinner) findViewById(R.id.language1_spinner);
        String readvalue = read.getSelectedItem().toString();
        Spinner write = (Spinner) findViewById(R.id.language3_spinner);
        int pos = write.getSelectedItemPosition();
        ArrayAdapter<CharSequence> adapter;
        if (readvalue.equals("English")) {
            adapter = ArrayAdapter.createFromResource(this, R.array.english_phrases, android.R.layout.simple_spinner_item);
        } else if (readvalue.equals("Spanish")) {
            adapter = ArrayAdapter.createFromResource(this, R.array.spanish_phrases, android.R.layout.simple_spinner_item);
        } else {
            adapter = ArrayAdapter.createFromResource(this, R.array.zulu_phrases, android.R.layout.simple_spinner_item);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        write.setAdapter(adapter);
        write.setSelection(pos);
    }

    public void populateLists() {
        english_list[0] = "Hello" ; english_list[1] = "How much?";
        english_list[2] = "Please"; english_list[3] = "Thank you";
        english_list[4] = "Goodbye"; spanish_list[0] = "Hola";
        spanish_list[1] = "Cuanto?"; spanish_list[2] = "Por favor";
        spanish_list[3] = "Gracias"; spanish_list[4] = "Adios";
        zulu_list[0] = "Sawubona"; zulu_list[1] = "Malini?";
        zulu_list[2] = "Ngiyacela"; zulu_list[3] = "Ngiyabonga";
        zulu_list[4] = "Hamba Kahle";
    }
    public void updateTranslation(View view) {
        Spinner read = (Spinner) findViewById(R.id.language2_spinner);
        String readvalue = read.getSelectedItem().toString();
        Spinner phrase = (Spinner) findViewById(R.id.language3_spinner);
        int index = phrase.getSelectedItemPosition();
        EditText write = (EditText) findViewById(R.id.edit_text);
        if (readvalue.equals("English")) {
            write.setText(english_list[index]);
        } else if (readvalue.equals("Spanish")) {
            write.setText(spanish_list[index]);
        } else {
            write.setText(zulu_list[index]);
        }
        Spinner read2 = (Spinner) findViewById(R.id.language4_spinner);
        String readvalue2 = read2.getSelectedItem().toString();
        Spinner phrase2 = (Spinner) findViewById(R.id.language3_spinner);
        int index2 = phrase2.getSelectedItemPosition();
        EditText write2 = (EditText) findViewById(R.id.edit_text2);
        if (readvalue2.equals("English")) {
            write2.setText(english_list[index]);
        } else if (readvalue2.equals("Spanish")) {
            write2.setText(spanish_list[index]);
        } else {
            write2.setText(zulu_list[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
