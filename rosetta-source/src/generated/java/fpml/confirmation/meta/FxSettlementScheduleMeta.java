package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSettlementSchedule;
import fpml.confirmation.validation.FxSettlementScheduleTypeFormatValidator;
import fpml.confirmation.validation.FxSettlementScheduleValidator;
import fpml.confirmation.validation.exists.FxSettlementScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxSettlementSchedule.class)
public class FxSettlementScheduleMeta implements RosettaMetaData<FxSettlementSchedule> {

	@Override
	public List<Validator<? super FxSettlementSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxSchedule>create(fpml.confirmation.validation.datarule.FxScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxSettlementSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSettlementSchedule> validator() {
		return new FxSettlementScheduleValidator();
	}

	@Override
	public Validator<? super FxSettlementSchedule> typeFormatValidator() {
		return new FxSettlementScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSettlementSchedule, Set<String>> onlyExistsValidator() {
		return new FxSettlementScheduleOnlyExistsValidator();
	}
}
