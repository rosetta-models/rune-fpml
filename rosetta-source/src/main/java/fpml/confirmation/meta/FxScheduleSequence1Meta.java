package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxScheduleSequence1;
import fpml.confirmation.validation.FxScheduleSequence1TypeFormatValidator;
import fpml.confirmation.validation.FxScheduleSequence1Validator;
import fpml.confirmation.validation.exists.FxScheduleSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxScheduleSequence1.class)
public class FxScheduleSequence1Meta implements RosettaMetaData<FxScheduleSequence1> {

	@Override
	public List<Validator<? super FxScheduleSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxScheduleSequence1>create(fpml.confirmation.validation.datarule.FxScheduleSequence1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super FxScheduleSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxScheduleSequence1> validator() {
		return new FxScheduleSequence1Validator();
	}

	@Override
	public Validator<? super FxScheduleSequence1> typeFormatValidator() {
		return new FxScheduleSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxScheduleSequence1, Set<String>> onlyExistsValidator() {
		return new FxScheduleSequence1OnlyExistsValidator();
	}
}
