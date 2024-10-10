package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InflationRateCalculation;
import fpml.confirmation.validation.InflationRateCalculationTypeFormatValidator;
import fpml.confirmation.validation.InflationRateCalculationValidator;
import fpml.confirmation.validation.exists.InflationRateCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InflationRateCalculation.class)
public class InflationRateCalculationMeta implements RosettaMetaData<InflationRateCalculation> {

	@Override
	public List<Validator<? super InflationRateCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InflationRateCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InflationRateCalculation> validator() {
		return new InflationRateCalculationValidator();
	}

	@Override
	public Validator<? super InflationRateCalculation> typeFormatValidator() {
		return new InflationRateCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InflationRateCalculation, Set<String>> onlyExistsValidator() {
		return new InflationRateCalculationOnlyExistsValidator();
	}
}
