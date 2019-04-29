package trabalhopoo.nullapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class tela_vender extends AppCompatActivity {

    EditText editCodigo,editNome,editEmail,editTelefone;
    ListView listViewClientes;

    @Override

    protected void onCreate(@Nullable Bundle savedInstaceState){

        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_vender);

        editCodigo = (EditText) findViewById(R.id.edit_codigo);
        editNome = (EditText)findViewById(R.id.edit_nome);
        editEmail = (EditText)findViewById(R.id.edit_email);
        editTelefone = (EditText)findViewById(R.id.edit_telefone);

        listViewClientes = (ListView)findViewById(R.id.listview_clientes);

    }

    /*
    public void salvarInformacoes(View view){

//        Produto p = new Produto();
//
//        ArrayList<Produto> lista = new ArrayList<>();
//
//
//        EditText e1 = (EditText) findViewById(R.id.text_nome);
//        p.setNome(e1.getText().toString());
//
//        e1 = (EditText) findViewById(R.id.text_preco);
//        p.setPreco_unitario(Float.valueOf(e1.getText().toString()));
//
//        e1 = (EditText) findViewById(R.id.text_quantidade);
//        p.setQuantidade(Integer.valueOf(e1.getText().toString()));
//
//        e1 = (EditText) findViewById(R.id.text_descricao);
//        p.setDescricao(e1.getText().toString());
//
//
//        TextView e2 = (TextView) findViewById(R.id.textView);
//        e2.setText(p.getNome() +  Float.toString(p.getPreco_unitario()));

    }*/


}
