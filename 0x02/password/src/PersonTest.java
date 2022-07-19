import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonTest {

    private String nome;
    private String senha;
    private Person person;

    @BeforeEach
    void setUp() throws Exception {
        person = new Person("Charles", "!1234J");
    }

    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(ArgumentsAccessor argumentsAccessor) {
        person.setNome(argumentsAccessor.getString(0));
        boolean check = person.checkUser();
        Assertions.assertTrue(check);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(ArgumentsAccessor argumentsAccessor) {
        person.setNome(argumentsAccessor.getString(0));
        boolean check = person.checkUser();
        Assertions.assertFalse(check);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(ArgumentsAccessor argumentsAccessor) {
        person.setSenha(argumentsAccessor.getString(0));
        boolean check = person.checkPassword();
        Assertions.assertFalse(check);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(ArgumentsAccessor argumentsAccessor) {
        person.setSenha(argumentsAccessor.getString(0));
        boolean check = person.checkPassword();
        Assertions.assertFalse(check);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(ArgumentsAccessor argumentsAccessor) {
        person.setSenha(argumentsAccessor.getString(0));
        boolean check = person.checkPassword();
        Assertions.assertFalse(check);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(ArgumentsAccessor argumentsAccessor) {
        person.setSenha(argumentsAccessor.getString(0));
        boolean check = person.checkPassword();
        Assertions.assertTrue(check);
    }

}
