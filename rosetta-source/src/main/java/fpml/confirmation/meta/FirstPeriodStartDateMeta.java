package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FirstPeriodStartDate;
import fpml.confirmation.validation.FirstPeriodStartDateTypeFormatValidator;
import fpml.confirmation.validation.FirstPeriodStartDateValidator;
import fpml.confirmation.validation.exists.FirstPeriodStartDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FirstPeriodStartDate.class)
public class FirstPeriodStartDateMeta implements RosettaMetaData<FirstPeriodStartDate> {

	@Override
	public List<Validator<? super FirstPeriodStartDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FirstPeriodStartDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FirstPeriodStartDate> validator() {
		return new FirstPeriodStartDateValidator();
	}

	@Override
	public Validator<? super FirstPeriodStartDate> typeFormatValidator() {
		return new FirstPeriodStartDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FirstPeriodStartDate, Set<String>> onlyExistsValidator() {
		return new FirstPeriodStartDateOnlyExistsValidator();
	}
}
