package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCoalPropertiesModel;
import fpml.confirmation.validation.CommodityCoalPropertiesModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityCoalPropertiesModelValidator;
import fpml.confirmation.validation.exists.CommodityCoalPropertiesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityCoalPropertiesModel.class)
public class CommodityCoalPropertiesModelMeta implements RosettaMetaData<CommodityCoalPropertiesModel> {

	@Override
	public List<Validator<? super CommodityCoalPropertiesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityCoalPropertiesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityCoalPropertiesModel> validator() {
		return new CommodityCoalPropertiesModelValidator();
	}

	@Override
	public Validator<? super CommodityCoalPropertiesModel> typeFormatValidator() {
		return new CommodityCoalPropertiesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityCoalPropertiesModel, Set<String>> onlyExistsValidator() {
		return new CommodityCoalPropertiesModelOnlyExistsValidator();
	}
}
