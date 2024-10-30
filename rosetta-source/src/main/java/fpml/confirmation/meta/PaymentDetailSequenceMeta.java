package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentDetailSequence;
import fpml.confirmation.validation.PaymentDetailSequenceTypeFormatValidator;
import fpml.confirmation.validation.PaymentDetailSequenceValidator;
import fpml.confirmation.validation.exists.PaymentDetailSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PaymentDetailSequence.class)
public class PaymentDetailSequenceMeta implements RosettaMetaData<PaymentDetailSequence> {

	@Override
	public List<Validator<? super PaymentDetailSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentDetailSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentDetailSequence> validator() {
		return new PaymentDetailSequenceValidator();
	}

	@Override
	public Validator<? super PaymentDetailSequence> typeFormatValidator() {
		return new PaymentDetailSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDetailSequence, Set<String>> onlyExistsValidator() {
		return new PaymentDetailSequenceOnlyExistsValidator();
	}
}
