package com.restwizard.rest;

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

    }
}
