package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSchedule;
import fpml.confirmation.validation.FxScheduleTypeFormatValidator;
import fpml.confirmation.validation.FxScheduleValidator;
import fpml.confirmation.validation.exists.FxScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxSchedule.class)
public class FxScheduleMeta implements RosettaMetaData<FxSchedule> {

	@Override
	public List<Validator<? super FxSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxSchedule>create(fpml.confirmation.validation.datarule.FxScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSchedule> validator() {
		return new FxScheduleValidator();
	}

	@Override
	public Validator<? super FxSchedule> typeFormatValidator() {
		return new FxScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSchedule, Set<String>> onlyExistsValidator() {
		return new FxScheduleOnlyExistsValidator();
	}
}
