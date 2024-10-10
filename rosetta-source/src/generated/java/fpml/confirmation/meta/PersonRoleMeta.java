package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PersonRole;
import fpml.confirmation.validation.PersonRoleTypeFormatValidator;
import fpml.confirmation.validation.PersonRoleValidator;
import fpml.confirmation.validation.exists.PersonRoleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PersonRole.class)
public class PersonRoleMeta implements RosettaMetaData<PersonRole> {

	@Override
	public List<Validator<? super PersonRole>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PersonRole, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PersonRole> validator() {
		return new PersonRoleValidator();
	}

	@Override
	public Validator<? super PersonRole> typeFormatValidator() {
		return new PersonRoleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PersonRole, Set<String>> onlyExistsValidator() {
		return new PersonRoleOnlyExistsValidator();
	}
}
