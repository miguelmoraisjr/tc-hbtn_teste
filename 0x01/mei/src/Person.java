import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(){
    }

    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer, float salary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
        this.salary = salary;
    }

    public String fullName(){
        return name + " " + surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public double calculateYearlySalary() {
        return salary * 12;
    }

    public boolean isMEI() {
        if ((calculateYearlySalary() < 130000 == true) && (maior18() == true) &&
                anotherCompanyOwner == false && pensioner == false && publicServer == false) {
            return true;
        } else {
            return false;
        }
    }

    public boolean maior18() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int anoAtual = cal.get(Calendar.YEAR);
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(birthDate);
        int anoNascimento = cal.get(Calendar.YEAR);
        int idade = anoAtual - anoNascimento;
        if (idade > 18 ) {
            return true;
        } else {
            return false;
        }
    }
}
