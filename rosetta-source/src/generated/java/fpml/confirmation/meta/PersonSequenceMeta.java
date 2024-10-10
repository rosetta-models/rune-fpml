package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PersonSequence;
import fpml.confirmation.validation.PersonSequenceTypeFormatValidator;
import fpml.confirmation.validation.PersonSequenceValidator;
import fpml.confirmation.validation.exists.PersonSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PersonSequence.class)
public class PersonSequenceMeta implements RosettaMetaData<PersonSequence> {

	@Override
	public List<Validator<? super PersonSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PersonSequence>create(fpml.confirmation.validation.datarule.PersonSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PersonSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PersonSequence> validator() {
		return new PersonSequenceValidator();
	}

	@Override
	public Validator<? super PersonSequence> typeFormatValidator() {
		return new PersonSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PersonSequence, Set<String>> onlyExistsValidator() {
		return new PersonSequenceOnlyExistsValidator();
	}
}
