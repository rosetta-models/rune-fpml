package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPeriodLeverage;
import fpml.confirmation.validation.SettlementPeriodLeverageTypeFormatValidator;
import fpml.confirmation.validation.SettlementPeriodLeverageValidator;
import fpml.confirmation.validation.exists.SettlementPeriodLeverageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SettlementPeriodLeverage.class)
public class SettlementPeriodLeverageMeta implements RosettaMetaData<SettlementPeriodLeverage> {

	@Override
	public List<Validator<? super SettlementPeriodLeverage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SettlementPeriodLeverage>create(fpml.confirmation.validation.datarule.SettlementPeriodLeverageChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodLeverage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementPeriodLeverage> validator() {
		return new SettlementPeriodLeverageValidator();
	}

	@Override
	public Validator<? super SettlementPeriodLeverage> typeFormatValidator() {
		return new SettlementPeriodLeverageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodLeverage, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodLeverageOnlyExistsValidator();
	}
}
