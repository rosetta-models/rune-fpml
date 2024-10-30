package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetLeverageSequence;
import fpml.confirmation.validation.FxTargetLeverageSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxTargetLeverageSequenceValidator;
import fpml.confirmation.validation.exists.FxTargetLeverageSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetLeverageSequence.class)
public class FxTargetLeverageSequenceMeta implements RosettaMetaData<FxTargetLeverageSequence> {

	@Override
	public List<Validator<? super FxTargetLeverageSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetLeverageSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetLeverageSequence> validator() {
		return new FxTargetLeverageSequenceValidator();
	}

	@Override
	public Validator<? super FxTargetLeverageSequence> typeFormatValidator() {
		return new FxTargetLeverageSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetLeverageSequence, Set<String>> onlyExistsValidator() {
		return new FxTargetLeverageSequenceOnlyExistsValidator();
	}
}
