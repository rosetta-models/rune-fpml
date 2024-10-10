package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualSettlementPeriod;
import fpml.confirmation.validation.FxAccrualSettlementPeriodTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualSettlementPeriodValidator;
import fpml.confirmation.validation.exists.FxAccrualSettlementPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualSettlementPeriod.class)
public class FxAccrualSettlementPeriodMeta implements RosettaMetaData<FxAccrualSettlementPeriod> {

	@Override
	public List<Validator<? super FxAccrualSettlementPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualSettlementPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriod> validator() {
		return new FxAccrualSettlementPeriodValidator();
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriod> typeFormatValidator() {
		return new FxAccrualSettlementPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualSettlementPeriod, Set<String>> onlyExistsValidator() {
		return new FxAccrualSettlementPeriodOnlyExistsValidator();
	}
}
