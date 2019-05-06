package trabalhopoo.nullapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import Utility.ExpressaoRegular;

/**
 * Created by 6445080 on 06/05/2019.
 */

public class CadastrarCliente extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_cadastrarcliente);

        EditText etnome,etcpf,ettelefone,etemail,etsenha,etconfirmasenha;
        String Nome,CPF,Telefone,email,Senha,ConfirmaSenha;

        etnome = (EditText) findViewById(R.id.etnome);
        etcpf = (EditText) findViewById(R.id.etcpf);
        ettelefone = (EditText) findViewById(R.id.ettelefone);
        etemail = (EditText) findViewById(R.id.etemail);
        etsenha = (EditText) findViewById(R.id.etsenha);
        etconfirmasenha = (EditText) findViewById(R.id.etconfirmasenha);

        Nome = etnome.getText().toString();
        CPF = etcpf.getText().toString();
        Telefone = ettelefone.getText().toString();
        email = etemail.getText().toString();
        Senha = etsenha.getText().toString();
        ConfirmaSenha = etconfirmasenha.getText().toString();

        // continuar


    }
}
