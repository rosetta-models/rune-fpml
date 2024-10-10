package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff;
import fpml.confirmation.validation.FxAccrualSettlementPeriodPayoffTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualSettlementPeriodPayoffValidator;
import fpml.confirmation.validation.exists.FxAccrualSettlementPeriodPayoffOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualSettlementPeriodPayoff.class)
public class FxAccrualSettlementPeriodPayoffMeta implements RosettaMetaData<FxAccrualSettlementPeriodPayoff> {

	@Override
	public List<Validator<? super FxAccrualSettlementPeriodPayoff>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAccrualSettlementPeriodPayoff>create(fpml.confirmation.validation.datarule.FxAccrualSettlementPeriodPayoffChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualSettlementPeriodPayoff, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriodPayoff> validator() {
		return new FxAccrualSettlementPeriodPayoffValidator();
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriodPayoff> typeFormatValidator() {
		return new FxAccrualSettlementPeriodPayoffTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualSettlementPeriodPayoff, Set<String>> onlyExistsValidator() {
		return new FxAccrualSettlementPeriodPayoffOnlyExistsValidator();
	}
}
