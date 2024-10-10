package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ScheduleReference;
import fpml.confirmation.validation.ScheduleReferenceTypeFormatValidator;
import fpml.confirmation.validation.ScheduleReferenceValidator;
import fpml.confirmation.validation.exists.ScheduleReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ScheduleReference.class)
public class ScheduleReferenceMeta implements RosettaMetaData<ScheduleReference> {

	@Override
	public List<Validator<? super ScheduleReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ScheduleReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ScheduleReference> validator() {
		return new ScheduleReferenceValidator();
	}

	@Override
	public Validator<? super ScheduleReference> typeFormatValidator() {
		return new ScheduleReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ScheduleReference, Set<String>> onlyExistsValidator() {
		return new ScheduleReferenceOnlyExistsValidator();
	}
}
