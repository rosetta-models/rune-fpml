package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixingScheduleSimpleSequence;
import fpml.confirmation.validation.FxFixingScheduleSimpleSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxFixingScheduleSimpleSequenceValidator;
import fpml.confirmation.validation.exists.FxFixingScheduleSimpleSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxFixingScheduleSimpleSequence.class)
public class FxFixingScheduleSimpleSequenceMeta implements RosettaMetaData<FxFixingScheduleSimpleSequence> {

	@Override
	public List<Validator<? super FxFixingScheduleSimpleSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFixingScheduleSimpleSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFixingScheduleSimpleSequence> validator() {
		return new FxFixingScheduleSimpleSequenceValidator();
	}

	@Override
	public Validator<? super FxFixingScheduleSimpleSequence> typeFormatValidator() {
		return new FxFixingScheduleSimpleSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingScheduleSimpleSequence, Set<String>> onlyExistsValidator() {
		return new FxFixingScheduleSimpleSequenceOnlyExistsValidator();
	}
}
