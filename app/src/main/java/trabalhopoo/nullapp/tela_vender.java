package trabalhopoo.nullapp;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.ArrayList;


public class tela_vender extends AppCompatActivity {


    private static final int REQUEST_CODE_PERMISSION = 123;

    EditText editCodigo,editNome,editEmail,editTelefone;
    ListView listViewClientes;

    BancoDados db = new BancoDados(this);

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;


    @Override

    protected void onCreate(@Nullable Bundle savedInstaceState){


        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_vender);

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
                Uri imagemSelecionada = data.getData();
                ImageView image= findViewById(R.id.imageV);
                image.setImageURI(imagemSelecionada);

            }
        }
    }

/*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_PERMISSION:
                if(grantResults[0] ==  PackageManager.PERMISSION_GRANTED){

                    //fazer o necessário
                }else if(grantResults[0] == PackageManager.PERMISSION_DENIED){

                }

                if(grantResults[1] ==  PackageManager.PERMISSION_GRANTED){
                    Log.i("CAMERA PERMISSION", "GRANTED");

                }else if(grantResults[1] == PackageManager.PERMISSION_DENIED){

                }

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestPermissions(){
        String[] perms = { Manifest.permission.READ_CONTACTS , Manifest.permission.CAMERA};
        int hasReadSMSPermission = checkSelfPermission(Manifest.permission.READ_CONTACTS);
        if(hasReadSMSPermission != PackageManager.PERMISSION_GRANTED){
            requestPermissions(perms, REQUEST_CODE_PERMISSION);
            return;
        }

    }*/
}
