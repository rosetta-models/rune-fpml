package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LegalEntitySequence;
import fpml.confirmation.validation.LegalEntitySequenceTypeFormatValidator;
import fpml.confirmation.validation.LegalEntitySequenceValidator;
import fpml.confirmation.validation.exists.LegalEntitySequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LegalEntitySequence.class)
public class LegalEntitySequenceMeta implements RosettaMetaData<LegalEntitySequence> {

	@Override
	public List<Validator<? super LegalEntitySequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalEntitySequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LegalEntitySequence> validator() {
		return new LegalEntitySequenceValidator();
	}

	@Override
	public Validator<? super LegalEntitySequence> typeFormatValidator() {
		return new LegalEntitySequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalEntitySequence, Set<String>> onlyExistsValidator() {
		return new LegalEntitySequenceOnlyExistsValidator();
	}
}
