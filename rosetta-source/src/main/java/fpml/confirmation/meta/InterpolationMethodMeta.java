package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterpolationMethod;
import fpml.confirmation.validation.InterpolationMethodTypeFormatValidator;
import fpml.confirmation.validation.InterpolationMethodValidator;
import fpml.confirmation.validation.exists.InterpolationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterpolationMethod.class)
public class InterpolationMethodMeta implements RosettaMetaData<InterpolationMethod> {

	@Override
	public List<Validator<? super InterpolationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterpolationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterpolationMethod> validator() {
		return new InterpolationMethodValidator();
	}

	@Override
	public Validator<? super InterpolationMethod> typeFormatValidator() {
		return new InterpolationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterpolationMethod, Set<String>> onlyExistsValidator() {
		return new InterpolationMethodOnlyExistsValidator();
	}
}
