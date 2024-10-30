package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetKnockoutForwardSequence;
import fpml.confirmation.validation.FxTargetKnockoutForwardSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxTargetKnockoutForwardSequenceValidator;
import fpml.confirmation.validation.exists.FxTargetKnockoutForwardSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetKnockoutForwardSequence.class)
public class FxTargetKnockoutForwardSequenceMeta implements RosettaMetaData<FxTargetKnockoutForwardSequence> {

	@Override
	public List<Validator<? super FxTargetKnockoutForwardSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetKnockoutForwardSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetKnockoutForwardSequence> validator() {
		return new FxTargetKnockoutForwardSequenceValidator();
	}

	@Override
	public Validator<? super FxTargetKnockoutForwardSequence> typeFormatValidator() {
		return new FxTargetKnockoutForwardSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetKnockoutForwardSequence, Set<String>> onlyExistsValidator() {
		return new FxTargetKnockoutForwardSequenceOnlyExistsValidator();
	}
}
