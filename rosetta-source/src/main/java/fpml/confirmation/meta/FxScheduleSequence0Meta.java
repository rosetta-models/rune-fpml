package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxScheduleSequence0;
import fpml.confirmation.validation.FxScheduleSequence0TypeFormatValidator;
import fpml.confirmation.validation.FxScheduleSequence0Validator;
import fpml.confirmation.validation.exists.FxScheduleSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxScheduleSequence0.class)
public class FxScheduleSequence0Meta implements RosettaMetaData<FxScheduleSequence0> {

	@Override
	public List<Validator<? super FxScheduleSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxScheduleSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxScheduleSequence0> validator() {
		return new FxScheduleSequence0Validator();
	}

	@Override
	public Validator<? super FxScheduleSequence0> typeFormatValidator() {
		return new FxScheduleSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxScheduleSequence0, Set<String>> onlyExistsValidator() {
		return new FxScheduleSequence0OnlyExistsValidator();
	}
}
