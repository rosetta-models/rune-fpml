package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RelevantUnderlyingDateReference;
import fpml.confirmation.validation.RelevantUnderlyingDateReferenceTypeFormatValidator;
import fpml.confirmation.validation.RelevantUnderlyingDateReferenceValidator;
import fpml.confirmation.validation.exists.RelevantUnderlyingDateReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RelevantUnderlyingDateReference.class)
public class RelevantUnderlyingDateReferenceMeta implements RosettaMetaData<RelevantUnderlyingDateReference> {

	@Override
	public List<Validator<? super RelevantUnderlyingDateReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelevantUnderlyingDateReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RelevantUnderlyingDateReference> validator() {
		return new RelevantUnderlyingDateReferenceValidator();
	}

	@Override
	public Validator<? super RelevantUnderlyingDateReference> typeFormatValidator() {
		return new RelevantUnderlyingDateReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelevantUnderlyingDateReference, Set<String>> onlyExistsValidator() {
		return new RelevantUnderlyingDateReferenceOnlyExistsValidator();
	}
}
