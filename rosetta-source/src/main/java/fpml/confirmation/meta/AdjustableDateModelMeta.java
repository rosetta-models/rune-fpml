package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDateModel;
import fpml.confirmation.validation.AdjustableDateModelTypeFormatValidator;
import fpml.confirmation.validation.AdjustableDateModelValidator;
import fpml.confirmation.validation.exists.AdjustableDateModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AdjustableDateModel.class)
public class AdjustableDateModelMeta implements RosettaMetaData<AdjustableDateModel> {

	@Override
	public List<Validator<? super AdjustableDateModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustableDateModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableDateModel> validator() {
		return new AdjustableDateModelValidator();
	}

	@Override
	public Validator<? super AdjustableDateModel> typeFormatValidator() {
		return new AdjustableDateModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDateModel, Set<String>> onlyExistsValidator() {
		return new AdjustableDateModelOnlyExistsValidator();
	}
}
