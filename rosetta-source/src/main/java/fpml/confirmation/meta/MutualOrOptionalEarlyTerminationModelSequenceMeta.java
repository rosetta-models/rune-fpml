package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence;
import fpml.confirmation.validation.MutualOrOptionalEarlyTerminationModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.MutualOrOptionalEarlyTerminationModelSequenceValidator;
import fpml.confirmation.validation.exists.MutualOrOptionalEarlyTerminationModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MutualOrOptionalEarlyTerminationModelSequence.class)
public class MutualOrOptionalEarlyTerminationModelSequenceMeta implements RosettaMetaData<MutualOrOptionalEarlyTerminationModelSequence> {

	@Override
	public List<Validator<? super MutualOrOptionalEarlyTerminationModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MutualOrOptionalEarlyTerminationModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MutualOrOptionalEarlyTerminationModelSequence> validator() {
		return new MutualOrOptionalEarlyTerminationModelSequenceValidator();
	}

	@Override
	public Validator<? super MutualOrOptionalEarlyTerminationModelSequence> typeFormatValidator() {
		return new MutualOrOptionalEarlyTerminationModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MutualOrOptionalEarlyTerminationModelSequence, Set<String>> onlyExistsValidator() {
		return new MutualOrOptionalEarlyTerminationModelSequenceOnlyExistsValidator();
	}
}
