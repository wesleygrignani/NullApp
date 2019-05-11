package trabalhopoo.nullapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class tela_vender extends AppCompatActivity {

    EditText editCodigo,editNome,editEmail,editTelefone;
    ListView listViewClientes;

    BancoDados db = new BancoDados(this);

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;


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


    public void salvarCliente(View view){

        Cliente aux = new Cliente();

        aux.setNome(editNome.getText().toString());
        aux.setEmail(editEmail.getText().toString());
        aux.setTelefone(editTelefone.getText().toString());

        db.addCliente(aux);

        Toast.makeText(tela_vender.this,"Cliente Adicionado",Toast.LENGTH_LONG).show();

    }

    public void listarClientes(View view){

        ClienteLogado clientes = db.listaTodosClientesLogados();

        Cliente y = db.selecionarCLiente(clientes.getCpf());

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(tela_vender.this,android.R.layout.simple_list_item_1,arrayList);

        listViewClientes.setAdapter(adapter);

        arrayList.add(y.getCpf() + "-" + y.getNome());
        adapter.notifyDataSetChanged();


    }
}
