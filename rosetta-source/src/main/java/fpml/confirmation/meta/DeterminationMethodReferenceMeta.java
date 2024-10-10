package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeterminationMethodReference;
import fpml.confirmation.validation.DeterminationMethodReferenceTypeFormatValidator;
import fpml.confirmation.validation.DeterminationMethodReferenceValidator;
import fpml.confirmation.validation.exists.DeterminationMethodReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DeterminationMethodReference.class)
public class DeterminationMethodReferenceMeta implements RosettaMetaData<DeterminationMethodReference> {

	@Override
	public List<Validator<? super DeterminationMethodReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeterminationMethodReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DeterminationMethodReference> validator() {
		return new DeterminationMethodReferenceValidator();
	}

	@Override
	public Validator<? super DeterminationMethodReference> typeFormatValidator() {
		return new DeterminationMethodReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeterminationMethodReference, Set<String>> onlyExistsValidator() {
		return new DeterminationMethodReferenceOnlyExistsValidator();
	}
}
