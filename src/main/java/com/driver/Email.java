package com.driver;

public class Email {

    private final String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        //Change password only if the oldPassword is equal to current password and the new password meets all the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if (!oldPassword.equals(getPassword()) || newPassword.length() < 8)
            return;

        int count_upper = 0, count_lower = 0, count_digit = 0, count_special = 0;

        for (int i = 0; i < newPassword.length() && (count_upper < 1 || count_lower < 1 || count_digit < 1 || count_special < 1); ++i) {
            char ch = newPassword.charAt(i);

            if (ch >= 'A' && ch <= 'Z')
                ++count_upper;
            else if (ch >= 'a' && ch <= 'z')
                ++count_lower;
            else if (ch >= '0' && ch <= '9')
                ++count_digit;
            else
                ++count_special;
        }

        if (count_upper == 0 || count_lower == 0 || count_digit == 0 || count_special == 0)
            return;

        password = newPassword;
    }
}