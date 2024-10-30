package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixingScheduleSequence0;
import fpml.confirmation.validation.FxFixingScheduleSequence0TypeFormatValidator;
import fpml.confirmation.validation.FxFixingScheduleSequence0Validator;
import fpml.confirmation.validation.exists.FxFixingScheduleSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxFixingScheduleSequence0.class)
public class FxFixingScheduleSequence0Meta implements RosettaMetaData<FxFixingScheduleSequence0> {

	@Override
	public List<Validator<? super FxFixingScheduleSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFixingScheduleSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFixingScheduleSequence0> validator() {
		return new FxFixingScheduleSequence0Validator();
	}

	@Override
	public Validator<? super FxFixingScheduleSequence0> typeFormatValidator() {
		return new FxFixingScheduleSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingScheduleSequence0, Set<String>> onlyExistsValidator() {
		return new FxFixingScheduleSequence0OnlyExistsValidator();
	}
}
