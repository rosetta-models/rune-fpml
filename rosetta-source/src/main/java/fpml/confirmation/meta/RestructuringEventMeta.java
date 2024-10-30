package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RestructuringEvent;
import fpml.confirmation.validation.RestructuringEventTypeFormatValidator;
import fpml.confirmation.validation.RestructuringEventValidator;
import fpml.confirmation.validation.exists.RestructuringEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RestructuringEvent.class)
public class RestructuringEventMeta implements RosettaMetaData<RestructuringEvent> {

	@Override
	public List<Validator<? super RestructuringEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RestructuringEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RestructuringEvent> validator() {
		return new RestructuringEventValidator();
	}

	@Override
	public Validator<? super RestructuringEvent> typeFormatValidator() {
		return new RestructuringEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RestructuringEvent, Set<String>> onlyExistsValidator() {
		return new RestructuringEventOnlyExistsValidator();
	}
}
