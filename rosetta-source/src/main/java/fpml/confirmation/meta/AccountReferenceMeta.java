package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccountReference;
import fpml.confirmation.validation.AccountReferenceTypeFormatValidator;
import fpml.confirmation.validation.AccountReferenceValidator;
import fpml.confirmation.validation.exists.AccountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccountReference.class)
public class AccountReferenceMeta implements RosettaMetaData<AccountReference> {

	@Override
	public List<Validator<? super AccountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccountReference> validator() {
		return new AccountReferenceValidator();
	}

	@Override
	public Validator<? super AccountReference> typeFormatValidator() {
		return new AccountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccountReference, Set<String>> onlyExistsValidator() {
		return new AccountReferenceOnlyExistsValidator();
	}
}
