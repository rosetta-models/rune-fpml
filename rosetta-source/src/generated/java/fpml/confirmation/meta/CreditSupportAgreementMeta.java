package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditSupportAgreement;
import fpml.confirmation.validation.CreditSupportAgreementTypeFormatValidator;
import fpml.confirmation.validation.CreditSupportAgreementValidator;
import fpml.confirmation.validation.exists.CreditSupportAgreementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditSupportAgreement.class)
public class CreditSupportAgreementMeta implements RosettaMetaData<CreditSupportAgreement> {

	@Override
	public List<Validator<? super CreditSupportAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditSupportAgreement> validator() {
		return new CreditSupportAgreementValidator();
	}

	@Override
	public Validator<? super CreditSupportAgreement> typeFormatValidator() {
		return new CreditSupportAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportAgreement, Set<String>> onlyExistsValidator() {
		return new CreditSupportAgreementOnlyExistsValidator();
	}
}
