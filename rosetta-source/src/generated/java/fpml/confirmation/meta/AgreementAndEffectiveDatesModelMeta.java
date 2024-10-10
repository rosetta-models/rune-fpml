package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.validation.AgreementAndEffectiveDatesModelTypeFormatValidator;
import fpml.confirmation.validation.AgreementAndEffectiveDatesModelValidator;
import fpml.confirmation.validation.exists.AgreementAndEffectiveDatesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AgreementAndEffectiveDatesModel.class)
public class AgreementAndEffectiveDatesModelMeta implements RosettaMetaData<AgreementAndEffectiveDatesModel> {

	@Override
	public List<Validator<? super AgreementAndEffectiveDatesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgreementAndEffectiveDatesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AgreementAndEffectiveDatesModel> validator() {
		return new AgreementAndEffectiveDatesModelValidator();
	}

	@Override
	public Validator<? super AgreementAndEffectiveDatesModel> typeFormatValidator() {
		return new AgreementAndEffectiveDatesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgreementAndEffectiveDatesModel, Set<String>> onlyExistsValidator() {
		return new AgreementAndEffectiveDatesModelOnlyExistsValidator();
	}
}
