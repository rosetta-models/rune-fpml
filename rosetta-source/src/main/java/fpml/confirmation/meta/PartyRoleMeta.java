package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyRole;
import fpml.confirmation.validation.PartyRoleTypeFormatValidator;
import fpml.confirmation.validation.PartyRoleValidator;
import fpml.confirmation.validation.exists.PartyRoleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyRole.class)
public class PartyRoleMeta implements RosettaMetaData<PartyRole> {

	@Override
	public List<Validator<? super PartyRole>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyRole, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyRole> validator() {
		return new PartyRoleValidator();
	}

	@Override
	public Validator<? super PartyRole> typeFormatValidator() {
		return new PartyRoleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyRole, Set<String>> onlyExistsValidator() {
		return new PartyRoleOnlyExistsValidator();
	}
}
