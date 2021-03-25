package com.tykhes.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText passwordText;
    ArrayList<String> LettersList=new ArrayList<>();
    ArrayList<String> NumbersList=new ArrayList<String>();
    Switch letterCheck;
    Switch NumberCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordText=findViewById(R.id.editTextTextPersonName);
        letterCheck=findViewById(R.id.switch2);
        NumberCheck=findViewById(R.id.switch1);
        List<String> letterEz= Arrays.asList("Q","W","E","R","T","Y","U","I","O","P","G","U","A","D","S","F","G","H","J","K","L","Z","X","C","V","B","N","M","q","w","e","r","t","y","u","i","o","p","g","u","a","d","s","f","g","h","j","k","l","z","x","c","v","b","n","m");
        List<String> nummberEz=Arrays.asList("0","1","2","3","4","5","6","7","8","9");

        LettersList.addAll(letterEz);
        NumbersList.addAll(nummberEz);
        passwordText.setText("");

    }

    public void Generate(View view){
        passwordText.getText().clear();
        if (NumberCheck.isChecked()==true&&letterCheck.isChecked()==true){
            for (int i=0;i<6;i++){
                Random random=new Random();
                int numberrandom=random.nextInt(NumbersList.size());
                int numberrandoms=random.nextInt(LettersList.size());
                passwordText.append(NumbersList.get(numberrandom)+LettersList.get(numberrandoms));
            }
        }
        else if (NumberCheck.isChecked()==true){
            for (int i=0;i<NumbersList.size();i++){
                Random random=new Random();
                int numberrandom=random.nextInt(NumbersList.size());
                passwordText.append(NumbersList.get(numberrandom));
            }
        }
        else if (letterCheck.isChecked()==true){
            for (int i=0;i<NumbersList.size();i++){
                Random random=new Random();
                int numberrandom=random.nextInt(LettersList.size());
                passwordText.append(LettersList.get(numberrandom));
            }
        }
        else {
            passwordText.setText("Make Choose");
        }

    }


public void Copy(View view){
    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    ClipData clip = ClipData.newPlainText("clip", passwordText.getText());
    clipboard.setPrimaryClip(clip);
    Toast.makeText(getApplication(),"Copy!",Toast.LENGTH_LONG).show();
}
}