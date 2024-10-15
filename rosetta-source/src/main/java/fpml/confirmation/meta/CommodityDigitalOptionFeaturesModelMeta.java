package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel;
import fpml.confirmation.validation.CommodityDigitalOptionFeaturesModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityDigitalOptionFeaturesModelValidator;
import fpml.confirmation.validation.exists.CommodityDigitalOptionFeaturesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityDigitalOptionFeaturesModel.class)
public class CommodityDigitalOptionFeaturesModelMeta implements RosettaMetaData<CommodityDigitalOptionFeaturesModel> {

	@Override
	public List<Validator<? super CommodityDigitalOptionFeaturesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDigitalOptionFeaturesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDigitalOptionFeaturesModel> validator() {
		return new CommodityDigitalOptionFeaturesModelValidator();
	}

	@Override
	public Validator<? super CommodityDigitalOptionFeaturesModel> typeFormatValidator() {
		return new CommodityDigitalOptionFeaturesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDigitalOptionFeaturesModel, Set<String>> onlyExistsValidator() {
		return new CommodityDigitalOptionFeaturesModelOnlyExistsValidator();
	}
}
