package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxWeightedFixingScheduleSequence0;
import fpml.confirmation.validation.FxWeightedFixingScheduleSequence0TypeFormatValidator;
import fpml.confirmation.validation.FxWeightedFixingScheduleSequence0Validator;
import fpml.confirmation.validation.exists.FxWeightedFixingScheduleSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxWeightedFixingScheduleSequence0.class)
public class FxWeightedFixingScheduleSequence0Meta implements RosettaMetaData<FxWeightedFixingScheduleSequence0> {

	@Override
	public List<Validator<? super FxWeightedFixingScheduleSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxWeightedFixingScheduleSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxWeightedFixingScheduleSequence0> validator() {
		return new FxWeightedFixingScheduleSequence0Validator();
	}

	@Override
	public Validator<? super FxWeightedFixingScheduleSequence0> typeFormatValidator() {
		return new FxWeightedFixingScheduleSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxWeightedFixingScheduleSequence0, Set<String>> onlyExistsValidator() {
		return new FxWeightedFixingScheduleSequence0OnlyExistsValidator();
	}
}
