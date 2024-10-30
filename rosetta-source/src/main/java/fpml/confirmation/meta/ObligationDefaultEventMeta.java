package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ObligationDefaultEvent;
import fpml.confirmation.validation.ObligationDefaultEventTypeFormatValidator;
import fpml.confirmation.validation.ObligationDefaultEventValidator;
import fpml.confirmation.validation.exists.ObligationDefaultEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ObligationDefaultEvent.class)
public class ObligationDefaultEventMeta implements RosettaMetaData<ObligationDefaultEvent> {

	@Override
	public List<Validator<? super ObligationDefaultEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObligationDefaultEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ObligationDefaultEvent> validator() {
		return new ObligationDefaultEventValidator();
	}

	@Override
	public Validator<? super ObligationDefaultEvent> typeFormatValidator() {
		return new ObligationDefaultEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObligationDefaultEvent, Set<String>> onlyExistsValidator() {
		return new ObligationDefaultEventOnlyExistsValidator();
	}
}
