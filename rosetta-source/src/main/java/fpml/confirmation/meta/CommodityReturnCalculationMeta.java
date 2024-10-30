package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityReturnCalculation;
import fpml.confirmation.validation.CommodityReturnCalculationTypeFormatValidator;
import fpml.confirmation.validation.CommodityReturnCalculationValidator;
import fpml.confirmation.validation.exists.CommodityReturnCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityReturnCalculation.class)
public class CommodityReturnCalculationMeta implements RosettaMetaData<CommodityReturnCalculation> {

	@Override
	public List<Validator<? super CommodityReturnCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityReturnCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityReturnCalculation> validator() {
		return new CommodityReturnCalculationValidator();
	}

	@Override
	public Validator<? super CommodityReturnCalculation> typeFormatValidator() {
		return new CommodityReturnCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityReturnCalculation, Set<String>> onlyExistsValidator() {
		return new CommodityReturnCalculationOnlyExistsValidator();
	}
}
