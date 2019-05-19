package trabalhopoo.nullapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(MainActivity.this,"Inserido com sucesso",Toast.LENGTH_LONG).show();
    }

    public void abrirTelaVendas(View view){
        startActivity(new Intent(getBaseContext(),tela_vender.class));
    }

    public void abrirTelaCompras(View view){
        startActivity(new Intent(getBaseContext(),tela_comprar.class));
    }

    public void abriTelaTeste(View view){
        startActivity(new Intent(getBaseContext(),CadastraCartao.class));
    }

    public void EditarProdutos(View view){
        startActivity(new Intent(getBaseContext(),tela_editar.class));
    }

    public void ComprarProdutos(View view){
        startActivity(new Intent(getBaseContext(),sacolaCompras.class));
    }
}
