package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTouchSequenceSequence;
import fpml.confirmation.validation.FxTouchSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxTouchSequenceSequenceValidator;
import fpml.confirmation.validation.exists.FxTouchSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTouchSequenceSequence.class)
public class FxTouchSequenceSequenceMeta implements RosettaMetaData<FxTouchSequenceSequence> {

	@Override
	public List<Validator<? super FxTouchSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTouchSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTouchSequenceSequence> validator() {
		return new FxTouchSequenceSequenceValidator();
	}

	@Override
	public Validator<? super FxTouchSequenceSequence> typeFormatValidator() {
		return new FxTouchSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTouchSequenceSequence, Set<String>> onlyExistsValidator() {
		return new FxTouchSequenceSequenceOnlyExistsValidator();
	}
}
