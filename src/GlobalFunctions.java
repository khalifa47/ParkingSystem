import javax.swing.*;

public class GlobalFunctions {
    boolean passwordNotValid(JPasswordField passField) {
        String pass = String.valueOf(passField.getPassword());
        int pass_length = pass.length();
        boolean hasNum = false;

        char[] chars = pass.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c))
                hasNum = true;
        }

        return (pass_length < 8 || !hasNum);
    }

    boolean emailNotValid(JTextField textField) {
        String s = textField.getText();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '@') {
                return false;
            }
        }
        return true;
    }

    boolean passMatching(JPasswordField passwordField1, JPasswordField passwordField2) {
        String pass1 = String.valueOf(passwordField1.getPassword());
        String pass2 = String.valueOf(passwordField2.getPassword());

        return pass1.equals(pass2);
    }

//    boolean isIDInvalid(JTextField input) {
//        try {
//            int test = Integer.parseInt(input.getText());
//            return (getLength(test) != 8);
//
//        } catch (NumberFormatException e) {
//            return true;
//        }
//    }
//    int getLength(int test) {
//        String s = Integer.toString(test);
//        return s.length();
//    }
}
