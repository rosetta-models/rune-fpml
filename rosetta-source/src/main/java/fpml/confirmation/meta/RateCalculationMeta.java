package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RateCalculation;
import fpml.confirmation.validation.RateCalculationTypeFormatValidator;
import fpml.confirmation.validation.RateCalculationValidator;
import fpml.confirmation.validation.exists.RateCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RateCalculation.class)
public class RateCalculationMeta implements RosettaMetaData<RateCalculation> {

	@Override
	public List<Validator<? super RateCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RateCalculation> validator() {
		return new RateCalculationValidator();
	}

	@Override
	public Validator<? super RateCalculation> typeFormatValidator() {
		return new RateCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateCalculation, Set<String>> onlyExistsValidator() {
		return new RateCalculationOnlyExistsValidator();
	}
}
