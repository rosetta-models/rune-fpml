package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Volatility;
import fpml.confirmation.validation.VolatilityTypeFormatValidator;
import fpml.confirmation.validation.VolatilityValidator;
import fpml.confirmation.validation.exists.VolatilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Volatility.class)
public class VolatilityMeta implements RosettaMetaData<Volatility> {

	@Override
	public List<Validator<? super Volatility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationFromObservation>create(fpml.confirmation.validation.datarule.CalculationFromObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Volatility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Volatility> validator() {
		return new VolatilityValidator();
	}

	@Override
	public Validator<? super Volatility> typeFormatValidator() {
		return new VolatilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Volatility, Set<String>> onlyExistsValidator() {
		return new VolatilityOnlyExistsValidator();
	}
}
