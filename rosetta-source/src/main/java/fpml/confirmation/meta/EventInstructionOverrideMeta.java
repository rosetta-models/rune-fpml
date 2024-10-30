package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventInstructionOverride;
import fpml.confirmation.validation.EventInstructionOverrideTypeFormatValidator;
import fpml.confirmation.validation.EventInstructionOverrideValidator;
import fpml.confirmation.validation.exists.EventInstructionOverrideOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EventInstructionOverride.class)
public class EventInstructionOverrideMeta implements RosettaMetaData<EventInstructionOverride> {

	@Override
	public List<Validator<? super EventInstructionOverride>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventInstructionOverride, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventInstructionOverride> validator() {
		return new EventInstructionOverrideValidator();
	}

	@Override
	public Validator<? super EventInstructionOverride> typeFormatValidator() {
		return new EventInstructionOverrideTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventInstructionOverride, Set<String>> onlyExistsValidator() {
		return new EventInstructionOverrideOnlyExistsValidator();
	}
}
