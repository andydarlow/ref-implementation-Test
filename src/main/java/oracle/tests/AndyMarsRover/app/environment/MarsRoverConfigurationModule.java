package oracle.tests.AndyMarsRover.app.environment;

import java.io.Console;

import com.google.inject.AbstractModule;

import oracle.tests.AndyMarsRover.app.MarsRoverApplication;
import oracle.tests.AndyMarsRover.dao.MarsRoverCommandDAO;
import oracle.tests.AndyMarsRover.dao.characters.StringMarsRoverCommandDAO;
import oracle.tests.AndyMarsRover.ui.ConsoleMarsRoverView;
import oracle.tests.AndyMarsRover.ui.MarsRoverView;

/**
 * Guice DI configuration class. Specifies the implementations for the classes
 */
public class MarsRoverConfigurationModule extends AbstractModule {

	@Override
	protected void configure() {
        bind(MarsRoverCommandDAO.class).toInstance(new StringMarsRoverCommandDAO("RFLFFRF"));
        bind(MarsRoverView.class).to(ConsoleMarsRoverView.class);
        bind(Application.class).to(MarsRoverApplication.class);		
	}


}
