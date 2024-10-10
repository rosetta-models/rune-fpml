package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketIdentifierModelSequence;
import fpml.confirmation.validation.BasketIdentifierModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.BasketIdentifierModelSequenceValidator;
import fpml.confirmation.validation.exists.BasketIdentifierModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BasketIdentifierModelSequence.class)
public class BasketIdentifierModelSequenceMeta implements RosettaMetaData<BasketIdentifierModelSequence> {

	@Override
	public List<Validator<? super BasketIdentifierModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketIdentifierModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasketIdentifierModelSequence> validator() {
		return new BasketIdentifierModelSequenceValidator();
	}

	@Override
	public Validator<? super BasketIdentifierModelSequence> typeFormatValidator() {
		return new BasketIdentifierModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketIdentifierModelSequence, Set<String>> onlyExistsValidator() {
		return new BasketIdentifierModelSequenceOnlyExistsValidator();
	}
}
