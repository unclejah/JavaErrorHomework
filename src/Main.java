import java.util.regex.Pattern;

public class Main {
    private static final Pattern pattern = Pattern.compile("[a-zA-Z0-9_]*");

    public static void main(String[] args) {

        System.out.println(checkEnter("login", "password", "pass"));

    }

    public static Boolean checkEnter(String login, String password, String confirmPassowrd) {
        Boolean check = true;
        try {
            if (login == null || login.isEmpty() || login.length() > 20) {
                throw new WrongLoginException("Не допустивая длина логина");
            } else if (!login.matches(pattern.pattern())) {
                throw new WrongLoginException("Логин содержит не корректные символы");
            }
            if (password == null || password.isEmpty() || password.length() >= 20) {
                throw new WrongLoginException("Не допустивая длина пароля");
            } else if (!password.matches(pattern.pattern())) {
                throw new WrongPasswordException("Пароль содержит не корректные символы");
            }
            if (confirmPassowrd == null || confirmPassowrd.isEmpty() || confirmPassowrd.length() >= 20) {
                throw new WrongLoginException("Не допустивая длина подтверждения пароля");
            } else if (!password.matches(pattern.pattern())) {
                throw new WrongPasswordException("Подтверждение пароля содержит не корректные символы");
            }
            if (!password.equals(confirmPassowrd)) {
                throw new WrongPasswordException("Пароли не одинаковые");
            }
        } catch (WrongLoginException e) {
            check = false;
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            check = false;
            System.out.println(e.getMessage());
        } finally {
            return check;
        }
    }
}