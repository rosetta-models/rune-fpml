package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventPaymentSequence;
import fpml.confirmation.validation.EventPaymentSequenceTypeFormatValidator;
import fpml.confirmation.validation.EventPaymentSequenceValidator;
import fpml.confirmation.validation.exists.EventPaymentSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EventPaymentSequence.class)
public class EventPaymentSequenceMeta implements RosettaMetaData<EventPaymentSequence> {

	@Override
	public List<Validator<? super EventPaymentSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventPaymentSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventPaymentSequence> validator() {
		return new EventPaymentSequenceValidator();
	}

	@Override
	public Validator<? super EventPaymentSequence> typeFormatValidator() {
		return new EventPaymentSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventPaymentSequence, Set<String>> onlyExistsValidator() {
		return new EventPaymentSequenceOnlyExistsValidator();
	}
}
