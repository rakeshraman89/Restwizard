package com.restwizard;

import com.restwizard.resources.EmployeeRestController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends Application<Configuration> {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run (Configuration c, Environment e) throws Exception{
        LOG.info("starting to run.....");
        e.jersey().register(new EmployeeRestController(e.getValidator()));
    }

    public static void main (String []args) throws Exception {
        new App().run(args);
    }
}
