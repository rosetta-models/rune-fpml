package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.validation.CommodityCalculationPeriodsPointerModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityCalculationPeriodsPointerModelValidator;
import fpml.confirmation.validation.exists.CommodityCalculationPeriodsPointerModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityCalculationPeriodsPointerModel.class)
public class CommodityCalculationPeriodsPointerModelMeta implements RosettaMetaData<CommodityCalculationPeriodsPointerModel> {

	@Override
	public List<Validator<? super CommodityCalculationPeriodsPointerModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityCalculationPeriodsPointerModel>create(fpml.confirmation.validation.datarule.CommodityCalculationPeriodsPointerModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityCalculationPeriodsPointerModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityCalculationPeriodsPointerModel> validator() {
		return new CommodityCalculationPeriodsPointerModelValidator();
	}

	@Override
	public Validator<? super CommodityCalculationPeriodsPointerModel> typeFormatValidator() {
		return new CommodityCalculationPeriodsPointerModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityCalculationPeriodsPointerModel, Set<String>> onlyExistsValidator() {
		return new CommodityCalculationPeriodsPointerModelOnlyExistsValidator();
	}
}
