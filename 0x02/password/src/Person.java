import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String nome;
    private String senha;

    public Person(){
    }

    public Person(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean checkUser() {
        String REGEX = "((?!.*[@#$%^&-+=()]).{8,100}$)";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }

    public boolean checkPassword() {
        String REGEX = "((?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,100}$)";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }



}
