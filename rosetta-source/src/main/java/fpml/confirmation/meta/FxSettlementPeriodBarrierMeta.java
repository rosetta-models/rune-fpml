package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSettlementPeriodBarrier;
import fpml.confirmation.validation.FxSettlementPeriodBarrierTypeFormatValidator;
import fpml.confirmation.validation.FxSettlementPeriodBarrierValidator;
import fpml.confirmation.validation.exists.FxSettlementPeriodBarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxSettlementPeriodBarrier.class)
public class FxSettlementPeriodBarrierMeta implements RosettaMetaData<FxSettlementPeriodBarrier> {

	@Override
	public List<Validator<? super FxSettlementPeriodBarrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxSettlementPeriodBarrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSettlementPeriodBarrier> validator() {
		return new FxSettlementPeriodBarrierValidator();
	}

	@Override
	public Validator<? super FxSettlementPeriodBarrier> typeFormatValidator() {
		return new FxSettlementPeriodBarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSettlementPeriodBarrier, Set<String>> onlyExistsValidator() {
		return new FxSettlementPeriodBarrierOnlyExistsValidator();
	}
}
