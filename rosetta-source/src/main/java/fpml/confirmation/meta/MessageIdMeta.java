package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MessageId;
import fpml.confirmation.validation.MessageIdTypeFormatValidator;
import fpml.confirmation.validation.MessageIdValidator;
import fpml.confirmation.validation.exists.MessageIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MessageId.class)
public class MessageIdMeta implements RosettaMetaData<MessageId> {

	@Override
	public List<Validator<? super MessageId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MessageId> validator() {
		return new MessageIdValidator();
	}

	@Override
	public Validator<? super MessageId> typeFormatValidator() {
		return new MessageIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageId, Set<String>> onlyExistsValidator() {
		return new MessageIdOnlyExistsValidator();
	}
}
