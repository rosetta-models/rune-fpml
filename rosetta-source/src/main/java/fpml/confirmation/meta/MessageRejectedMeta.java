package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MessageRejected;
import fpml.confirmation.validation.MessageRejectedTypeFormatValidator;
import fpml.confirmation.validation.MessageRejectedValidator;
import fpml.confirmation.validation.exists.MessageRejectedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MessageRejected.class)
public class MessageRejectedMeta implements RosettaMetaData<MessageRejected> {

	@Override
	public List<Validator<? super MessageRejected>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageRejected, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MessageRejected> validator() {
		return new MessageRejectedValidator();
	}

	@Override
	public Validator<? super MessageRejected> typeFormatValidator() {
		return new MessageRejectedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageRejected, Set<String>> onlyExistsValidator() {
		return new MessageRejectedOnlyExistsValidator();
	}
}
