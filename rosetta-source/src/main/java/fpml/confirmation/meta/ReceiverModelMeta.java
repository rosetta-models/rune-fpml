package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReceiverModel;
import fpml.confirmation.validation.ReceiverModelTypeFormatValidator;
import fpml.confirmation.validation.ReceiverModelValidator;
import fpml.confirmation.validation.exists.ReceiverModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReceiverModel.class)
public class ReceiverModelMeta implements RosettaMetaData<ReceiverModel> {

	@Override
	public List<Validator<? super ReceiverModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReceiverModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReceiverModel> validator() {
		return new ReceiverModelValidator();
	}

	@Override
	public Validator<? super ReceiverModel> typeFormatValidator() {
		return new ReceiverModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReceiverModel, Set<String>> onlyExistsValidator() {
		return new ReceiverModelOnlyExistsValidator();
	}
}
