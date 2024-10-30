package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasket;
import fpml.confirmation.validation.CommodityBasketTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketValidator;
import fpml.confirmation.validation.exists.CommodityBasketOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityBasket.class)
public class CommodityBasketMeta implements RosettaMetaData<CommodityBasket> {

	@Override
	public List<Validator<? super CommodityBasket>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasket, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasket> validator() {
		return new CommodityBasketValidator();
	}

	@Override
	public Validator<? super CommodityBasket> typeFormatValidator() {
		return new CommodityBasketTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasket, Set<String>> onlyExistsValidator() {
		return new CommodityBasketOnlyExistsValidator();
	}
}
