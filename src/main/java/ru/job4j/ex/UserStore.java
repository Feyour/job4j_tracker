package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        String result = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                return users[i];
            }
        }
        throw new UserNotFoundException("User with login " + login + " not found.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() && user.getUsername().length() <= 3) {
            throw new UserInvalidException("User with name" + user.getUsername() + " not found.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };

        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ea) {
            ea.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}