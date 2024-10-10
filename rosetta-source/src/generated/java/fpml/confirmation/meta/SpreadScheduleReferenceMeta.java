package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SpreadScheduleReference;
import fpml.confirmation.validation.SpreadScheduleReferenceTypeFormatValidator;
import fpml.confirmation.validation.SpreadScheduleReferenceValidator;
import fpml.confirmation.validation.exists.SpreadScheduleReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SpreadScheduleReference.class)
public class SpreadScheduleReferenceMeta implements RosettaMetaData<SpreadScheduleReference> {

	@Override
	public List<Validator<? super SpreadScheduleReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpreadScheduleReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SpreadScheduleReference> validator() {
		return new SpreadScheduleReferenceValidator();
	}

	@Override
	public Validator<? super SpreadScheduleReference> typeFormatValidator() {
		return new SpreadScheduleReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpreadScheduleReference, Set<String>> onlyExistsValidator() {
		return new SpreadScheduleReferenceOnlyExistsValidator();
	}
}
