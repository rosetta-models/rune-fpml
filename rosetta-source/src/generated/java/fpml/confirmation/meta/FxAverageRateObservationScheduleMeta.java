package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAverageRateObservationSchedule;
import fpml.confirmation.validation.FxAverageRateObservationScheduleTypeFormatValidator;
import fpml.confirmation.validation.FxAverageRateObservationScheduleValidator;
import fpml.confirmation.validation.exists.FxAverageRateObservationScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAverageRateObservationSchedule.class)
public class FxAverageRateObservationScheduleMeta implements RosettaMetaData<FxAverageRateObservationSchedule> {

	@Override
	public List<Validator<? super FxAverageRateObservationSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAverageRateObservationSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAverageRateObservationSchedule> validator() {
		return new FxAverageRateObservationScheduleValidator();
	}

	@Override
	public Validator<? super FxAverageRateObservationSchedule> typeFormatValidator() {
		return new FxAverageRateObservationScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAverageRateObservationSchedule, Set<String>> onlyExistsValidator() {
		return new FxAverageRateObservationScheduleOnlyExistsValidator();
	}
}
