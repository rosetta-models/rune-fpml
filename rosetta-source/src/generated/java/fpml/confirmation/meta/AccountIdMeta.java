package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccountId;
import fpml.confirmation.validation.AccountIdTypeFormatValidator;
import fpml.confirmation.validation.AccountIdValidator;
import fpml.confirmation.validation.exists.AccountIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccountId.class)
public class AccountIdMeta implements RosettaMetaData<AccountId> {

	@Override
	public List<Validator<? super AccountId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccountId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccountId> validator() {
		return new AccountIdValidator();
	}

	@Override
	public Validator<? super AccountId> typeFormatValidator() {
		return new AccountIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccountId, Set<String>> onlyExistsValidator() {
		return new AccountIdOnlyExistsValidator();
	}
}
