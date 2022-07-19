import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {


    private static Person person;


    @BeforeAll
    static void setUp() throws Exception {
        person = new Person("Charles", "!1234J");
    }

    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String nome) {
        person.setNome(nome);
        boolean check = person.checkUser();
        Assertions.assertTrue(check);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String nome) {
        person.setNome(nome);
        boolean check = person.checkUser();
        Assertions.assertFalse(check);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String senha) {
        person.setSenha(senha);
        boolean check = person.checkPassword();
        Assertions.assertFalse(check);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String senha) {
        person.setSenha(senha);
        boolean check = person.checkPassword();
        Assertions.assertFalse(check);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String senha) {
        person.setSenha(senha);
        boolean check = person.checkPassword();
        Assertions.assertFalse(check);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String senha) {
        person.setSenha(senha);
        boolean check = person.checkPassword();
        Assertions.assertTrue(check);
    }

}
