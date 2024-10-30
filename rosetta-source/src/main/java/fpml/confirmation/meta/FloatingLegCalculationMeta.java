package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.validation.FloatingLegCalculationTypeFormatValidator;
import fpml.confirmation.validation.FloatingLegCalculationValidator;
import fpml.confirmation.validation.exists.FloatingLegCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FloatingLegCalculation.class)
public class FloatingLegCalculationMeta implements RosettaMetaData<FloatingLegCalculation> {

	@Override
	public List<Validator<? super FloatingLegCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FloatingLegCalculation>create(fpml.confirmation.validation.datarule.FloatingLegCalculationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingLegCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingLegCalculation> validator() {
		return new FloatingLegCalculationValidator();
	}

	@Override
	public Validator<? super FloatingLegCalculation> typeFormatValidator() {
		return new FloatingLegCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingLegCalculation, Set<String>> onlyExistsValidator() {
		return new FloatingLegCalculationOnlyExistsValidator();
	}
}
