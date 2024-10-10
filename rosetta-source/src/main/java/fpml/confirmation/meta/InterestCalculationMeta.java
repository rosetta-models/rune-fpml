package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestCalculation;
import fpml.confirmation.validation.InterestCalculationTypeFormatValidator;
import fpml.confirmation.validation.InterestCalculationValidator;
import fpml.confirmation.validation.exists.InterestCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestCalculation.class)
public class InterestCalculationMeta implements RosettaMetaData<InterestCalculation> {

	@Override
	public List<Validator<? super InterestCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.InterestAccrualsMethod>create(fpml.confirmation.validation.datarule.InterestAccrualsMethodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestCalculation> validator() {
		return new InterestCalculationValidator();
	}

	@Override
	public Validator<? super InterestCalculation> typeFormatValidator() {
		return new InterestCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestCalculation, Set<String>> onlyExistsValidator() {
		return new InterestCalculationOnlyExistsValidator();
	}
}
