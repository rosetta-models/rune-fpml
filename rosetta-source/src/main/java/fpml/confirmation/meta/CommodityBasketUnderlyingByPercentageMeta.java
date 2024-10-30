package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketUnderlyingByPercentage;
import fpml.confirmation.validation.CommodityBasketUnderlyingByPercentageTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketUnderlyingByPercentageValidator;
import fpml.confirmation.validation.exists.CommodityBasketUnderlyingByPercentageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityBasketUnderlyingByPercentage.class)
public class CommodityBasketUnderlyingByPercentageMeta implements RosettaMetaData<CommodityBasketUnderlyingByPercentage> {

	@Override
	public List<Validator<? super CommodityBasketUnderlyingByPercentage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketUnderlyingByPercentage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasketUnderlyingByPercentage> validator() {
		return new CommodityBasketUnderlyingByPercentageValidator();
	}

	@Override
	public Validator<? super CommodityBasketUnderlyingByPercentage> typeFormatValidator() {
		return new CommodityBasketUnderlyingByPercentageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketUnderlyingByPercentage, Set<String>> onlyExistsValidator() {
		return new CommodityBasketUnderlyingByPercentageOnlyExistsValidator();
	}
}
