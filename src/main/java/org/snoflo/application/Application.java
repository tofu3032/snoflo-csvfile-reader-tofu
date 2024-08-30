package org.snoflo.application;

import org.snoflo.controller.AppController;

public class Application {

    private AppController appController;
    private static Application instance;

    public Application() {
        this.appController = new AppController();
    }

    public static synchronized Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }
    public void start() {
        showMainDisplay();
        appController.executeFindByAuthor();
    }

    private void showMainDisplay() {
        System.out.println("---------------------------------");
        System.out.println("도서관리 프로그램 시작");
        System.out.println("---------------------------------");
    }

}
