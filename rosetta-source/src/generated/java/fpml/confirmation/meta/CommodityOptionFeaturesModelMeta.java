package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityOptionFeaturesModel;
import fpml.confirmation.validation.CommodityOptionFeaturesModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityOptionFeaturesModelValidator;
import fpml.confirmation.validation.exists.CommodityOptionFeaturesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityOptionFeaturesModel.class)
public class CommodityOptionFeaturesModelMeta implements RosettaMetaData<CommodityOptionFeaturesModel> {

	@Override
	public List<Validator<? super CommodityOptionFeaturesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityOptionFeaturesModel>create(fpml.confirmation.validation.datarule.CommodityOptionFeaturesModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityOptionFeaturesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityOptionFeaturesModel> validator() {
		return new CommodityOptionFeaturesModelValidator();
	}

	@Override
	public Validator<? super CommodityOptionFeaturesModel> typeFormatValidator() {
		return new CommodityOptionFeaturesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityOptionFeaturesModel, Set<String>> onlyExistsValidator() {
		return new CommodityOptionFeaturesModelOnlyExistsValidator();
	}
}
