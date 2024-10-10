package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventStatusResponse;
import fpml.confirmation.validation.EventStatusResponseTypeFormatValidator;
import fpml.confirmation.validation.EventStatusResponseValidator;
import fpml.confirmation.validation.exists.EventStatusResponseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EventStatusResponse.class)
public class EventStatusResponseMeta implements RosettaMetaData<EventStatusResponse> {

	@Override
	public List<Validator<? super EventStatusResponse>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventStatusResponse, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventStatusResponse> validator() {
		return new EventStatusResponseValidator();
	}

	@Override
	public Validator<? super EventStatusResponse> typeFormatValidator() {
		return new EventStatusResponseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventStatusResponse, Set<String>> onlyExistsValidator() {
		return new EventStatusResponseOnlyExistsValidator();
	}
}
