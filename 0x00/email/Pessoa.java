public class Pessoa {

    public static boolean emailValid(String email) {
        if (email.length() <= 50 && email.contains("@")) {
            return true;
        } else {
            return false;
        }
    }
}
