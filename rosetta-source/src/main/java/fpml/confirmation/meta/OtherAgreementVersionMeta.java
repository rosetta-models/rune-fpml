package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OtherAgreementVersion;
import fpml.confirmation.validation.OtherAgreementVersionTypeFormatValidator;
import fpml.confirmation.validation.OtherAgreementVersionValidator;
import fpml.confirmation.validation.exists.OtherAgreementVersionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OtherAgreementVersion.class)
public class OtherAgreementVersionMeta implements RosettaMetaData<OtherAgreementVersion> {

	@Override
	public List<Validator<? super OtherAgreementVersion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreementVersion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OtherAgreementVersion> validator() {
		return new OtherAgreementVersionValidator();
	}

	@Override
	public Validator<? super OtherAgreementVersion> typeFormatValidator() {
		return new OtherAgreementVersionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreementVersion, Set<String>> onlyExistsValidator() {
		return new OtherAgreementVersionOnlyExistsValidator();
	}
}
