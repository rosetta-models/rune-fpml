package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedInterestCalculation;
import fpml.confirmation.validation.CommodityFixedInterestCalculationTypeFormatValidator;
import fpml.confirmation.validation.CommodityFixedInterestCalculationValidator;
import fpml.confirmation.validation.exists.CommodityFixedInterestCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityFixedInterestCalculation.class)
public class CommodityFixedInterestCalculationMeta implements RosettaMetaData<CommodityFixedInterestCalculation> {

	@Override
	public List<Validator<? super CommodityFixedInterestCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFixedInterestCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFixedInterestCalculation> validator() {
		return new CommodityFixedInterestCalculationValidator();
	}

	@Override
	public Validator<? super CommodityFixedInterestCalculation> typeFormatValidator() {
		return new CommodityFixedInterestCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFixedInterestCalculation, Set<String>> onlyExistsValidator() {
		return new CommodityFixedInterestCalculationOnlyExistsValidator();
	}
}
