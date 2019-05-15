package trabalhopoo.nullapp;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class tela_login extends AppCompatActivity {

    BancoDados db = new BancoDados(this);
    EditText etcpf,etsenha;



    @Override
    protected void onCreate(@Nullable Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_login);

        etcpf = (EditText) findViewById(R.id.etCpf);
        etsenha = (EditText) findViewById(R.id.etSenha);
        
    }

    public void abrirCadastraCliente(View view){
        startActivity(new Intent(getBaseContext(),CadastrarCliente.class));
    }

    public void abrirMainActivity(View view){

        List<Cliente> clientes = db.listaTodosClientes();
        String cpf = etcpf.getText().toString();
        String senha = etsenha.getText().toString();

        for (Cliente c : clientes){
            if(cpf.equals(c.getCpf()) && senha.equals(c.getSenha())){
                ClienteLogado h = new ClienteLogado();
                h.setCpf(c.getCpf());
                db.addClienteLogado(h);
                startActivity(new Intent(getBaseContext(),MainActivity.class));
            }
        }

    }
}