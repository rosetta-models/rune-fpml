package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DerivativeCalculationMethod;
import fpml.confirmation.validation.DerivativeCalculationMethodTypeFormatValidator;
import fpml.confirmation.validation.DerivativeCalculationMethodValidator;
import fpml.confirmation.validation.exists.DerivativeCalculationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeCalculationMethod.class)
public class DerivativeCalculationMethodMeta implements RosettaMetaData<DerivativeCalculationMethod> {

	@Override
	public List<Validator<? super DerivativeCalculationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeCalculationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DerivativeCalculationMethod> validator() {
		return new DerivativeCalculationMethodValidator();
	}

	@Override
	public Validator<? super DerivativeCalculationMethod> typeFormatValidator() {
		return new DerivativeCalculationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeCalculationMethod, Set<String>> onlyExistsValidator() {
		return new DerivativeCalculationMethodOnlyExistsValidator();
	}
}
