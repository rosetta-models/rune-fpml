package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccountName;
import fpml.confirmation.validation.AccountNameTypeFormatValidator;
import fpml.confirmation.validation.AccountNameValidator;
import fpml.confirmation.validation.exists.AccountNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccountName.class)
public class AccountNameMeta implements RosettaMetaData<AccountName> {

	@Override
	public List<Validator<? super AccountName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccountName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccountName> validator() {
		return new AccountNameValidator();
	}

	@Override
	public Validator<? super AccountName> typeFormatValidator() {
		return new AccountNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccountName, Set<String>> onlyExistsValidator() {
		return new AccountNameOnlyExistsValidator();
	}
}
