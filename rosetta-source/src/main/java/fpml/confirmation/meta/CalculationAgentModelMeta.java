package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationAgentModel;
import fpml.confirmation.validation.CalculationAgentModelTypeFormatValidator;
import fpml.confirmation.validation.CalculationAgentModelValidator;
import fpml.confirmation.validation.exists.CalculationAgentModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculationAgentModel.class)
public class CalculationAgentModelMeta implements RosettaMetaData<CalculationAgentModel> {

	@Override
	public List<Validator<? super CalculationAgentModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationAgentModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationAgentModel> validator() {
		return new CalculationAgentModelValidator();
	}

	@Override
	public Validator<? super CalculationAgentModel> typeFormatValidator() {
		return new CalculationAgentModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAgentModel, Set<String>> onlyExistsValidator() {
		return new CalculationAgentModelOnlyExistsValidator();
	}
}
