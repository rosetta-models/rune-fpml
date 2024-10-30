package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonNegativeSchedule;
import fpml.confirmation.validation.NonNegativeScheduleTypeFormatValidator;
import fpml.confirmation.validation.NonNegativeScheduleValidator;
import fpml.confirmation.validation.exists.NonNegativeScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NonNegativeSchedule.class)
public class NonNegativeScheduleMeta implements RosettaMetaData<NonNegativeSchedule> {

	@Override
	public List<Validator<? super NonNegativeSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativeSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonNegativeSchedule> validator() {
		return new NonNegativeScheduleValidator();
	}

	@Override
	public Validator<? super NonNegativeSchedule> typeFormatValidator() {
		return new NonNegativeScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeSchedule, Set<String>> onlyExistsValidator() {
		return new NonNegativeScheduleOnlyExistsValidator();
	}
}
