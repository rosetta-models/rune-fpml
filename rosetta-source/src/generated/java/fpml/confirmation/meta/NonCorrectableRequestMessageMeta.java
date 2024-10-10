package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.validation.NonCorrectableRequestMessageTypeFormatValidator;
import fpml.confirmation.validation.NonCorrectableRequestMessageValidator;
import fpml.confirmation.validation.exists.NonCorrectableRequestMessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NonCorrectableRequestMessage.class)
public class NonCorrectableRequestMessageMeta implements RosettaMetaData<NonCorrectableRequestMessage> {

	@Override
	public List<Validator<? super NonCorrectableRequestMessage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonCorrectableRequestMessage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonCorrectableRequestMessage> validator() {
		return new NonCorrectableRequestMessageValidator();
	}

	@Override
	public Validator<? super NonCorrectableRequestMessage> typeFormatValidator() {
		return new NonCorrectableRequestMessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonCorrectableRequestMessage, Set<String>> onlyExistsValidator() {
		return new NonCorrectableRequestMessageOnlyExistsValidator();
	}
}
