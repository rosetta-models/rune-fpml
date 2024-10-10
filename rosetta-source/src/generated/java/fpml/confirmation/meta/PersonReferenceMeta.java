package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PersonReference;
import fpml.confirmation.validation.PersonReferenceTypeFormatValidator;
import fpml.confirmation.validation.PersonReferenceValidator;
import fpml.confirmation.validation.exists.PersonReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PersonReference.class)
public class PersonReferenceMeta implements RosettaMetaData<PersonReference> {

	@Override
	public List<Validator<? super PersonReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PersonReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PersonReference> validator() {
		return new PersonReferenceValidator();
	}

	@Override
	public Validator<? super PersonReference> typeFormatValidator() {
		return new PersonReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PersonReference, Set<String>> onlyExistsValidator() {
		return new PersonReferenceOnlyExistsValidator();
	}
}
