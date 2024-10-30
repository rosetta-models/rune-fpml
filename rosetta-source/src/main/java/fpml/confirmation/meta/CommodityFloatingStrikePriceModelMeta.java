package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.validation.CommodityFloatingStrikePriceModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityFloatingStrikePriceModelValidator;
import fpml.confirmation.validation.exists.CommodityFloatingStrikePriceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityFloatingStrikePriceModel.class)
public class CommodityFloatingStrikePriceModelMeta implements RosettaMetaData<CommodityFloatingStrikePriceModel> {

	@Override
	public List<Validator<? super CommodityFloatingStrikePriceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityFloatingStrikePriceModel>create(fpml.confirmation.validation.datarule.CommodityFloatingStrikePriceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFloatingStrikePriceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFloatingStrikePriceModel> validator() {
		return new CommodityFloatingStrikePriceModelValidator();
	}

	@Override
	public Validator<? super CommodityFloatingStrikePriceModel> typeFormatValidator() {
		return new CommodityFloatingStrikePriceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFloatingStrikePriceModel, Set<String>> onlyExistsValidator() {
		return new CommodityFloatingStrikePriceModelOnlyExistsValidator();
	}
}
