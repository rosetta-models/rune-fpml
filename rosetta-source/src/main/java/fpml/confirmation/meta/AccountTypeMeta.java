package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccountType;
import fpml.confirmation.validation.AccountTypeTypeFormatValidator;
import fpml.confirmation.validation.AccountTypeValidator;
import fpml.confirmation.validation.exists.AccountTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccountType.class)
public class AccountTypeMeta implements RosettaMetaData<AccountType> {

	@Override
	public List<Validator<? super AccountType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccountType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccountType> validator() {
		return new AccountTypeValidator();
	}

	@Override
	public Validator<? super AccountType> typeFormatValidator() {
		return new AccountTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccountType, Set<String>> onlyExistsValidator() {
		return new AccountTypeOnlyExistsValidator();
	}
}
