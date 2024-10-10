package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriod;
import fpml.confirmation.validation.CalculationPeriodTypeFormatValidator;
import fpml.confirmation.validation.CalculationPeriodValidator;
import fpml.confirmation.validation.exists.CalculationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CalculationPeriod.class)
public class CalculationPeriodMeta implements RosettaMetaData<CalculationPeriod> {

	@Override
	public List<Validator<? super CalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationPeriod>create(fpml.confirmation.validation.datarule.CalculationPeriodChoice0.class),
			factory.<fpml.confirmation.CalculationPeriod>create(fpml.confirmation.validation.datarule.CalculationPeriodChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationPeriod> validator() {
		return new CalculationPeriodValidator();
	}

	@Override
	public Validator<? super CalculationPeriod> typeFormatValidator() {
		return new CalculationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriod, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodOnlyExistsValidator();
	}
}
