package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MasterAgreement;
import fpml.confirmation.validation.MasterAgreementTypeFormatValidator;
import fpml.confirmation.validation.MasterAgreementValidator;
import fpml.confirmation.validation.exists.MasterAgreementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MasterAgreement.class)
public class MasterAgreementMeta implements RosettaMetaData<MasterAgreement> {

	@Override
	public List<Validator<? super MasterAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MasterAgreement> validator() {
		return new MasterAgreementValidator();
	}

	@Override
	public Validator<? super MasterAgreement> typeFormatValidator() {
		return new MasterAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreement, Set<String>> onlyExistsValidator() {
		return new MasterAgreementOnlyExistsValidator();
	}
}
