package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartySequence;
import fpml.confirmation.validation.PartySequenceTypeFormatValidator;
import fpml.confirmation.validation.PartySequenceValidator;
import fpml.confirmation.validation.exists.PartySequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartySequence.class)
public class PartySequenceMeta implements RosettaMetaData<PartySequence> {

	@Override
	public List<Validator<? super PartySequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartySequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartySequence> validator() {
		return new PartySequenceValidator();
	}

	@Override
	public Validator<? super PartySequence> typeFormatValidator() {
		return new PartySequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartySequence, Set<String>> onlyExistsValidator() {
		return new PartySequenceOnlyExistsValidator();
	}
}
