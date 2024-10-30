package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MessageHeader;
import fpml.confirmation.validation.MessageHeaderTypeFormatValidator;
import fpml.confirmation.validation.MessageHeaderValidator;
import fpml.confirmation.validation.exists.MessageHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MessageHeader.class)
public class MessageHeaderMeta implements RosettaMetaData<MessageHeader> {

	@Override
	public List<Validator<? super MessageHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MessageHeader> validator() {
		return new MessageHeaderValidator();
	}

	@Override
	public Validator<? super MessageHeader> typeFormatValidator() {
		return new MessageHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageHeader, Set<String>> onlyExistsValidator() {
		return new MessageHeaderOnlyExistsValidator();
	}
}
