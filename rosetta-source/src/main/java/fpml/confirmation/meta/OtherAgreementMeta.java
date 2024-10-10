package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OtherAgreement;
import fpml.confirmation.validation.OtherAgreementTypeFormatValidator;
import fpml.confirmation.validation.OtherAgreementValidator;
import fpml.confirmation.validation.exists.OtherAgreementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OtherAgreement.class)
public class OtherAgreementMeta implements RosettaMetaData<OtherAgreement> {

	@Override
	public List<Validator<? super OtherAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OtherAgreement> validator() {
		return new OtherAgreementValidator();
	}

	@Override
	public Validator<? super OtherAgreement> typeFormatValidator() {
		return new OtherAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreement, Set<String>> onlyExistsValidator() {
		return new OtherAgreementOnlyExistsValidator();
	}
}
