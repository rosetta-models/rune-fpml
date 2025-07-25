package com.regnosys.runefpml;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;
import com.regnosys.rosetta.RosettaStandaloneSetup;
import com.regnosys.testing.RosettaTestingInjectorProvider;
import com.regnosys.testing.RosettaTestingModule;

public class RuneFpmlTestRuntimeModule extends RuneFpmlRuntimeModule {

    @Override
    protected void configure() {
        super.configure();
        install(new RosettaTestingModule());
    }

    public static class InjectorProvider extends RosettaTestingInjectorProvider {
        @Override
        protected Injector internalCreateInjector() {
            return new RosettaStandaloneSetup() {
                @Override
                public Injector createInjector() {
                    return Guice.createInjector(Modules.override(createRuntimeModule()).with(new RuneFpmlTestRuntimeModule()));
                }
            }.createInjectorAndDoEMFRegistration();
        }
    }
}
