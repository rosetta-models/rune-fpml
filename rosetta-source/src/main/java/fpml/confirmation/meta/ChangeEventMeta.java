package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ChangeEvent;
import fpml.confirmation.validation.ChangeEventTypeFormatValidator;
import fpml.confirmation.validation.ChangeEventValidator;
import fpml.confirmation.validation.exists.ChangeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ChangeEvent.class)
public class ChangeEventMeta implements RosettaMetaData<ChangeEvent> {

	@Override
	public List<Validator<? super ChangeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ChangeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ChangeEvent> validator() {
		return new ChangeEventValidator();
	}

	@Override
	public Validator<? super ChangeEvent> typeFormatValidator() {
		return new ChangeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ChangeEvent, Set<String>> onlyExistsValidator() {
		return new ChangeEventOnlyExistsValidator();
	}
}
