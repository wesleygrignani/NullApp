package Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressaoRegular {

    final String regexEmail = "\\S+@\\S+\\.\\S+";
    final String regexCPF = "\\d{3}[.]*\\d{3}[.]*\\d{3}[-]*\\d{2}";
    final String regexTel = "^\\(*[1-9]{2}\\)* *(?:[2-8]|9[1-9])[0-9]{3}\\-*[0-9]{4}$";
    final String regexNome= "^([a-zA-Z ]{3,})+$";
    final String regexSenha= "^(?=.*[A-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$!#%&*/+@]*)\\S{6,}$";
    final String regexNumeroCartao= "\\d{16}";
    final String regexCodCartao= "\\d{3}";
    final String regexDataCartao = "\\d{2}\\/\\d{2}";

    public boolean verificaEmail(String email) {
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean verificaCpf(String cpf) {
        Pattern pattern = Pattern.compile(regexCPF);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.find();
    }

    public boolean verificaTelefone(String tel) {
        Pattern pattern = Pattern.compile(regexTel);
        Matcher matcher = pattern.matcher(tel);
        return matcher.find();
    }
    public boolean verificaNome(String nome) {
        Pattern pattern = Pattern.compile(regexNome);
        Matcher matcher = pattern.matcher(nome);
        return matcher.find();
    }
    public boolean verificaSenha(String senha) {
        Pattern pattern = Pattern.compile(regexSenha);
        Matcher matcher = pattern.matcher(senha);
        return matcher.find();
    }
    public  boolean verificanumeroCartao(String cartao){
        Pattern pattern = Pattern.compile(regexNumeroCartao);
        Matcher matcher = pattern.matcher(cartao);
        return matcher.find();
    }

    public  boolean verificaCodCartao(String codcartao){
        Pattern pattern = Pattern.compile(regexCodCartao);
        Matcher matcher = pattern.matcher(codcartao);
        return matcher.find();
    }

    public  boolean verificaDataCartao(String datacartao){
        Pattern pattern = Pattern.compile(regexDataCartao);
        Matcher matcher = pattern.matcher(datacartao);
        return matcher.find();
    }

}