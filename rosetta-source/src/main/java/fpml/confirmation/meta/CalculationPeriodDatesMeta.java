package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodDates;
import fpml.confirmation.validation.CalculationPeriodDatesTypeFormatValidator;
import fpml.confirmation.validation.CalculationPeriodDatesValidator;
import fpml.confirmation.validation.exists.CalculationPeriodDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculationPeriodDates.class)
public class CalculationPeriodDatesMeta implements RosettaMetaData<CalculationPeriodDates> {

	@Override
	public List<Validator<? super CalculationPeriodDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationPeriodDates>create(fpml.confirmation.validation.datarule.CalculationPeriodDatesChoice0.class),
			factory.<fpml.confirmation.CalculationPeriodDates>create(fpml.confirmation.validation.datarule.CalculationPeriodDatesChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationPeriodDates> validator() {
		return new CalculationPeriodDatesValidator();
	}

	@Override
	public Validator<? super CalculationPeriodDates> typeFormatValidator() {
		return new CalculationPeriodDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodDates, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodDatesOnlyExistsValidator();
	}
}
