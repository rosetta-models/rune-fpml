package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetSettlementPeriodSchedule;
import fpml.confirmation.validation.FxTargetSettlementPeriodScheduleTypeFormatValidator;
import fpml.confirmation.validation.FxTargetSettlementPeriodScheduleValidator;
import fpml.confirmation.validation.exists.FxTargetSettlementPeriodScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetSettlementPeriodSchedule.class)
public class FxTargetSettlementPeriodScheduleMeta implements RosettaMetaData<FxTargetSettlementPeriodSchedule> {

	@Override
	public List<Validator<? super FxTargetSettlementPeriodSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetSettlementPeriodSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetSettlementPeriodSchedule> validator() {
		return new FxTargetSettlementPeriodScheduleValidator();
	}

	@Override
	public Validator<? super FxTargetSettlementPeriodSchedule> typeFormatValidator() {
		return new FxTargetSettlementPeriodScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetSettlementPeriodSchedule, Set<String>> onlyExistsValidator() {
		return new FxTargetSettlementPeriodScheduleOnlyExistsValidator();
	}
}
