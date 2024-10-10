package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.validation.DeterminationMethodTypeFormatValidator;
import fpml.confirmation.validation.DeterminationMethodValidator;
import fpml.confirmation.validation.exists.DeterminationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DeterminationMethod.class)
public class DeterminationMethodMeta implements RosettaMetaData<DeterminationMethod> {

	@Override
	public List<Validator<? super DeterminationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeterminationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DeterminationMethod> validator() {
		return new DeterminationMethodValidator();
	}

	@Override
	public Validator<? super DeterminationMethod> typeFormatValidator() {
		return new DeterminationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeterminationMethod, Set<String>> onlyExistsValidator() {
		return new DeterminationMethodOnlyExistsValidator();
	}
}
