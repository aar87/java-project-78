package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Application is ready");

        var validator = new Validator();
        var schema = validator.string();

        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));
    }
}