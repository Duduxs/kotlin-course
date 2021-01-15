package main.kotlin.repository.userRepository;

import main.kotlin.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class userRepository {

    private static userRepository INSTANCE = null;

    private List<User> users = null;

    public static userRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (userRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new userRepository();
                }
            }
        }
        return INSTANCE;
    }

    // keeping the constructor private to enforce the usage of getInstance
    private userRepository() {

        User user1 = new User("Jane", "");
        User user2 = new User("John", null);
        User user3 = new User("Anne", "Doe");

        users = new ArrayList();
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getFormattedUserNames() {
        List<String> userNames = new ArrayList<>(users.size());
        for (User user : users) {
            String name;

            if (user.getLastName() != null) {
                if (user.getFirstName() != null) {
                    name = user.getFirstName() + " " + user.getLastName();
                } else {
                    name = user.getLastName();
                }
            } else if (user.getFirstName() != null) {
                name = user.getFirstName();
            } else {
                name = "Unknown";
            }
            userNames.add(name);
        }
        return userNames;
    }
}
