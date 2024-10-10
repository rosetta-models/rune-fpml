package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExerciseFeeSchedule;
import fpml.confirmation.validation.ExerciseFeeScheduleTypeFormatValidator;
import fpml.confirmation.validation.ExerciseFeeScheduleValidator;
import fpml.confirmation.validation.exists.ExerciseFeeScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExerciseFeeSchedule.class)
public class ExerciseFeeScheduleMeta implements RosettaMetaData<ExerciseFeeSchedule> {

	@Override
	public List<Validator<? super ExerciseFeeSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExerciseFeeSchedule>create(fpml.confirmation.validation.datarule.ExerciseFeeScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExerciseFeeSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExerciseFeeSchedule> validator() {
		return new ExerciseFeeScheduleValidator();
	}

	@Override
	public Validator<? super ExerciseFeeSchedule> typeFormatValidator() {
		return new ExerciseFeeScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseFeeSchedule, Set<String>> onlyExistsValidator() {
		return new ExerciseFeeScheduleOnlyExistsValidator();
	}
}
