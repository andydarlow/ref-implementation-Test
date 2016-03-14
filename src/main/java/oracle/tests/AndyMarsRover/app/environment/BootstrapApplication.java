package oracle.tests.AndyMarsRover.app.environment;

import com.google.inject.Guice;
import com.google.inject.Injector;

import oracle.tests.AndyMarsRover.app.MarsRoverApplication;
/**
 * Entry point for the app. Just gets Guide DI to 
 * kick in and runs the app. Everying setup in the config Module
 */
public class BootstrapApplication {

    public static void main(String[] args) {
        Injector diEnvironent = Guice.createInjector(new MarsRoverConfigurationModule()); 
        diEnvironent.getInstance(Application.class).run(); 
    }

}
