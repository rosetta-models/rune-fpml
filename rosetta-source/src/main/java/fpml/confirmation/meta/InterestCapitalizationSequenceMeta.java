package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestCapitalizationSequence;
import fpml.confirmation.validation.InterestCapitalizationSequenceTypeFormatValidator;
import fpml.confirmation.validation.InterestCapitalizationSequenceValidator;
import fpml.confirmation.validation.exists.InterestCapitalizationSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InterestCapitalizationSequence.class)
public class InterestCapitalizationSequenceMeta implements RosettaMetaData<InterestCapitalizationSequence> {

	@Override
	public List<Validator<? super InterestCapitalizationSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestCapitalizationSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestCapitalizationSequence> validator() {
		return new InterestCapitalizationSequenceValidator();
	}

	@Override
	public Validator<? super InterestCapitalizationSequence> typeFormatValidator() {
		return new InterestCapitalizationSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestCapitalizationSequence, Set<String>> onlyExistsValidator() {
		return new InterestCapitalizationSequenceOnlyExistsValidator();
	}
}
