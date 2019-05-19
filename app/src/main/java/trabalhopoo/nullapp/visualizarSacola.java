package trabalhopoo.nullapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class visualizarSacola extends AppCompatActivity {

    BancoDados db = new BancoDados(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_sacola);


        ClienteLogado p = db.listaTodosClientesLogados();

        ArrayList<Produto> produtos = db.listaTodosProdutosSacola();

        ListView lista = (ListView) findViewById(R.id.list);
        ArrayAdapter adapter = new ProdutoAdapter2(this, produtos, p);
        lista.setAdapter(adapter);
    }
}
