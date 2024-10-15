package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.validation.TerminatingEventTypeFormatValidator;
import fpml.confirmation.validation.TerminatingEventValidator;
import fpml.confirmation.validation.exists.TerminatingEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TerminatingEvent.class)
public class TerminatingEventMeta implements RosettaMetaData<TerminatingEvent> {

	@Override
	public List<Validator<? super TerminatingEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TerminatingEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TerminatingEvent> validator() {
		return new TerminatingEventValidator();
	}

	@Override
	public Validator<? super TerminatingEvent> typeFormatValidator() {
		return new TerminatingEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminatingEvent, Set<String>> onlyExistsValidator() {
		return new TerminatingEventOnlyExistsValidator();
	}
}
