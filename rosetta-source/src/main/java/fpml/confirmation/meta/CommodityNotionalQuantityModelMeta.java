package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.validation.CommodityNotionalQuantityModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityNotionalQuantityModelValidator;
import fpml.confirmation.validation.exists.CommodityNotionalQuantityModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityNotionalQuantityModel.class)
public class CommodityNotionalQuantityModelMeta implements RosettaMetaData<CommodityNotionalQuantityModel> {

	@Override
	public List<Validator<? super CommodityNotionalQuantityModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityNotionalQuantityModel>create(fpml.confirmation.validation.datarule.CommodityNotionalQuantityModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalQuantityModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityNotionalQuantityModel> validator() {
		return new CommodityNotionalQuantityModelValidator();
	}

	@Override
	public Validator<? super CommodityNotionalQuantityModel> typeFormatValidator() {
		return new CommodityNotionalQuantityModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalQuantityModel, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalQuantityModelOnlyExistsValidator();
	}
}
