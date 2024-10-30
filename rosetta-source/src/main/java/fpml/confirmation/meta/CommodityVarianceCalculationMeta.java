package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityVarianceCalculation;
import fpml.confirmation.validation.CommodityVarianceCalculationTypeFormatValidator;
import fpml.confirmation.validation.CommodityVarianceCalculationValidator;
import fpml.confirmation.validation.exists.CommodityVarianceCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityVarianceCalculation.class)
public class CommodityVarianceCalculationMeta implements RosettaMetaData<CommodityVarianceCalculation> {

	@Override
	public List<Validator<? super CommodityVarianceCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityVarianceCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityVarianceCalculation> validator() {
		return new CommodityVarianceCalculationValidator();
	}

	@Override
	public Validator<? super CommodityVarianceCalculation> typeFormatValidator() {
		return new CommodityVarianceCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityVarianceCalculation, Set<String>> onlyExistsValidator() {
		return new CommodityVarianceCalculationOnlyExistsValidator();
	}
}
