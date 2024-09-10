package org.snoflo;

import org.snoflo.application.Application;
import org.snoflo.controller.AppController;

public class App {
    
    public static void main(String[] args) {
        Application application = Application.getInstance(new AppController());
        application.start();

    }
}
