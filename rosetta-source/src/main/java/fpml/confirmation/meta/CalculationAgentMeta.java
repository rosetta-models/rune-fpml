package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.validation.CalculationAgentTypeFormatValidator;
import fpml.confirmation.validation.CalculationAgentValidator;
import fpml.confirmation.validation.exists.CalculationAgentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculationAgent.class)
public class CalculationAgentMeta implements RosettaMetaData<CalculationAgent> {

	@Override
	public List<Validator<? super CalculationAgent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationAgent>create(fpml.confirmation.validation.datarule.CalculationAgentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationAgent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationAgent> validator() {
		return new CalculationAgentValidator();
	}

	@Override
	public Validator<? super CalculationAgent> typeFormatValidator() {
		return new CalculationAgentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAgent, Set<String>> onlyExistsValidator() {
		return new CalculationAgentOnlyExistsValidator();
	}
}
