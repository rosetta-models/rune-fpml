package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractEvent;
import fpml.confirmation.validation.AbstractEventTypeFormatValidator;
import fpml.confirmation.validation.AbstractEventValidator;
import fpml.confirmation.validation.exists.AbstractEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractEvent.class)
public class AbstractEventMeta implements RosettaMetaData<AbstractEvent> {

	@Override
	public List<Validator<? super AbstractEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractEvent> validator() {
		return new AbstractEventValidator();
	}

	@Override
	public Validator<? super AbstractEvent> typeFormatValidator() {
		return new AbstractEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractEvent, Set<String>> onlyExistsValidator() {
		return new AbstractEventOnlyExistsValidator();
	}
}
