package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditSupportAgreementType;
import fpml.confirmation.validation.CreditSupportAgreementTypeTypeFormatValidator;
import fpml.confirmation.validation.CreditSupportAgreementTypeValidator;
import fpml.confirmation.validation.exists.CreditSupportAgreementTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditSupportAgreementType.class)
public class CreditSupportAgreementTypeMeta implements RosettaMetaData<CreditSupportAgreementType> {

	@Override
	public List<Validator<? super CreditSupportAgreementType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportAgreementType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditSupportAgreementType> validator() {
		return new CreditSupportAgreementTypeValidator();
	}

	@Override
	public Validator<? super CreditSupportAgreementType> typeFormatValidator() {
		return new CreditSupportAgreementTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportAgreementType, Set<String>> onlyExistsValidator() {
		return new CreditSupportAgreementTypeOnlyExistsValidator();
	}
}
