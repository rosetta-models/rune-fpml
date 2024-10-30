package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityProductModel;
import fpml.confirmation.validation.CommodityProductModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityProductModelValidator;
import fpml.confirmation.validation.exists.CommodityProductModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityProductModel.class)
public class CommodityProductModelMeta implements RosettaMetaData<CommodityProductModel> {

	@Override
	public List<Validator<? super CommodityProductModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityProductModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityProductModel> validator() {
		return new CommodityProductModelValidator();
	}

	@Override
	public Validator<? super CommodityProductModel> typeFormatValidator() {
		return new CommodityProductModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityProductModel, Set<String>> onlyExistsValidator() {
		return new CommodityProductModelOnlyExistsValidator();
	}
}
