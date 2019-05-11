package trabalhopoo.nullapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

//classe para fazer a conexao com o banco de dados SQLite
public class BancoDados extends SQLiteOpenHelper {


    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CLIENTE = "bd_clientes";

    //TABELA CLIENTE
    private static final String TABELA_CLIENTE = "tb_clientes";
    private static final String COLUNA_CODIGO = "codigo";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_TELEFONE = "telefone";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_CPF  = "cpf";
    private static final String COLUNA_SENHA = "senha";

    //TABELA CLIENE LOGADO
    private static final String TABELA_LOGADO= "tb_logado";
    private static final String COLUNA_CODLOGADO = "codigo";
    private static final String COLUNA_CPFLOGADO  = "cpf";



    public BancoDados(Context context) {

        super(context, BANCO_CLIENTE,null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_1 = "CREATE TABLE " + TABELA_CLIENTE + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY, " + COLUNA_NOME + " TEXT, " +
                COLUNA_TELEFONE + " TEXT, " + COLUNA_EMAIL + " TEXT, " + COLUNA_CPF + " TEXT, " + COLUNA_SENHA + " TEXT)";

        String QUERY_2 = "CREATE TABLE " + TABELA_LOGADO + "(" + COLUNA_CODLOGADO + " INTEGER PRIMARY KEY, " + COLUNA_CPFLOGADO + " TEXT)";

        db.execSQL(QUERY_1);
        db.execSQL(QUERY_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addCliente(Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_NOME,cliente.getNome());
        values.put(COLUNA_TELEFONE,cliente.getTelefone());
        values.put(COLUNA_EMAIL,cliente.getEmail());
        values.put(COLUNA_CPF,cliente.getCpf());
        values.put(COLUNA_SENHA,cliente.getSenha());

        db.insert(TABELA_CLIENTE,null,values);
        db.close();
    }

    void apagarCliente(Cliente cliente){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELA_CLIENTE,COLUNA_CODIGO + " = ?", new String[]{String.valueOf(cliente.getCodigo())});

        db.close();

    }

    Cliente selecionarCLiente(String codigo){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_CLIENTE, new String[] {COLUNA_CODIGO,COLUNA_NOME,COLUNA_TELEFONE,COLUNA_EMAIL,COLUNA_CPF,COLUNA_SENHA},COLUNA_CPF + " = ?",
                new String[] {String.valueOf(codigo)},null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo(Integer.parseInt(cursor.getString(0)));
        cliente1.setNome(cursor.getString(1));
        cliente1.setTelefone(cursor.getString(2));
        cliente1.setEmail(cursor.getString(3));
        cliente1.setCpf(cursor.getString(4));
        cliente1.setSenha(cursor.getString(5));

        return cliente1;
    }

    public List<Cliente> listaTodosClientes(){

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        String query = "SELECT * FROM " + TABELA_CLIENTE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c.moveToFirst()){
            do{

                Cliente cliente = new Cliente();
                cliente.setCodigo(Integer.parseInt(c.getString(0)));
                cliente.setNome(c.getString(1));
                cliente.setTelefone(c.getString(2));
                cliente.setEmail(c.getString(3));
                cliente.setCpf(c.getString(4));
                cliente.setSenha(c.getString(5));

                listaClientes.add(cliente);


            }while(c.moveToNext());

        }

        return listaClientes;
    }


    void addClienteLogado(ClienteLogado cliente){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUNA_CPFLOGADO,cliente.getCpf());

        db.insert(TABELA_LOGADO,null,values);

        db.close();
    }


    public ClienteLogado listaTodosClientesLogados(){

        ClienteLogado h = new ClienteLogado();
        String query = "SELECT * FROM " + TABELA_LOGADO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c.moveToFirst()){
            do{

                ClienteLogado cliente = new ClienteLogado();
                cliente.setCodigo(Integer.parseInt(c.getString(0)));
                cliente.setCpf(c.getString(1));
                h = cliente;
            }while(c.moveToNext());

        }

        return h;
    }

    /*

    private String[] toArgs(Cliente aluno) {
        String[] args = {String.valueOf(aluno.getCodigo())};
        return args;
    }


    private ContentValues toValues(Cliente aluno) {
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("telefone", aluno.getTelefone());
        values.put("email", aluno.getEmail());
        values.put("cpf", aluno.getCpf());
        values.put("senha", aluno.getSenha());
        return values;
    }

    public void alterar(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = toValues(cliente);
        db.update("tb_clientes", values, "id=?", toArgs(cliente));
    }*/

}
