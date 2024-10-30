package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AlgorithmRole;
import fpml.confirmation.validation.AlgorithmRoleTypeFormatValidator;
import fpml.confirmation.validation.AlgorithmRoleValidator;
import fpml.confirmation.validation.exists.AlgorithmRoleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AlgorithmRole.class)
public class AlgorithmRoleMeta implements RosettaMetaData<AlgorithmRole> {

	@Override
	public List<Validator<? super AlgorithmRole>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AlgorithmRole, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AlgorithmRole> validator() {
		return new AlgorithmRoleValidator();
	}

	@Override
	public Validator<? super AlgorithmRole> typeFormatValidator() {
		return new AlgorithmRoleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AlgorithmRole, Set<String>> onlyExistsValidator() {
		return new AlgorithmRoleOnlyExistsValidator();
	}
}
