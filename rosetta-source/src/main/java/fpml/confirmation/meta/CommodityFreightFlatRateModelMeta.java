package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFreightFlatRateModel;
import fpml.confirmation.validation.CommodityFreightFlatRateModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityFreightFlatRateModelValidator;
import fpml.confirmation.validation.exists.CommodityFreightFlatRateModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityFreightFlatRateModel.class)
public class CommodityFreightFlatRateModelMeta implements RosettaMetaData<CommodityFreightFlatRateModel> {

	@Override
	public List<Validator<? super CommodityFreightFlatRateModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFreightFlatRateModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFreightFlatRateModel> validator() {
		return new CommodityFreightFlatRateModelValidator();
	}

	@Override
	public Validator<? super CommodityFreightFlatRateModel> typeFormatValidator() {
		return new CommodityFreightFlatRateModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFreightFlatRateModel, Set<String>> onlyExistsValidator() {
		return new CommodityFreightFlatRateModelOnlyExistsValidator();
	}
}
