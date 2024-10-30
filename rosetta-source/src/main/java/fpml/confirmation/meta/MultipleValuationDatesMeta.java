package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MultipleValuationDates;
import fpml.confirmation.validation.MultipleValuationDatesTypeFormatValidator;
import fpml.confirmation.validation.MultipleValuationDatesValidator;
import fpml.confirmation.validation.exists.MultipleValuationDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MultipleValuationDates.class)
public class MultipleValuationDatesMeta implements RosettaMetaData<MultipleValuationDates> {

	@Override
	public List<Validator<? super MultipleValuationDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MultipleValuationDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MultipleValuationDates> validator() {
		return new MultipleValuationDatesValidator();
	}

	@Override
	public Validator<? super MultipleValuationDates> typeFormatValidator() {
		return new MultipleValuationDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MultipleValuationDates, Set<String>> onlyExistsValidator() {
		return new MultipleValuationDatesOnlyExistsValidator();
	}
}
