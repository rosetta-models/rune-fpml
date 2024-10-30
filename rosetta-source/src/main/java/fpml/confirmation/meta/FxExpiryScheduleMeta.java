package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxExpirySchedule;
import fpml.confirmation.validation.FxExpiryScheduleTypeFormatValidator;
import fpml.confirmation.validation.FxExpiryScheduleValidator;
import fpml.confirmation.validation.exists.FxExpiryScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxExpirySchedule.class)
public class FxExpiryScheduleMeta implements RosettaMetaData<FxExpirySchedule> {

	@Override
	public List<Validator<? super FxExpirySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxSchedule>create(fpml.confirmation.validation.datarule.FxScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxExpirySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxExpirySchedule> validator() {
		return new FxExpiryScheduleValidator();
	}

	@Override
	public Validator<? super FxExpirySchedule> typeFormatValidator() {
		return new FxExpiryScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxExpirySchedule, Set<String>> onlyExistsValidator() {
		return new FxExpiryScheduleOnlyExistsValidator();
	}
}
