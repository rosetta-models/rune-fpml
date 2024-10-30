package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StrikeSchedule;
import fpml.confirmation.validation.StrikeScheduleTypeFormatValidator;
import fpml.confirmation.validation.StrikeScheduleValidator;
import fpml.confirmation.validation.exists.StrikeScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=StrikeSchedule.class)
public class StrikeScheduleMeta implements RosettaMetaData<StrikeSchedule> {

	@Override
	public List<Validator<? super StrikeSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StrikeSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StrikeSchedule> validator() {
		return new StrikeScheduleValidator();
	}

	@Override
	public Validator<? super StrikeSchedule> typeFormatValidator() {
		return new StrikeScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrikeSchedule, Set<String>> onlyExistsValidator() {
		return new StrikeScheduleOnlyExistsValidator();
	}
}
