package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanServicingEvent;
import fpml.confirmation.validation.AbstractLoanServicingEventTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanServicingEventValidator;
import fpml.confirmation.validation.exists.AbstractLoanServicingEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractLoanServicingEvent.class)
public class AbstractLoanServicingEventMeta implements RosettaMetaData<AbstractLoanServicingEvent> {

	@Override
	public List<Validator<? super AbstractLoanServicingEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanServicingEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanServicingEvent> validator() {
		return new AbstractLoanServicingEventValidator();
	}

	@Override
	public Validator<? super AbstractLoanServicingEvent> typeFormatValidator() {
		return new AbstractLoanServicingEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanServicingEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanServicingEventOnlyExistsValidator();
	}
}
