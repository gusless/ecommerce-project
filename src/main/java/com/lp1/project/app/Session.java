package com.lp1.project.app;

import com.lp1.project.domain.user.User;

public class Session {
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void login(User user) {
        this.currentUser = user;
    }

    public void logout() {
        this.currentUser = null;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
