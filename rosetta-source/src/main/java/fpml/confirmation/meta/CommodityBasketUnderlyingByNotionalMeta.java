package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketUnderlyingByNotional;
import fpml.confirmation.validation.CommodityBasketUnderlyingByNotionalTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketUnderlyingByNotionalValidator;
import fpml.confirmation.validation.exists.CommodityBasketUnderlyingByNotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityBasketUnderlyingByNotional.class)
public class CommodityBasketUnderlyingByNotionalMeta implements RosettaMetaData<CommodityBasketUnderlyingByNotional> {

	@Override
	public List<Validator<? super CommodityBasketUnderlyingByNotional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketUnderlyingByNotional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasketUnderlyingByNotional> validator() {
		return new CommodityBasketUnderlyingByNotionalValidator();
	}

	@Override
	public Validator<? super CommodityBasketUnderlyingByNotional> typeFormatValidator() {
		return new CommodityBasketUnderlyingByNotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketUnderlyingByNotional, Set<String>> onlyExistsValidator() {
		return new CommodityBasketUnderlyingByNotionalOnlyExistsValidator();
	}
}
