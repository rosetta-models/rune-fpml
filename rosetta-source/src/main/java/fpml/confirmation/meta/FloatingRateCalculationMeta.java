package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.validation.FloatingRateCalculationTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateCalculationValidator;
import fpml.confirmation.validation.exists.FloatingRateCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FloatingRateCalculation.class)
public class FloatingRateCalculationMeta implements RosettaMetaData<FloatingRateCalculation> {

	@Override
	public List<Validator<? super FloatingRateCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateCalculation> validator() {
		return new FloatingRateCalculationValidator();
	}

	@Override
	public Validator<? super FloatingRateCalculation> typeFormatValidator() {
		return new FloatingRateCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateCalculation, Set<String>> onlyExistsValidator() {
		return new FloatingRateCalculationOnlyExistsValidator();
	}
}
