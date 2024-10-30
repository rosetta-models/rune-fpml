package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditSupportAgreementIdentifier;
import fpml.confirmation.validation.CreditSupportAgreementIdentifierTypeFormatValidator;
import fpml.confirmation.validation.CreditSupportAgreementIdentifierValidator;
import fpml.confirmation.validation.exists.CreditSupportAgreementIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditSupportAgreementIdentifier.class)
public class CreditSupportAgreementIdentifierMeta implements RosettaMetaData<CreditSupportAgreementIdentifier> {

	@Override
	public List<Validator<? super CreditSupportAgreementIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportAgreementIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditSupportAgreementIdentifier> validator() {
		return new CreditSupportAgreementIdentifierValidator();
	}

	@Override
	public Validator<? super CreditSupportAgreementIdentifier> typeFormatValidator() {
		return new CreditSupportAgreementIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportAgreementIdentifier, Set<String>> onlyExistsValidator() {
		return new CreditSupportAgreementIdentifierOnlyExistsValidator();
	}
}
