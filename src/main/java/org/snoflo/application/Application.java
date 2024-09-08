package org.snoflo.application;

import org.snoflo.controller.AppController;

public class Application {

    private AppController appController;
    private static Application instance;

    private Application(AppController appController) {
        this.appController = appController;
    }

    public static synchronized Application getInstance(AppController appController) {
        if (instance == null) {
            instance = new Application(appController);
        }
        return instance;
    }

    public void start() {
        appController.executeMainMenu();
    }


}
