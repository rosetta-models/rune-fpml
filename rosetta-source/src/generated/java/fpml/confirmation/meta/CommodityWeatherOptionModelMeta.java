package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityWeatherOptionModel;
import fpml.confirmation.validation.CommodityWeatherOptionModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityWeatherOptionModelValidator;
import fpml.confirmation.validation.exists.CommodityWeatherOptionModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityWeatherOptionModel.class)
public class CommodityWeatherOptionModelMeta implements RosettaMetaData<CommodityWeatherOptionModel> {

	@Override
	public List<Validator<? super CommodityWeatherOptionModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityWeatherOptionModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityWeatherOptionModel> validator() {
		return new CommodityWeatherOptionModelValidator();
	}

	@Override
	public Validator<? super CommodityWeatherOptionModel> typeFormatValidator() {
		return new CommodityWeatherOptionModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityWeatherOptionModel, Set<String>> onlyExistsValidator() {
		return new CommodityWeatherOptionModelOnlyExistsValidator();
	}
}
