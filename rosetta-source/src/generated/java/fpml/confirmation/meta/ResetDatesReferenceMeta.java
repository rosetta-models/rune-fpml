package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ResetDatesReference;
import fpml.confirmation.validation.ResetDatesReferenceTypeFormatValidator;
import fpml.confirmation.validation.ResetDatesReferenceValidator;
import fpml.confirmation.validation.exists.ResetDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ResetDatesReference.class)
public class ResetDatesReferenceMeta implements RosettaMetaData<ResetDatesReference> {

	@Override
	public List<Validator<? super ResetDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ResetDatesReference> validator() {
		return new ResetDatesReferenceValidator();
	}

	@Override
	public Validator<? super ResetDatesReference> typeFormatValidator() {
		return new ResetDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetDatesReference, Set<String>> onlyExistsValidator() {
		return new ResetDatesReferenceOnlyExistsValidator();
	}
}
