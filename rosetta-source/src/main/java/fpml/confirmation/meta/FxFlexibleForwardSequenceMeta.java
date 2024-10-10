package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFlexibleForwardSequence;
import fpml.confirmation.validation.FxFlexibleForwardSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxFlexibleForwardSequenceValidator;
import fpml.confirmation.validation.exists.FxFlexibleForwardSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxFlexibleForwardSequence.class)
public class FxFlexibleForwardSequenceMeta implements RosettaMetaData<FxFlexibleForwardSequence> {

	@Override
	public List<Validator<? super FxFlexibleForwardSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFlexibleForwardSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFlexibleForwardSequence> validator() {
		return new FxFlexibleForwardSequenceValidator();
	}

	@Override
	public Validator<? super FxFlexibleForwardSequence> typeFormatValidator() {
		return new FxFlexibleForwardSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFlexibleForwardSequence, Set<String>> onlyExistsValidator() {
		return new FxFlexibleForwardSequenceOnlyExistsValidator();
	}
}
