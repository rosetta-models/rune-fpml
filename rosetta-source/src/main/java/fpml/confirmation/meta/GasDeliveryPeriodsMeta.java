package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasDeliveryPeriods;
import fpml.confirmation.validation.GasDeliveryPeriodsTypeFormatValidator;
import fpml.confirmation.validation.GasDeliveryPeriodsValidator;
import fpml.confirmation.validation.exists.GasDeliveryPeriodsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GasDeliveryPeriods.class)
public class GasDeliveryPeriodsMeta implements RosettaMetaData<GasDeliveryPeriods> {

	@Override
	public List<Validator<? super GasDeliveryPeriods>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityDeliveryPeriods>create(fpml.confirmation.validation.datarule.CommodityDeliveryPeriodsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GasDeliveryPeriods, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasDeliveryPeriods> validator() {
		return new GasDeliveryPeriodsValidator();
	}

	@Override
	public Validator<? super GasDeliveryPeriods> typeFormatValidator() {
		return new GasDeliveryPeriodsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasDeliveryPeriods, Set<String>> onlyExistsValidator() {
		return new GasDeliveryPeriodsOnlyExistsValidator();
	}
}
