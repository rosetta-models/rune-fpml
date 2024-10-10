package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityStrikePriceModel;
import fpml.confirmation.validation.CommodityStrikePriceModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityStrikePriceModelValidator;
import fpml.confirmation.validation.exists.CommodityStrikePriceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityStrikePriceModel.class)
public class CommodityStrikePriceModelMeta implements RosettaMetaData<CommodityStrikePriceModel> {

	@Override
	public List<Validator<? super CommodityStrikePriceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityStrikePriceModel>create(fpml.confirmation.validation.datarule.CommodityStrikePriceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityStrikePriceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityStrikePriceModel> validator() {
		return new CommodityStrikePriceModelValidator();
	}

	@Override
	public Validator<? super CommodityStrikePriceModel> typeFormatValidator() {
		return new CommodityStrikePriceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityStrikePriceModel, Set<String>> onlyExistsValidator() {
		return new CommodityStrikePriceModelOnlyExistsValidator();
	}
}
