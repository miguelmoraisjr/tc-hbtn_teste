import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteEmail {

    private String emailComArroba;
    private String emailSemArroba;
    private String emailComMais50Caracteres;

    @BeforeEach
    void setUp() throws Exception {
        emailComArroba = "email_teste@dominio.com.br";
        emailSemArroba = "email_testedominio.com.br";
        emailComMais50Caracteres = "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br";
    }

    @Test
    public void testar_email_com_arroba() {
        boolean check = Pessoa.emailValid(emailComArroba);
        Assertions.assertTrue(check);
    }

    @Test
    public void testar_email_sem_arroba() {
        boolean check = Pessoa.emailValid(emailSemArroba);
        Assertions.assertFalse(check);
    }

    @Test
    public void testar_email_mais_50_caracteres() {
        boolean check = Pessoa.emailValid(emailComMais50Caracteres);
        Assertions.assertEquals(false, check);
    }
}
