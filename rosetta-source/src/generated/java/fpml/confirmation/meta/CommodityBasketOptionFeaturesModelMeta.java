package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketOptionFeaturesModel;
import fpml.confirmation.validation.CommodityBasketOptionFeaturesModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityBasketOptionFeaturesModelValidator;
import fpml.confirmation.validation.exists.CommodityBasketOptionFeaturesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityBasketOptionFeaturesModel.class)
public class CommodityBasketOptionFeaturesModelMeta implements RosettaMetaData<CommodityBasketOptionFeaturesModel> {

	@Override
	public List<Validator<? super CommodityBasketOptionFeaturesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityBasketOptionFeaturesModel>create(fpml.confirmation.validation.datarule.CommodityBasketOptionFeaturesModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketOptionFeaturesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBasketOptionFeaturesModel> validator() {
		return new CommodityBasketOptionFeaturesModelValidator();
	}

	@Override
	public Validator<? super CommodityBasketOptionFeaturesModel> typeFormatValidator() {
		return new CommodityBasketOptionFeaturesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketOptionFeaturesModel, Set<String>> onlyExistsValidator() {
		return new CommodityBasketOptionFeaturesModelOnlyExistsValidator();
	}
}
