package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPeriodsSchedule;
import fpml.confirmation.validation.SettlementPeriodsScheduleTypeFormatValidator;
import fpml.confirmation.validation.SettlementPeriodsScheduleValidator;
import fpml.confirmation.validation.exists.SettlementPeriodsScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementPeriodsSchedule.class)
public class SettlementPeriodsScheduleMeta implements RosettaMetaData<SettlementPeriodsSchedule> {

	@Override
	public List<Validator<? super SettlementPeriodsSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodsSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementPeriodsSchedule> validator() {
		return new SettlementPeriodsScheduleValidator();
	}

	@Override
	public Validator<? super SettlementPeriodsSchedule> typeFormatValidator() {
		return new SettlementPeriodsScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodsSchedule, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodsScheduleOnlyExistsValidator();
	}
}
