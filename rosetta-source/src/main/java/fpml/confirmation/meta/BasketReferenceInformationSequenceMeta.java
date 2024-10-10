package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketReferenceInformationSequence;
import fpml.confirmation.validation.BasketReferenceInformationSequenceTypeFormatValidator;
import fpml.confirmation.validation.BasketReferenceInformationSequenceValidator;
import fpml.confirmation.validation.exists.BasketReferenceInformationSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BasketReferenceInformationSequence.class)
public class BasketReferenceInformationSequenceMeta implements RosettaMetaData<BasketReferenceInformationSequence> {

	@Override
	public List<Validator<? super BasketReferenceInformationSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketReferenceInformationSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasketReferenceInformationSequence> validator() {
		return new BasketReferenceInformationSequenceValidator();
	}

	@Override
	public Validator<? super BasketReferenceInformationSequence> typeFormatValidator() {
		return new BasketReferenceInformationSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketReferenceInformationSequence, Set<String>> onlyExistsValidator() {
		return new BasketReferenceInformationSequenceOnlyExistsValidator();
	}
}
