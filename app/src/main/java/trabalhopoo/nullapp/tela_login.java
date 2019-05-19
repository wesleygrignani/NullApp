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

    private static final String TABELA_SACOLA_PRODUTO = "sacola";
    private static final String COLUNA_CODIGO_PRODUTO_SACOLA = "codigo";
    private static final String COLUNA_NOME_PRODUTO_SACOLA = "nome";
    private static final String COLUNA_PRECO_SACOLA = "preco";
    private static final String COLUNA_QUANTIDADE_SACOLA = "quantidade";
    private static final String COLUNA_CPFPRODUTO_SACOLA = "cpf";
    private static final String COLUNA_FOTO_SACOLA = "foto";

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

        String sql = "DROP TABLE IF EXISTS sacola";
        db.receberComandoSQL(sql);
        String sql2 = "CREATE TABLE " + TABELA_SACOLA_PRODUTO + "(" + COLUNA_CODIGO_PRODUTO_SACOLA + " INTEGER, " + COLUNA_NOME_PRODUTO_SACOLA + " TEXT, " + COLUNA_PRECO_SACOLA
                + " INTEGER , " + COLUNA_QUANTIDADE_SACOLA + " INTEGER, " + COLUNA_CPFPRODUTO_SACOLA + " TEXT, " + COLUNA_FOTO_SACOLA + " BLOB)";
        db.receberComandoSQL(sql2);

        List<Cliente> clientes = db.listaTodosClientes();
        String cpf = etcpf.getText().toString();
        String senha = etsenha.getText().toString();

        for (Cliente c : clientes){
            if(cpf.equals(c.getCpf()) && senha.equals(c.getSenha())){
                ClienteLogado h = new ClienteLogado();
                h.setCpf(c.getCpf());
                db.addClienteLogado(h);
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                Toast.makeText(this,"Logado com sucesso!",Toast.LENGTH_LONG).show();
            }
        }
    }
}