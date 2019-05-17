package trabalhopoo.nullapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class tela_editar_produtos extends AppCompatActivity {

    BancoDados db = new BancoDados(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produtos);


        ClienteLogado p = db.listaTodosClientesLogados();

        ArrayList<Produto> produtos = db.listarProdutosdoUsuario(p.getCpf());

        ListView lista = (ListView) findViewById(R.id.list);
        ArrayAdapter adapter = new ProdutoAdapter(this, produtos, p);
        lista.setAdapter(adapter);
    }
}
