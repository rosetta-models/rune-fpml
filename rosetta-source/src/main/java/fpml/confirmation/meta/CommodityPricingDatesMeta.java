package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.validation.CommodityPricingDatesTypeFormatValidator;
import fpml.confirmation.validation.CommodityPricingDatesValidator;
import fpml.confirmation.validation.exists.CommodityPricingDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPricingDates.class)
public class CommodityPricingDatesMeta implements RosettaMetaData<CommodityPricingDates> {

	@Override
	public List<Validator<? super CommodityPricingDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityPricingDates>create(fpml.confirmation.validation.datarule.CommodityPricingDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPricingDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPricingDates> validator() {
		return new CommodityPricingDatesValidator();
	}

	@Override
	public Validator<? super CommodityPricingDates> typeFormatValidator() {
		return new CommodityPricingDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPricingDates, Set<String>> onlyExistsValidator() {
		return new CommodityPricingDatesOnlyExistsValidator();
	}
}
