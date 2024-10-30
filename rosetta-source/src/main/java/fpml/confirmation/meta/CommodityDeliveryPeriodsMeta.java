package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.validation.CommodityDeliveryPeriodsTypeFormatValidator;
import fpml.confirmation.validation.CommodityDeliveryPeriodsValidator;
import fpml.confirmation.validation.exists.CommodityDeliveryPeriodsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityDeliveryPeriods.class)
public class CommodityDeliveryPeriodsMeta implements RosettaMetaData<CommodityDeliveryPeriods> {

	@Override
	public List<Validator<? super CommodityDeliveryPeriods>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityDeliveryPeriods>create(fpml.confirmation.validation.datarule.CommodityDeliveryPeriodsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryPeriods, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDeliveryPeriods> validator() {
		return new CommodityDeliveryPeriodsValidator();
	}

	@Override
	public Validator<? super CommodityDeliveryPeriods> typeFormatValidator() {
		return new CommodityDeliveryPeriodsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryPeriods, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryPeriodsOnlyExistsValidator();
	}
}
