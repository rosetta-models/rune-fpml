package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValuationScenario;
import fpml.confirmation.validation.ValuationScenarioTypeFormatValidator;
import fpml.confirmation.validation.ValuationScenarioValidator;
import fpml.confirmation.validation.exists.ValuationScenarioOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ValuationScenario.class)
public class ValuationScenarioMeta implements RosettaMetaData<ValuationScenario> {

	@Override
	public List<Validator<? super ValuationScenario>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationScenario, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ValuationScenario> validator() {
		return new ValuationScenarioValidator();
	}

	@Override
	public Validator<? super ValuationScenario> typeFormatValidator() {
		return new ValuationScenarioTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationScenario, Set<String>> onlyExistsValidator() {
		return new ValuationScenarioOnlyExistsValidator();
	}
}
