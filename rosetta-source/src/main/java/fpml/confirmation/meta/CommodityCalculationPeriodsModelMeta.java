package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.validation.CommodityCalculationPeriodsModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityCalculationPeriodsModelValidator;
import fpml.confirmation.validation.exists.CommodityCalculationPeriodsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityCalculationPeriodsModel.class)
public class CommodityCalculationPeriodsModelMeta implements RosettaMetaData<CommodityCalculationPeriodsModel> {

	@Override
	public List<Validator<? super CommodityCalculationPeriodsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityCalculationPeriodsModel>create(fpml.confirmation.validation.datarule.CommodityCalculationPeriodsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityCalculationPeriodsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityCalculationPeriodsModel> validator() {
		return new CommodityCalculationPeriodsModelValidator();
	}

	@Override
	public Validator<? super CommodityCalculationPeriodsModel> typeFormatValidator() {
		return new CommodityCalculationPeriodsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityCalculationPeriodsModel, Set<String>> onlyExistsValidator() {
		return new CommodityCalculationPeriodsModelOnlyExistsValidator();
	}
}
