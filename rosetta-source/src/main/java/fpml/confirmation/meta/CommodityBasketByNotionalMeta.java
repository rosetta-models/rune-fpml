package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketByNotional;
import fpml.confirmation.validation.CommodityBasketByNotionalTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketByNotionalValidator;
import fpml.confirmation.validation.exists.CommodityBasketByNotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityBasketByNotional.class)
public class CommodityBasketByNotionalMeta implements RosettaMetaData<CommodityBasketByNotional> {

	@Override
	public List<Validator<? super CommodityBasketByNotional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketByNotional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasketByNotional> validator() {
		return new CommodityBasketByNotionalValidator();
	}

	@Override
	public Validator<? super CommodityBasketByNotional> typeFormatValidator() {
		return new CommodityBasketByNotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketByNotional, Set<String>> onlyExistsValidator() {
		return new CommodityBasketByNotionalOnlyExistsValidator();
	}
}
