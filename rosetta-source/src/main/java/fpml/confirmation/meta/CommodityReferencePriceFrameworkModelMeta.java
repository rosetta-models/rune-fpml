package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import fpml.confirmation.validation.CommodityReferencePriceFrameworkModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityReferencePriceFrameworkModelValidator;
import fpml.confirmation.validation.exists.CommodityReferencePriceFrameworkModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityReferencePriceFrameworkModel.class)
public class CommodityReferencePriceFrameworkModelMeta implements RosettaMetaData<CommodityReferencePriceFrameworkModel> {

	@Override
	public List<Validator<? super CommodityReferencePriceFrameworkModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityReferencePriceFrameworkModel>create(fpml.confirmation.validation.datarule.CommodityReferencePriceFrameworkModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityReferencePriceFrameworkModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityReferencePriceFrameworkModel> validator() {
		return new CommodityReferencePriceFrameworkModelValidator();
	}

	@Override
	public Validator<? super CommodityReferencePriceFrameworkModel> typeFormatValidator() {
		return new CommodityReferencePriceFrameworkModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityReferencePriceFrameworkModel, Set<String>> onlyExistsValidator() {
		return new CommodityReferencePriceFrameworkModelOnlyExistsValidator();
	}
}
