package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixingScheduleSequence1;
import fpml.confirmation.validation.FxFixingScheduleSequence1TypeFormatValidator;
import fpml.confirmation.validation.FxFixingScheduleSequence1Validator;
import fpml.confirmation.validation.exists.FxFixingScheduleSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxFixingScheduleSequence1.class)
public class FxFixingScheduleSequence1Meta implements RosettaMetaData<FxFixingScheduleSequence1> {

	@Override
	public List<Validator<? super FxFixingScheduleSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxFixingScheduleSequence1>create(fpml.confirmation.validation.datarule.FxFixingScheduleSequence1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super FxFixingScheduleSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFixingScheduleSequence1> validator() {
		return new FxFixingScheduleSequence1Validator();
	}

	@Override
	public Validator<? super FxFixingScheduleSequence1> typeFormatValidator() {
		return new FxFixingScheduleSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingScheduleSequence1, Set<String>> onlyExistsValidator() {
		return new FxFixingScheduleSequence1OnlyExistsValidator();
	}
}
