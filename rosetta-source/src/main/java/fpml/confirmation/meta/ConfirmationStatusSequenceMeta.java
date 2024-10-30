package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConfirmationStatusSequence;
import fpml.confirmation.validation.ConfirmationStatusSequenceTypeFormatValidator;
import fpml.confirmation.validation.ConfirmationStatusSequenceValidator;
import fpml.confirmation.validation.exists.ConfirmationStatusSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ConfirmationStatusSequence.class)
public class ConfirmationStatusSequenceMeta implements RosettaMetaData<ConfirmationStatusSequence> {

	@Override
	public List<Validator<? super ConfirmationStatusSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConfirmationStatusSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConfirmationStatusSequence> validator() {
		return new ConfirmationStatusSequenceValidator();
	}

	@Override
	public Validator<? super ConfirmationStatusSequence> typeFormatValidator() {
		return new ConfirmationStatusSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationStatusSequence, Set<String>> onlyExistsValidator() {
		return new ConfirmationStatusSequenceOnlyExistsValidator();
	}
}
