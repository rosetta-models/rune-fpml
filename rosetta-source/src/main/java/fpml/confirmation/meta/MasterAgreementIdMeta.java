package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MasterAgreementId;
import fpml.confirmation.validation.MasterAgreementIdTypeFormatValidator;
import fpml.confirmation.validation.MasterAgreementIdValidator;
import fpml.confirmation.validation.exists.MasterAgreementIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MasterAgreementId.class)
public class MasterAgreementIdMeta implements RosettaMetaData<MasterAgreementId> {

	@Override
	public List<Validator<? super MasterAgreementId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreementId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MasterAgreementId> validator() {
		return new MasterAgreementIdValidator();
	}

	@Override
	public Validator<? super MasterAgreementId> typeFormatValidator() {
		return new MasterAgreementIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreementId, Set<String>> onlyExistsValidator() {
		return new MasterAgreementIdOnlyExistsValidator();
	}
}
