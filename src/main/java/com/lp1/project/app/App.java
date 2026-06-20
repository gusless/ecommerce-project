package com.lp1.project.app;

import com.lp1.project.app.screens.MainMenuScreen;
import com.lp1.project.domain.repository.UserRepository;
import com.lp1.project.domain.user.UserService;

import java.util.Scanner;

public class App {
    public static final Scanner SCANNER = new Scanner(System.in);

    private static final Session session = new Session();

    private static final UserRepository userRepository = new UserRepository();
    private static final UserService userService = new UserService(userRepository);

    public static UserService getUserService() {
        return userService;
    }

    public static Session getSession() {
        return session;
    }

    public static void run() {
        MainMenuScreen.show();
    }


}
