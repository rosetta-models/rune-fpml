package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketBase;
import fpml.confirmation.validation.CommodityBasketBaseTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketBaseValidator;
import fpml.confirmation.validation.exists.CommodityBasketBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityBasketBase.class)
public class CommodityBasketBaseMeta implements RosettaMetaData<CommodityBasketBase> {

	@Override
	public List<Validator<? super CommodityBasketBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasketBase> validator() {
		return new CommodityBasketBaseValidator();
	}

	@Override
	public Validator<? super CommodityBasketBase> typeFormatValidator() {
		return new CommodityBasketBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketBase, Set<String>> onlyExistsValidator() {
		return new CommodityBasketBaseOnlyExistsValidator();
	}
}
