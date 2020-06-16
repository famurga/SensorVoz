package com.example.letsgofmd;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    int codigo;
    TextView Mensaje;
    private static final int SPEECH_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mensaje = (TextView)findViewById(R.id.mensaje);


        displaySpeechRecognizer();

    }

    // Cree una intención que pueda iniciar la actividad de Reconocimiento de voz
    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Comience la actividad, la intención se completará con el texto del discurso
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }


    // Esta devolución de llamada se invoca cuando regresa el Reconocimiento de voz.
    // Aquí es donde procesas la intención y extraes el texto del discurso de la intención.
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            Mensaje.setText(spokenText);

            if(spokenText=="siguiente página"){
                Intent intent1 = new Intent(this,ActivitySiguiente.class);
                startActivity(intent1);
            }
            if(spokenText.equals("siguiente página")){
                Intent intent1 = new Intent(this,ActivitySiguiente.class);
                startActivity(intent1);
            }

            if(spokenText.equals("hola")){
                Intent intent1 = new Intent(this,ActivitySiguiente.class);
                startActivity(intent1);
            }

            // Haz algo con voiceText
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
