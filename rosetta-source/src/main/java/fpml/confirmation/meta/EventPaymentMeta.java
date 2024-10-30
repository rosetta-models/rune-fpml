package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventPayment;
import fpml.confirmation.validation.EventPaymentTypeFormatValidator;
import fpml.confirmation.validation.EventPaymentValidator;
import fpml.confirmation.validation.exists.EventPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EventPayment.class)
public class EventPaymentMeta implements RosettaMetaData<EventPayment> {

	@Override
	public List<Validator<? super EventPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventPayment> validator() {
		return new EventPaymentValidator();
	}

	@Override
	public Validator<? super EventPayment> typeFormatValidator() {
		return new EventPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventPayment, Set<String>> onlyExistsValidator() {
		return new EventPaymentOnlyExistsValidator();
	}
}
