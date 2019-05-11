package trabalhopoo.nullapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Utility.ExpressaoRegular;

/**
 * Created by 6445080 on 06/05/2019.
 */

public class CadastrarCliente extends AppCompatActivity {

    BancoDados db = new BancoDados(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_cadastrarcliente);


        Button BtCadastrar;

        BtCadastrar = (Button) findViewById(R.id.BCadastrar);

        BtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


                Cliente user = new Cliente();
                user.SetUser(Nome,CPF,Telefone,email,Senha); // Construtor de Usuario

                ExpressaoRegular Verifica = new ExpressaoRegular();

                if(Verifica.verificaNome(Nome) == true){ // NOME
                    if(Verifica.verificaCpf(CPF) == true){ // CPF
                        if(Verifica.verificaTelefone(Telefone) == true){ // Telefone
                            if(Verifica.verificaEmail(email) == true){ // E-mail
                                if(Verifica.verificaSenha(Senha)== true && Senha.equals(ConfirmaSenha) == true){ // senha e confirma senha
                                    //VINCULAR COM O BANCO-------------------------------------------------------------------------------------------------------
                                    db.addCliente(user);
                                    Alerta("Você foi cadastrado com sucesso!");
                                    finish();
                                }else{  //Senha
                                    etsenha.setText("");
                                    Alerta("Senha invalida ou Senhas não Combinam\nA senha deve ter no minimo:\n\t1 Letra Maiúscula\n\t1 Número\n\tE 6 Caracteres");
                                }
                            }else{ // email
                                etemail.setText("");
                                Alerta("E-mail invalido!");
                            }
                        }else{ //telefone
                            ettelefone.setText("");
                            Alerta("Telefone invalido!   Exemplo: (xx) xxxxx-xxxx");
                        }
                    }else{ // cpf
                        etcpf.setText("");
                        Alerta("Cpf invalido!  Exemplo: XXX.XXX.XXX-XX");
                    }
                }else{ //nome
                    etnome.setText("");
                    Alerta("Nome invalido! O nome deve ter no minimo 3 letras");
                }
            }
        });

        }


    private void Alerta(String a){
        Toast.makeText(this,a,Toast.LENGTH_LONG).show();
    }
}
