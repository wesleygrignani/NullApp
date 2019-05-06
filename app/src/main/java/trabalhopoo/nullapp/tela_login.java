package trabalhopoo.nullapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class tela_login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_login);

    }

    public void abrirCadastraCliente(View view){
        startActivity(new Intent(getBaseContext(),CadastrarCliente.class));
    }

    public void abrirMainActivity(View view){
        startActivity(new Intent(getBaseContext(),MainActivity.class));
    }


}