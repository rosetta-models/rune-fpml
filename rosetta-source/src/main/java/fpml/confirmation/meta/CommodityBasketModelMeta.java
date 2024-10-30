package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketModel;
import fpml.confirmation.validation.CommodityBasketModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketModelValidator;
import fpml.confirmation.validation.exists.CommodityBasketModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityBasketModel.class)
public class CommodityBasketModelMeta implements RosettaMetaData<CommodityBasketModel> {

	@Override
	public List<Validator<? super CommodityBasketModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityBasketModel>create(fpml.confirmation.validation.datarule.CommodityBasketModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasketModel> validator() {
		return new CommodityBasketModelValidator();
	}

	@Override
	public Validator<? super CommodityBasketModel> typeFormatValidator() {
		return new CommodityBasketModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketModel, Set<String>> onlyExistsValidator() {
		return new CommodityBasketModelOnlyExistsValidator();
	}
}
