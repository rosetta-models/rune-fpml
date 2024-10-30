package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventId;
import fpml.confirmation.validation.EventIdTypeFormatValidator;
import fpml.confirmation.validation.EventIdValidator;
import fpml.confirmation.validation.exists.EventIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EventId.class)
public class EventIdMeta implements RosettaMetaData<EventId> {

	@Override
	public List<Validator<? super EventId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventId> validator() {
		return new EventIdValidator();
	}

	@Override
	public Validator<? super EventId> typeFormatValidator() {
		return new EventIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventId, Set<String>> onlyExistsValidator() {
		return new EventIdOnlyExistsValidator();
	}
}
