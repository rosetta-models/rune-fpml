package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ObligationAccelerationEvent;
import fpml.confirmation.validation.ObligationAccelerationEventTypeFormatValidator;
import fpml.confirmation.validation.ObligationAccelerationEventValidator;
import fpml.confirmation.validation.exists.ObligationAccelerationEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ObligationAccelerationEvent.class)
public class ObligationAccelerationEventMeta implements RosettaMetaData<ObligationAccelerationEvent> {

	@Override
	public List<Validator<? super ObligationAccelerationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObligationAccelerationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ObligationAccelerationEvent> validator() {
		return new ObligationAccelerationEventValidator();
	}

	@Override
	public Validator<? super ObligationAccelerationEvent> typeFormatValidator() {
		return new ObligationAccelerationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObligationAccelerationEvent, Set<String>> onlyExistsValidator() {
		return new ObligationAccelerationEventOnlyExistsValidator();
	}
}
