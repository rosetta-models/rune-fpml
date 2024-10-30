package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixingSchedule;
import fpml.confirmation.validation.FxFixingScheduleTypeFormatValidator;
import fpml.confirmation.validation.FxFixingScheduleValidator;
import fpml.confirmation.validation.exists.FxFixingScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxFixingSchedule.class)
public class FxFixingScheduleMeta implements RosettaMetaData<FxFixingSchedule> {

	@Override
	public List<Validator<? super FxFixingSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxFixingSchedule>create(fpml.confirmation.validation.datarule.FxFixingScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxFixingSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFixingSchedule> validator() {
		return new FxFixingScheduleValidator();
	}

	@Override
	public Validator<? super FxFixingSchedule> typeFormatValidator() {
		return new FxFixingScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingSchedule, Set<String>> onlyExistsValidator() {
		return new FxFixingScheduleOnlyExistsValidator();
	}
}
