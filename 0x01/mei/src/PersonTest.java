import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonTest {

    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    private Person person;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");


    @BeforeEach
    void setUp() throws Exception {
        name = "Paul";
        surname = "McCartney";
        birthDate = sdf.parse("2000");
        anotherCompanyOwner = true;
        pensioner = true;
        publicServer = true;
        salary = 1200;
        person = new Person(name, surname, birthDate, anotherCompanyOwner, pensioner, publicServer, salary);

    }

    @Test
    public void show_full_name() {
        String nomeCompleto = person.fullName();
        Assertions.assertEquals("Paul McCartney", nomeCompleto);
    }

    @Test
    public void test_calculateYearlySalary() {
        double salarioAnual = person.calculateYearlySalary();
        Assertions.assertEquals(14400, salarioAnual);
    }

    @Test
    public void person_is_MEI() {
        Person personMei = new Person(name, surname, birthDate, false, false, false, salary);
        boolean check = personMei.isMEI();
        Assertions.assertTrue(check);
    }

    @Test
    public void person_is_not_MEI() {
        boolean check = person.isMEI();
        Assertions.assertFalse(check);
    }
}
