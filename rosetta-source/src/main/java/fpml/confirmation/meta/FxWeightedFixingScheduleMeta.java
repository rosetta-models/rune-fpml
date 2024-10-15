package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.validation.FxWeightedFixingScheduleTypeFormatValidator;
import fpml.confirmation.validation.FxWeightedFixingScheduleValidator;
import fpml.confirmation.validation.exists.FxWeightedFixingScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxWeightedFixingSchedule.class)
public class FxWeightedFixingScheduleMeta implements RosettaMetaData<FxWeightedFixingSchedule> {

	@Override
	public List<Validator<? super FxWeightedFixingSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxWeightedFixingSchedule>create(fpml.confirmation.validation.datarule.FxWeightedFixingScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxWeightedFixingSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxWeightedFixingSchedule> validator() {
		return new FxWeightedFixingScheduleValidator();
	}

	@Override
	public Validator<? super FxWeightedFixingSchedule> typeFormatValidator() {
		return new FxWeightedFixingScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxWeightedFixingSchedule, Set<String>> onlyExistsValidator() {
		return new FxWeightedFixingScheduleOnlyExistsValidator();
	}
}
