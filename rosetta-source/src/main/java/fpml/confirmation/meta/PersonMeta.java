package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Person;
import fpml.confirmation.validation.PersonTypeFormatValidator;
import fpml.confirmation.validation.PersonValidator;
import fpml.confirmation.validation.exists.PersonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Person.class)
public class PersonMeta implements RosettaMetaData<Person> {

	@Override
	public List<Validator<? super Person>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Person, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Person> validator() {
		return new PersonValidator();
	}

	@Override
	public Validator<? super Person> typeFormatValidator() {
		return new PersonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Person, Set<String>> onlyExistsValidator() {
		return new PersonOnlyExistsValidator();
	}
}
