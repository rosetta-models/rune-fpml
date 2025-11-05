package com.regnosys.runefpml;

import com.google.inject.AbstractModule;
import com.rosetta.model.lib.ModuleConfig;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.validation.ValidatorFactory;

@ModuleConfig(model = "RUNE-FPML", type = "Rosetta")
public class RuneFpmlRuntimeModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(QualifyFunctionFactory.class).to(bindQualifyFunctionFactory());
        bind(ValidatorFactory.class).to(bindValidatorFactory());
    }

    protected Class<? extends QualifyFunctionFactory> bindQualifyFunctionFactory() {
        return QualifyFunctionFactory.Default.class;
    }

    protected Class<? extends ValidatorFactory> bindValidatorFactory() {
        return ValidatorFactory.Default.class;
    }
}
