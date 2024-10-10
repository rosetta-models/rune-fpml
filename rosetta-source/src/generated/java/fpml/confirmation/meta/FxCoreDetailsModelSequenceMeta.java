package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCoreDetailsModelSequence;
import fpml.confirmation.validation.FxCoreDetailsModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxCoreDetailsModelSequenceValidator;
import fpml.confirmation.validation.exists.FxCoreDetailsModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxCoreDetailsModelSequence.class)
public class FxCoreDetailsModelSequenceMeta implements RosettaMetaData<FxCoreDetailsModelSequence> {

	@Override
	public List<Validator<? super FxCoreDetailsModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxCoreDetailsModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxCoreDetailsModelSequence> validator() {
		return new FxCoreDetailsModelSequenceValidator();
	}

	@Override
	public Validator<? super FxCoreDetailsModelSequence> typeFormatValidator() {
		return new FxCoreDetailsModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCoreDetailsModelSequence, Set<String>> onlyExistsValidator() {
		return new FxCoreDetailsModelSequenceOnlyExistsValidator();
	}
}
