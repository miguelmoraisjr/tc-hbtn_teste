public class TesteEmail {

    public static boolean testar_email_com_arroba() {
        boolean check = Pessoa.emailValid("email_teste@dominio.com.br");
        return check;
    }

    public static boolean testar_email_sem_arroba() {
        boolean check = Pessoa.emailValid("email_testedominio.com.br");
        return check;
    }

    public static boolean testar_email_mais_50_caracteres(){
        boolean check = Pessoa.emailValid("email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br");
        return check;
    }
}
