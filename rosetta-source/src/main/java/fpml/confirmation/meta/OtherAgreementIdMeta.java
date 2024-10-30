package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OtherAgreementId;
import fpml.confirmation.validation.OtherAgreementIdTypeFormatValidator;
import fpml.confirmation.validation.OtherAgreementIdValidator;
import fpml.confirmation.validation.exists.OtherAgreementIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OtherAgreementId.class)
public class OtherAgreementIdMeta implements RosettaMetaData<OtherAgreementId> {

	@Override
	public List<Validator<? super OtherAgreementId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreementId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OtherAgreementId> validator() {
		return new OtherAgreementIdValidator();
	}

	@Override
	public Validator<? super OtherAgreementId> typeFormatValidator() {
		return new OtherAgreementIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreementId, Set<String>> onlyExistsValidator() {
		return new OtherAgreementIdOnlyExistsValidator();
	}
}
