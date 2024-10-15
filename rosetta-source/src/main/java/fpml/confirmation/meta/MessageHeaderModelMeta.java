package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MessageHeaderModel;
import fpml.confirmation.validation.MessageHeaderModelTypeFormatValidator;
import fpml.confirmation.validation.MessageHeaderModelValidator;
import fpml.confirmation.validation.exists.MessageHeaderModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MessageHeaderModel.class)
public class MessageHeaderModelMeta implements RosettaMetaData<MessageHeaderModel> {

	@Override
	public List<Validator<? super MessageHeaderModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageHeaderModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MessageHeaderModel> validator() {
		return new MessageHeaderModelValidator();
	}

	@Override
	public Validator<? super MessageHeaderModel> typeFormatValidator() {
		return new MessageHeaderModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageHeaderModel, Set<String>> onlyExistsValidator() {
		return new MessageHeaderModelOnlyExistsValidator();
	}
}
