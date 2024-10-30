package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnSwapPaymentDates;
import fpml.confirmation.validation.ReturnSwapPaymentDatesTypeFormatValidator;
import fpml.confirmation.validation.ReturnSwapPaymentDatesValidator;
import fpml.confirmation.validation.exists.ReturnSwapPaymentDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReturnSwapPaymentDates.class)
public class ReturnSwapPaymentDatesMeta implements RosettaMetaData<ReturnSwapPaymentDates> {

	@Override
	public List<Validator<? super ReturnSwapPaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapPaymentDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnSwapPaymentDates> validator() {
		return new ReturnSwapPaymentDatesValidator();
	}

	@Override
	public Validator<? super ReturnSwapPaymentDates> typeFormatValidator() {
		return new ReturnSwapPaymentDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapPaymentDates, Set<String>> onlyExistsValidator() {
		return new ReturnSwapPaymentDatesOnlyExistsValidator();
	}
}
