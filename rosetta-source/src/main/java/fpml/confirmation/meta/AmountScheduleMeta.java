package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AmountSchedule;
import fpml.confirmation.validation.AmountScheduleTypeFormatValidator;
import fpml.confirmation.validation.AmountScheduleValidator;
import fpml.confirmation.validation.exists.AmountScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AmountSchedule.class)
public class AmountScheduleMeta implements RosettaMetaData<AmountSchedule> {

	@Override
	public List<Validator<? super AmountSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AmountSchedule> validator() {
		return new AmountScheduleValidator();
	}

	@Override
	public Validator<? super AmountSchedule> typeFormatValidator() {
		return new AmountScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountSchedule, Set<String>> onlyExistsValidator() {
		return new AmountScheduleOnlyExistsValidator();
	}
}
