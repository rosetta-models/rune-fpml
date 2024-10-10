package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketUnderlyingBase;
import fpml.confirmation.validation.CommodityBasketUnderlyingBaseTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketUnderlyingBaseValidator;
import fpml.confirmation.validation.exists.CommodityBasketUnderlyingBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityBasketUnderlyingBase.class)
public class CommodityBasketUnderlyingBaseMeta implements RosettaMetaData<CommodityBasketUnderlyingBase> {

	@Override
	public List<Validator<? super CommodityBasketUnderlyingBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketUnderlyingBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasketUnderlyingBase> validator() {
		return new CommodityBasketUnderlyingBaseValidator();
	}

	@Override
	public Validator<? super CommodityBasketUnderlyingBase> typeFormatValidator() {
		return new CommodityBasketUnderlyingBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketUnderlyingBase, Set<String>> onlyExistsValidator() {
		return new CommodityBasketUnderlyingBaseOnlyExistsValidator();
	}
}
