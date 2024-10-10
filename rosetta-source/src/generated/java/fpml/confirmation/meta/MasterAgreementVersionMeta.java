package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MasterAgreementVersion;
import fpml.confirmation.validation.MasterAgreementVersionTypeFormatValidator;
import fpml.confirmation.validation.MasterAgreementVersionValidator;
import fpml.confirmation.validation.exists.MasterAgreementVersionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MasterAgreementVersion.class)
public class MasterAgreementVersionMeta implements RosettaMetaData<MasterAgreementVersion> {

	@Override
	public List<Validator<? super MasterAgreementVersion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreementVersion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MasterAgreementVersion> validator() {
		return new MasterAgreementVersionValidator();
	}

	@Override
	public Validator<? super MasterAgreementVersion> typeFormatValidator() {
		return new MasterAgreementVersionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreementVersion, Set<String>> onlyExistsValidator() {
		return new MasterAgreementVersionOnlyExistsValidator();
	}
}
