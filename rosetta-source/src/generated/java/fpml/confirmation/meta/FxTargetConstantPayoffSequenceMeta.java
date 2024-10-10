package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetConstantPayoffSequence;
import fpml.confirmation.validation.FxTargetConstantPayoffSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxTargetConstantPayoffSequenceValidator;
import fpml.confirmation.validation.exists.FxTargetConstantPayoffSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetConstantPayoffSequence.class)
public class FxTargetConstantPayoffSequenceMeta implements RosettaMetaData<FxTargetConstantPayoffSequence> {

	@Override
	public List<Validator<? super FxTargetConstantPayoffSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetConstantPayoffSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetConstantPayoffSequence> validator() {
		return new FxTargetConstantPayoffSequenceValidator();
	}

	@Override
	public Validator<? super FxTargetConstantPayoffSequence> typeFormatValidator() {
		return new FxTargetConstantPayoffSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetConstantPayoffSequence, Set<String>> onlyExistsValidator() {
		return new FxTargetConstantPayoffSequenceOnlyExistsValidator();
	}
}
