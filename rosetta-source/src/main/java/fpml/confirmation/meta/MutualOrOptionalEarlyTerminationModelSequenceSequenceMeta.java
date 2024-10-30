package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence;
import fpml.confirmation.validation.MutualOrOptionalEarlyTerminationModelSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.MutualOrOptionalEarlyTerminationModelSequenceSequenceValidator;
import fpml.confirmation.validation.exists.MutualOrOptionalEarlyTerminationModelSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MutualOrOptionalEarlyTerminationModelSequenceSequence.class)
public class MutualOrOptionalEarlyTerminationModelSequenceSequenceMeta implements RosettaMetaData<MutualOrOptionalEarlyTerminationModelSequenceSequence> {

	@Override
	public List<Validator<? super MutualOrOptionalEarlyTerminationModelSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MutualOrOptionalEarlyTerminationModelSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MutualOrOptionalEarlyTerminationModelSequenceSequence> validator() {
		return new MutualOrOptionalEarlyTerminationModelSequenceSequenceValidator();
	}

	@Override
	public Validator<? super MutualOrOptionalEarlyTerminationModelSequenceSequence> typeFormatValidator() {
		return new MutualOrOptionalEarlyTerminationModelSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MutualOrOptionalEarlyTerminationModelSequenceSequence, Set<String>> onlyExistsValidator() {
		return new MutualOrOptionalEarlyTerminationModelSequenceSequenceOnlyExistsValidator();
	}
}
