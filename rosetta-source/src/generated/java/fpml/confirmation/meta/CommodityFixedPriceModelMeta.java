package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedPriceModel;
import fpml.confirmation.validation.CommodityFixedPriceModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityFixedPriceModelValidator;
import fpml.confirmation.validation.exists.CommodityFixedPriceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityFixedPriceModel.class)
public class CommodityFixedPriceModelMeta implements RosettaMetaData<CommodityFixedPriceModel> {

	@Override
	public List<Validator<? super CommodityFixedPriceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityFixedPriceModel>create(fpml.confirmation.validation.datarule.CommodityFixedPriceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFixedPriceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFixedPriceModel> validator() {
		return new CommodityFixedPriceModelValidator();
	}

	@Override
	public Validator<? super CommodityFixedPriceModel> typeFormatValidator() {
		return new CommodityFixedPriceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFixedPriceModel, Set<String>> onlyExistsValidator() {
		return new CommodityFixedPriceModelOnlyExistsValidator();
	}
}
