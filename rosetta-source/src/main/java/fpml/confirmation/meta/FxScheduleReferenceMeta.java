package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxScheduleReference;
import fpml.confirmation.validation.FxScheduleReferenceTypeFormatValidator;
import fpml.confirmation.validation.FxScheduleReferenceValidator;
import fpml.confirmation.validation.exists.FxScheduleReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxScheduleReference.class)
public class FxScheduleReferenceMeta implements RosettaMetaData<FxScheduleReference> {

	@Override
	public List<Validator<? super FxScheduleReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxScheduleReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxScheduleReference> validator() {
		return new FxScheduleReferenceValidator();
	}

	@Override
	public Validator<? super FxScheduleReference> typeFormatValidator() {
		return new FxScheduleReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxScheduleReference, Set<String>> onlyExistsValidator() {
		return new FxScheduleReferenceOnlyExistsValidator();
	}
}
