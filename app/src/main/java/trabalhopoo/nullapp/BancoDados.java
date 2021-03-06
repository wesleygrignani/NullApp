package trabalhopoo.nullapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
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

    //TABELA PRODUTO
    private static final String TABELA_PRODUTO = "produtos";
    private static final String COLUNA_CODPRODUTO = "codigo";
    private static final String COLUNA_NOMEPRODUTO = "nome";
    private static final String COLUNA_PRECO = "preco";
    private static final String COLUNA_QUANTIDADE = "quantidade";
    private static final String COLUNA_CPFPRODUTO = "cpf";
    private static final String COLUNA_FOTO = "foto";

    //TABELA AUXILAR PARA EDITAR PRODUTO
    private static final String TABELA_EDITAR_PRODUTO = "produto";
    private static final String COLUNA_CODIGO_PRODUTO = "codigo";
    private static final String COLUNA_NOME_PRODUTO = "nome";

    //TABELA AUXILAR PARA COMPRAR PRODUTO
    private static final String TABELA_SACOLA_PRODUTO = "sacola";
    private static final String COLUNA_CODIGO_PRODUTO_SACOLA = "codigo";
    private static final String COLUNA_NOME_PRODUTO_SACOLA = "nome";
    private static final String COLUNA_PRECO_SACOLA = "preco";
    private static final String COLUNA_QUANTIDADE_SACOLA = "quantidade";
    private static final String COLUNA_CPFPRODUTO_SACOLA = "cpf";
    private static final String COLUNA_FOTO_SACOLA = "foto";

    //TABELA ENDERECO
    private static final String TABELA_ENDERECO = "endereco";
    private static final String COLUNA_CODIGO_ENDERECO = "codigo";
    private static final String COLUNA_CEP = "cep";
    private static final String COLUNA_LOGRADOURO = "logradouro";
    private static final String COLUNA_BAIRRO = "bairro";
    private static final String COLUNA_COMPLEMENTO = "complemento";
    private static final String COLUNA_CIDADE = "cidade";
    private static final String COLUNA_UF = "uf";
    private static final String COLUNA_CPF_ENDERECO = "cpf";




    public BancoDados(Context context) {
        super(context, BANCO_CLIENTE,null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_1 = "CREATE TABLE " + TABELA_CLIENTE + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY, " + COLUNA_NOME + " TEXT, " +
                COLUNA_TELEFONE + " TEXT, " + COLUNA_EMAIL + " TEXT, " + COLUNA_CPF + " TEXT, " + COLUNA_SENHA + " TEXT)";

        String QUERY_2 = "CREATE TABLE " + TABELA_LOGADO + "(" + COLUNA_CODLOGADO + " INTEGER PRIMARY KEY, " + COLUNA_CPFLOGADO + " TEXT)";

        String QUERY_3 = "CREATE TABLE " + TABELA_PRODUTO + "(" + COLUNA_CODPRODUTO + " INTEGER PRIMARY KEY, " + COLUNA_NOMEPRODUTO + " TEXT, " + COLUNA_PRECO
                + " INTEGER , " + COLUNA_QUANTIDADE + " INTEGER, " + COLUNA_CPFPRODUTO + " TEXT, " + COLUNA_FOTO + " BLOB)";

        String QUERY_4 = "CREATE TABLE " + TABELA_EDITAR_PRODUTO + "(" + COLUNA_CODIGO_PRODUTO + " INTEGER, " + COLUNA_NOME_PRODUTO + " TEXT)";

        String QUERY_5 = "CREATE TABLE " + TABELA_SACOLA_PRODUTO + "(" + COLUNA_CODIGO_PRODUTO_SACOLA + " INTEGER, " + COLUNA_NOME_PRODUTO_SACOLA + " TEXT, " + COLUNA_PRECO_SACOLA
                + " INTEGER , " + COLUNA_QUANTIDADE_SACOLA + " INTEGER, " + COLUNA_CPFPRODUTO_SACOLA + " TEXT, " + COLUNA_FOTO_SACOLA + " BLOB)";

        String QUERY_6 = "CREATE TABLE " + TABELA_ENDERECO + "(" + COLUNA_CODIGO_ENDERECO + " INTEGER PRIMARY KEY, " + COLUNA_CEP + " TEXT, " + COLUNA_LOGRADOURO
                + " TEXT, " + COLUNA_BAIRRO + " TEXT, " + COLUNA_COMPLEMENTO + " TEXT, " + COLUNA_CIDADE + " TEXT, " + COLUNA_UF + " TEXT, " + COLUNA_CPF_ENDERECO + " TEXT)";


        db.execSQL(QUERY_1);
        db.execSQL(QUERY_2);
        db.execSQL(QUERY_3);
        db.execSQL(QUERY_4);
        db.execSQL(QUERY_5);
        db.execSQL(QUERY_6);

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

    //selecionar cliente no banco de dados pelo cpf
    Cliente selecionarCLiente(String codigo){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_CLIENTE, new String[] {COLUNA_CODIGO,COLUNA_NOME,COLUNA_TELEFONE,COLUNA_EMAIL,COLUNA_CPF,COLUNA_SENHA},COLUNA_CPF + " = ?",
                new String[] {codigo},null,null,null,null);

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

    void addProduto(Produto produto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOMEPRODUTO,produto.getNome());
        values.put(COLUNA_PRECO,produto.getPreco_unitario());
        values.put(COLUNA_QUANTIDADE,produto.getQuantidade());
        values.put(COLUNA_CPFPRODUTO,produto.getCpf());
        values.put(COLUNA_FOTO,produto.getFoto());
        db.insert(TABELA_PRODUTO,null,values);
        db.close();
    }


    public ArrayList<Produto> listaTodosProdutos(){
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        String query = "SELECT * FROM " + TABELA_PRODUTO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query,null);
        if(c.moveToFirst()){
            do{
                Produto produto = new Produto();
                produto.setCodigo(Integer.parseInt(c.getString(0)));
                produto.setNome(c.getString(1));
                produto.setPreco_unitario(Integer.parseInt(c.getString(2)));
                produto.setQuantidade(Integer.parseInt(c.getString(3)));
                produto.setCpf(c.getString(4));
                produto.setFoto(c.getBlob(5));
                listaProdutos.add(produto);
            }while(c.moveToNext());
        }
        return listaProdutos;
    }


    private String[] toArgs(Cliente aluno) {
        String[] args = {Integer.toString(aluno.getCodigo())};
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

    //alterar clientes dentro do banco de dados
    public void alterar(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = toValues(cliente);
        db.update("tb_clientes", values, "codigo = ?", toArgs(cliente));
    }


    Produto selecionarProduto(String codigo){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_PRODUTO, new String[] {COLUNA_CODPRODUTO,COLUNA_NOMEPRODUTO,COLUNA_PRECO,COLUNA_QUANTIDADE,COLUNA_CPFPRODUTO,COLUNA_FOTO},COLUNA_NOMEPRODUTO + " = ?",
                new String[] {String.valueOf(codigo)},null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        Produto produto = new Produto();

        produto.setCodigo(Integer.parseInt(cursor.getString(0)));
        produto.setNome(cursor.getString(1));
        produto.setPreco_unitario(Integer.parseInt(cursor.getString(2)));
        produto.setQuantidade(Integer.parseInt(cursor.getString(3)));
        produto.setCpf(cursor.getString(4));
        produto.setFoto(cursor.getBlob(5));

        return produto;
    }

    //retornar codigo do produto
    private String[] tooArgs(Produto produto) {
        String[] args = {Integer.toString(produto.getCodigo())};
        return args;
    }

    //retornar o conteudo do produto
    private ContentValues tooValues(Produto produto) {
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("preco", produto.getPreco_unitario());
        values.put("quantidade", produto.getQuantidade());
        values.put("cpf", produto.getCpf());
        values.put("foto",produto.getFoto());
        return values;
    }

    //alterar produto dentro do banco
    public void alterarProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = tooValues(produto);
        db.update("produtos", values, "codigo = ?", tooArgs(produto));
    }


    //excluir produto do banco
    public void deletarProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = tooValues(produto);
        db.delete("produtos","codigo = ?",tooArgs(produto));
    }

    public ArrayList<Produto> listarProdutosdoUsuario(String cpf){
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        String query = "SELECT * FROM " + TABELA_PRODUTO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query,null);
        if(c.moveToFirst()){
            do{
                Produto produto = new Produto();
                produto.setCodigo(Integer.parseInt(c.getString(0)));
                produto.setNome(c.getString(1));
                produto.setPreco_unitario(Integer.parseInt(c.getString(2)));
                produto.setQuantidade(Integer.parseInt(c.getString(3)));
                produto.setCpf(c.getString(4));
                produto.setFoto(c.getBlob(5));
                if(cpf.equals(c.getString(4))){
                    listaProdutos.add(produto);
                }
            }while(c.moveToNext());
        }
        return listaProdutos;
    }

    void addProdutoEditar(testeProduto produto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNA_CODIGO_PRODUTO,produto.getCodigo());
        values.put(COLUNA_NOME_PRODUTO,produto.getNome());
        db.insert(TABELA_EDITAR_PRODUTO,null,values);
        db.close();
    }

    public testeProduto listaTodosProdutosEditaveis(){

        testeProduto h = new testeProduto();
        String query = "SELECT * FROM " + TABELA_EDITAR_PRODUTO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c.moveToFirst()){
            do{

                testeProduto produto = new testeProduto();
                produto.setCodigo(Integer.parseInt(c.getString(0)));
                produto.setNome(c.getString(1));
                h = produto;
            }while(c.moveToNext());

        }
        return h;
    }

    private ContentValues Values(testeProduto produto) {
        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        return values;
    }


    private String[] Args(testeProduto produto) {
        String[] args = {Integer.toString(produto.getCodigo())};
        return args;
    }

    public void deletarProdutoEditar(testeProduto produto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = Values(produto);
        db.delete("produto","codigo = ?",Args(produto));
    }

    void addProdutoSacola(int codigo, String nome,int preco,int quantidade,String cpf,byte[] foto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_CODIGO_PRODUTO_SACOLA,codigo);
        values.put(COLUNA_NOME_PRODUTO_SACOLA,nome);
        values.put(COLUNA_PRECO_SACOLA,preco);
        values.put(COLUNA_QUANTIDADE_SACOLA,quantidade);
        values.put(COLUNA_CPFPRODUTO_SACOLA,cpf);
        values.put(COLUNA_FOTO_SACOLA,foto);

        db.insert(TABELA_SACOLA_PRODUTO,null,values);

        db.close();
    }

    public ArrayList<Produto> listaTodosProdutosSacola(){
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        String query = "SELECT * FROM " + TABELA_SACOLA_PRODUTO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query,null);
        if(c.moveToFirst()){
            do{
                Produto p = new Produto();
                p.setCodigo(Integer.parseInt(c.getString(0)));
                p.setNome((c.getString(1)));
                p.setPreco_unitario(Integer.parseInt(c.getString(2)));
                p.setQuantidade(Integer.parseInt(c.getString(3)));
                p.setCpf((c.getString(4)));
                p.setFoto((c.getBlob(5)));

                listaProdutos.add(p);

            }while(c.moveToNext());
        }
        return listaProdutos;
    }

    public void receberComandoSQL(String sql){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    public void deletarProdutoSacola(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = tooValues(produto);
        db.delete("sacola","codigo = ?",tooArgs(produto));
    }

    void addEndereco(Endereco endereco){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_CEP,endereco.getCep());
        values.put(COLUNA_LOGRADOURO,endereco.getLogradouro());
        values.put(COLUNA_BAIRRO,endereco.getBairro());
        values.put(COLUNA_COMPLEMENTO,endereco.getComplemento());
        values.put(COLUNA_CIDADE,endereco.getCidade());
        values.put(COLUNA_UF,endereco.getEtuf());
        values.put(COLUNA_CPF_ENDERECO,endereco.getCpf());

        db.insert(TABELA_ENDERECO,null,values);
        db.close();
    }

    public ArrayList<Endereco> listaTodosEnderecos(){
        ArrayList<Endereco> listaProdutos = new ArrayList<Endereco>();
        String query = "SELECT * FROM " + TABELA_ENDERECO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query,null);
        if(c.moveToFirst()){
            do{
                Endereco p = new Endereco();
                p.setCodigo(Integer.parseInt(c.getString(0)));
                p.setCep((c.getString(1)));
                p.setLogradouro((c.getString(2)));
                p.setBairro((c.getString(3)));
                p.setComplemento((c.getString(4)));
                p.setCidade((c.getString(5)));
                p.setEtuf((c.getString(6)));
                p.setCpf((c.getString(7)));
                listaProdutos.add(p);

            }while(c.moveToNext());
        }
        return listaProdutos;
    }
}
