package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketOption;
import fpml.confirmation.validation.CommodityBasketOptionTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketOptionValidator;
import fpml.confirmation.validation.exists.CommodityBasketOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityBasketOption.class)
public class CommodityBasketOptionMeta implements RosettaMetaData<CommodityBasketOption> {

	@Override
	public List<Validator<? super CommodityBasketOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityBasketOption>create(fpml.confirmation.validation.datarule.CommodityBasketOptionChoice.class),
			factory.<fpml.confirmation.CommodityBasketOption>create(fpml.confirmation.validation.datarule.CommodityBasketOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasketOption> validator() {
		return new CommodityBasketOptionValidator();
	}

	@Override
	public Validator<? super CommodityBasketOption> typeFormatValidator() {
		return new CommodityBasketOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketOption, Set<String>> onlyExistsValidator() {
		return new CommodityBasketOptionOnlyExistsValidator();
	}
}
