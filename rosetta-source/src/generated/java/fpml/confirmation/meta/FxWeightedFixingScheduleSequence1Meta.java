package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxWeightedFixingScheduleSequence1;
import fpml.confirmation.validation.FxWeightedFixingScheduleSequence1TypeFormatValidator;
import fpml.confirmation.validation.FxWeightedFixingScheduleSequence1Validator;
import fpml.confirmation.validation.exists.FxWeightedFixingScheduleSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxWeightedFixingScheduleSequence1.class)
public class FxWeightedFixingScheduleSequence1Meta implements RosettaMetaData<FxWeightedFixingScheduleSequence1> {

	@Override
	public List<Validator<? super FxWeightedFixingScheduleSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxWeightedFixingScheduleSequence1>create(fpml.confirmation.validation.datarule.FxWeightedFixingScheduleSequence1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super FxWeightedFixingScheduleSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxWeightedFixingScheduleSequence1> validator() {
		return new FxWeightedFixingScheduleSequence1Validator();
	}

	@Override
	public Validator<? super FxWeightedFixingScheduleSequence1> typeFormatValidator() {
		return new FxWeightedFixingScheduleSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxWeightedFixingScheduleSequence1, Set<String>> onlyExistsValidator() {
		return new FxWeightedFixingScheduleSequence1OnlyExistsValidator();
	}
}
