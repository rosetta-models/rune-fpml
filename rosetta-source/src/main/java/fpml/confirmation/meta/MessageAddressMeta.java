package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MessageAddress;
import fpml.confirmation.validation.MessageAddressTypeFormatValidator;
import fpml.confirmation.validation.MessageAddressValidator;
import fpml.confirmation.validation.exists.MessageAddressOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MessageAddress.class)
public class MessageAddressMeta implements RosettaMetaData<MessageAddress> {

	@Override
	public List<Validator<? super MessageAddress>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageAddress, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MessageAddress> validator() {
		return new MessageAddressValidator();
	}

	@Override
	public Validator<? super MessageAddress> typeFormatValidator() {
		return new MessageAddressTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageAddress, Set<String>> onlyExistsValidator() {
		return new MessageAddressOnlyExistsValidator();
	}
}
