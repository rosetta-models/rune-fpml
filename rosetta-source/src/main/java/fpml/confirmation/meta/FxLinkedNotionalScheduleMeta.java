package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxLinkedNotionalSchedule;
import fpml.confirmation.validation.FxLinkedNotionalScheduleTypeFormatValidator;
import fpml.confirmation.validation.FxLinkedNotionalScheduleValidator;
import fpml.confirmation.validation.exists.FxLinkedNotionalScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxLinkedNotionalSchedule.class)
public class FxLinkedNotionalScheduleMeta implements RosettaMetaData<FxLinkedNotionalSchedule> {

	@Override
	public List<Validator<? super FxLinkedNotionalSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxLinkedNotionalSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxLinkedNotionalSchedule> validator() {
		return new FxLinkedNotionalScheduleValidator();
	}

	@Override
	public Validator<? super FxLinkedNotionalSchedule> typeFormatValidator() {
		return new FxLinkedNotionalScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxLinkedNotionalSchedule, Set<String>> onlyExistsValidator() {
		return new FxLinkedNotionalScheduleOnlyExistsValidator();
	}
}
