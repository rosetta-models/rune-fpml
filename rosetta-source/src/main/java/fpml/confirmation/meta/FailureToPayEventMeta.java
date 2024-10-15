package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FailureToPayEvent;
import fpml.confirmation.validation.FailureToPayEventTypeFormatValidator;
import fpml.confirmation.validation.FailureToPayEventValidator;
import fpml.confirmation.validation.exists.FailureToPayEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FailureToPayEvent.class)
public class FailureToPayEventMeta implements RosettaMetaData<FailureToPayEvent> {

	@Override
	public List<Validator<? super FailureToPayEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FailureToPayEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FailureToPayEvent> validator() {
		return new FailureToPayEventValidator();
	}

	@Override
	public Validator<? super FailureToPayEvent> typeFormatValidator() {
		return new FailureToPayEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FailureToPayEvent, Set<String>> onlyExistsValidator() {
		return new FailureToPayEventOnlyExistsValidator();
	}
}
