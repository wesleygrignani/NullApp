package trabalhopoo.nullapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class sacolaCompras extends AppCompatActivity {

    BancoDados db = new BancoDados(this);
    TextView t,t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sacola_activity);

        t = (TextView) findViewById(R.id.textView4);
        t1 = (TextView) findViewById(R.id.textView3);

        int soma = 0;
        int qtd = 0;
        try{
            ArrayList<Produto> produtos = db.listaTodosProdutosSacola();

            for(Produto p : produtos){
                soma += + p.getPreco_unitario();
                qtd++;
            }

            t.setText(String.valueOf(soma));
            t1.setText(String.valueOf(qtd));
        }catch (Exception e){
//            Toast.makeText(sacolaCompras.this,"OBA",Toast.LENGTH_LONG).show();
        }

    }

    public void visualizarItens(View view){
        startActivity(new Intent(getBaseContext(),visualizarSacola.class));
    }

    public void finalizarCompra(View view){
        startActivity(new Intent(getBaseContext(),CadastraCartao.class));
    }
}
