package trabalhopoo.nullapp;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class tela_vender extends AppCompatActivity {

    private Uri imagemSelecionada;
    private static final int REQUEST_CODE_PERMISSION = 123;

    EditText editNome,editQnt,editPreco;


    BancoDados db = new BancoDados(this);

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;



    @Override

    protected void onCreate(@Nullable Bundle savedInstaceState){

        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_vender);
        editNome = findViewById(R.id.NomeProduto);
        editQnt = findViewById(R.id.Qnt);
        editPreco = findViewById(R.id.Preco);

    }

//    @Override
    public void pegaFoto(View v){
//        requestPermissions();

        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), 123);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 123){
                imagemSelecionada = data.getData();



                ImageView image= findViewById(R.id.imageV);
                image.setImageURI(imagemSelecionada);
            }
        }
    }

    public void cadastrar(View v){
        try {
            //transformando de uri para bitmap
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imagemSelecionada);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
            byte imagemBytes[] = stream.toByteArray();

            ClienteLogado t = db.listaTodosClientesLogados();

            Produto p = new Produto(editNome.getText().toString(), Integer.parseInt(editQnt.getText().toString()),  Integer.parseInt(editPreco.getText().toString()),t.getCpf() , imagemBytes);
            db.addProduto(p);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void editarProdutos(View view){
        startActivity(new Intent(getBaseContext(),tela_editar_produtos.class));
    }


}
