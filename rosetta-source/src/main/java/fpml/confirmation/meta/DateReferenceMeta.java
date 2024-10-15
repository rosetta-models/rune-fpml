package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DateReference;
import fpml.confirmation.validation.DateReferenceTypeFormatValidator;
import fpml.confirmation.validation.DateReferenceValidator;
import fpml.confirmation.validation.exists.DateReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DateReference.class)
public class DateReferenceMeta implements RosettaMetaData<DateReference> {

	@Override
	public List<Validator<? super DateReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DateReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DateReference> validator() {
		return new DateReferenceValidator();
	}

	@Override
	public Validator<? super DateReference> typeFormatValidator() {
		return new DateReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DateReference, Set<String>> onlyExistsValidator() {
		return new DateReferenceOnlyExistsValidator();
	}
}
