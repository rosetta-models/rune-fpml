package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OtherAgreementType;
import fpml.confirmation.validation.OtherAgreementTypeTypeFormatValidator;
import fpml.confirmation.validation.OtherAgreementTypeValidator;
import fpml.confirmation.validation.exists.OtherAgreementTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OtherAgreementType.class)
public class OtherAgreementTypeMeta implements RosettaMetaData<OtherAgreementType> {

	@Override
	public List<Validator<? super OtherAgreementType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreementType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OtherAgreementType> validator() {
		return new OtherAgreementTypeValidator();
	}

	@Override
	public Validator<? super OtherAgreementType> typeFormatValidator() {
		return new OtherAgreementTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreementType, Set<String>> onlyExistsValidator() {
		return new OtherAgreementTypeOnlyExistsValidator();
	}
}
