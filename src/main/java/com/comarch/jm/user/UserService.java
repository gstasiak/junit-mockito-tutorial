package com.comarch.jm.user;

import org.joda.time.Interval;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public String generateLogin(User user) {
        if (user.getFirstName() == null) {
            throw new FirstNameCannotBeNullException();
        }
        return user.getLastName().toUpperCase() + "-" + user.getFirstName().toUpperCase();
    }

    public Interval getActivityInterval(User user) {
        return new Interval(user.getActiveFrom().getTime(), user.getActiveTo().getTime());
    }

}
