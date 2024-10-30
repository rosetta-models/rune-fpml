package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityUSCoalProductModel;
import fpml.confirmation.validation.CommodityUSCoalProductModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityUSCoalProductModelValidator;
import fpml.confirmation.validation.exists.CommodityUSCoalProductModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityUSCoalProductModel.class)
public class CommodityUSCoalProductModelMeta implements RosettaMetaData<CommodityUSCoalProductModel> {

	@Override
	public List<Validator<? super CommodityUSCoalProductModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityUSCoalProductModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityUSCoalProductModel> validator() {
		return new CommodityUSCoalProductModelValidator();
	}

	@Override
	public Validator<? super CommodityUSCoalProductModel> typeFormatValidator() {
		return new CommodityUSCoalProductModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityUSCoalProductModel, Set<String>> onlyExistsValidator() {
		return new CommodityUSCoalProductModelOnlyExistsValidator();
	}
}
