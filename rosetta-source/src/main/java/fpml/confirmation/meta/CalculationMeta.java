package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Calculation;
import fpml.confirmation.validation.CalculationTypeFormatValidator;
import fpml.confirmation.validation.CalculationValidator;
import fpml.confirmation.validation.exists.CalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Calculation.class)
public class CalculationMeta implements RosettaMetaData<Calculation> {

	@Override
	public List<Validator<? super Calculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Calculation>create(fpml.confirmation.validation.datarule.CalculationChoice0.class),
			factory.<fpml.confirmation.Calculation>create(fpml.confirmation.validation.datarule.CalculationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super Calculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Calculation> validator() {
		return new CalculationValidator();
	}

	@Override
	public Validator<? super Calculation> typeFormatValidator() {
		return new CalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Calculation, Set<String>> onlyExistsValidator() {
		return new CalculationOnlyExistsValidator();
	}
}
