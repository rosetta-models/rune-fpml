package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTouchSequence;
import fpml.confirmation.validation.FxTouchSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxTouchSequenceValidator;
import fpml.confirmation.validation.exists.FxTouchSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTouchSequence.class)
public class FxTouchSequenceMeta implements RosettaMetaData<FxTouchSequence> {

	@Override
	public List<Validator<? super FxTouchSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTouchSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTouchSequence> validator() {
		return new FxTouchSequenceValidator();
	}

	@Override
	public Validator<? super FxTouchSequence> typeFormatValidator() {
		return new FxTouchSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTouchSequence, Set<String>> onlyExistsValidator() {
		return new FxTouchSequenceOnlyExistsValidator();
	}
}
