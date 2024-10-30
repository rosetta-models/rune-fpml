package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.validation.AbstractLcEventTypeFormatValidator;
import fpml.confirmation.validation.AbstractLcEventValidator;
import fpml.confirmation.validation.exists.AbstractLcEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractLcEvent.class)
public class AbstractLcEventMeta implements RosettaMetaData<AbstractLcEvent> {

	@Override
	public List<Validator<? super AbstractLcEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLcEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLcEvent> validator() {
		return new AbstractLcEventValidator();
	}

	@Override
	public Validator<? super AbstractLcEvent> typeFormatValidator() {
		return new AbstractLcEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLcEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLcEventOnlyExistsValidator();
	}
}
