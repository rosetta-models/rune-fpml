package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Message;
import fpml.confirmation.validation.MessageTypeFormatValidator;
import fpml.confirmation.validation.MessageValidator;
import fpml.confirmation.validation.exists.MessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Message.class)
public class MessageMeta implements RosettaMetaData<Message> {

	@Override
	public List<Validator<? super Message>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Message, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Message> validator() {
		return new MessageValidator();
	}

	@Override
	public Validator<? super Message> typeFormatValidator() {
		return new MessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Message, Set<String>> onlyExistsValidator() {
		return new MessageOnlyExistsValidator();
	}
}
