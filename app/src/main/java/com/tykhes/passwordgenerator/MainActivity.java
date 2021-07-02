package com.tykhes.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText passwordText;
    ArrayList<String> lettersList=new ArrayList<>();
    ArrayList<String> numbersList=new ArrayList<>();
    ArrayList<String> symbolList=new ArrayList<>();
    Switch letterCheck;
    Switch numberCheck;
    Switch symbolCheck;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordText=findViewById(R.id.passwordText);
        letterCheck=findViewById(R.id.lettersSwitch);
        numberCheck=findViewById(R.id.numbersSwitch);
        symbolCheck=findViewById(R.id.symbolSwitch);
        List<String> letterEz= Arrays.asList("Q","W","E","R","T","Y","U","I","O","P","G","U","A","D","S","F","G","H","J","K","L","Z","X","C","V","B","N","M","q","w","e","r","t","y","u","i","o","p","g","u","a","d","s","f","g","h","j","k","l","z","x","c","v","b","n","m");
        List<String> nummberEz=Arrays.asList("0","1","2","3","4","5","6","7","8","9");
        List<String> symbolEz=Arrays.asList(".","-","+","=","_",",","!","@","$","#","*","%","<",">","[","]","{","}");
        lettersList.addAll(letterEz);
        numbersList.addAll(nummberEz);
        symbolList.addAll(symbolEz);
        passwordText.setText("");
        random=new Random();
    }

    public void Generate(View view){
        passwordText.getText().clear();

        if (numberCheck.isChecked()==true&&letterCheck.isChecked()==true&&symbolCheck.isChecked()==true){
            for (int i=0;i<4;i++){
                int randomGet=random.nextInt(numbersList.size());
                int randomGet2=random.nextInt(lettersList.size());
                int randomGet3=random.nextInt(symbolList.size());
                passwordText.append(numbersList.get(randomGet)+lettersList.get(randomGet2)+symbolList.get(randomGet3));
            }
        }
        else if (numberCheck.isChecked()==true&&letterCheck.isChecked()==true){
            for (int i=0;i<6;i++){
                int randomGet=random.nextInt(numbersList.size());
                int randomGet2=random.nextInt(lettersList.size());
                passwordText.append(numbersList.get(randomGet)+lettersList.get(randomGet2));
            }
        }
        else if (numberCheck.isChecked()==true&&symbolCheck.isChecked()==true) {
            for (int i = 0; i < 6; i++) {
                int randomGet = random.nextInt(numbersList.size());
                int randomGet2 = random.nextInt(symbolList.size());
                passwordText.append(numbersList.get(randomGet) + symbolList.get(randomGet2));
            }
        }
        else if (letterCheck.isChecked()==true&&symbolCheck.isChecked()==true) {
            for (int i=0;i<6;i++){
                int randomGet = random.nextInt(lettersList.size());
                int randomGet2 = random.nextInt(symbolList.size());
                passwordText.append(lettersList.get(randomGet) + symbolList.get(randomGet2));
            }
        }
        else if (numberCheck.isChecked()==true){
            for (int i=0;i<numbersList.size();i++){
                int randomGet=random.nextInt(numbersList.size());
                passwordText.append(numbersList.get(randomGet));
            }
        }
        else if (letterCheck.isChecked()==true){
            for (int i=0;i<numbersList.size();i++){
                int randomGet=random.nextInt(lettersList.size());
                passwordText.append(lettersList.get(randomGet));
            }
        }
        else if (symbolCheck.isChecked()==true){
            for (int i=0;i<numbersList.size();i++){
                int randomGet=random.nextInt(symbolList.size());
                passwordText.append(symbolList.get(randomGet));
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