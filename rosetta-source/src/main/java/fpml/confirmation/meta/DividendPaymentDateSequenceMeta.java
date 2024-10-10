package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendPaymentDateSequence;
import fpml.confirmation.validation.DividendPaymentDateSequenceTypeFormatValidator;
import fpml.confirmation.validation.DividendPaymentDateSequenceValidator;
import fpml.confirmation.validation.exists.DividendPaymentDateSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DividendPaymentDateSequence.class)
public class DividendPaymentDateSequenceMeta implements RosettaMetaData<DividendPaymentDateSequence> {

	@Override
	public List<Validator<? super DividendPaymentDateSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendPaymentDateSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendPaymentDateSequence> validator() {
		return new DividendPaymentDateSequenceValidator();
	}

	@Override
	public Validator<? super DividendPaymentDateSequence> typeFormatValidator() {
		return new DividendPaymentDateSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPaymentDateSequence, Set<String>> onlyExistsValidator() {
		return new DividendPaymentDateSequenceOnlyExistsValidator();
	}
}
