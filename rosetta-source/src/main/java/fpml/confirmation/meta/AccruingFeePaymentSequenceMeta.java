package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeePaymentSequence;
import fpml.confirmation.validation.AccruingFeePaymentSequenceTypeFormatValidator;
import fpml.confirmation.validation.AccruingFeePaymentSequenceValidator;
import fpml.confirmation.validation.exists.AccruingFeePaymentSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccruingFeePaymentSequence.class)
public class AccruingFeePaymentSequenceMeta implements RosettaMetaData<AccruingFeePaymentSequence> {

	@Override
	public List<Validator<? super AccruingFeePaymentSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeePaymentSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingFeePaymentSequence> validator() {
		return new AccruingFeePaymentSequenceValidator();
	}

	@Override
	public Validator<? super AccruingFeePaymentSequence> typeFormatValidator() {
		return new AccruingFeePaymentSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeePaymentSequence, Set<String>> onlyExistsValidator() {
		return new AccruingFeePaymentSequenceOnlyExistsValidator();
	}
}
