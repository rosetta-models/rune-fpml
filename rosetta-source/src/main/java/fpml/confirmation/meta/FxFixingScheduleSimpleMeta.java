package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixingScheduleSimple;
import fpml.confirmation.validation.FxFixingScheduleSimpleTypeFormatValidator;
import fpml.confirmation.validation.FxFixingScheduleSimpleValidator;
import fpml.confirmation.validation.exists.FxFixingScheduleSimpleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxFixingScheduleSimple.class)
public class FxFixingScheduleSimpleMeta implements RosettaMetaData<FxFixingScheduleSimple> {

	@Override
	public List<Validator<? super FxFixingScheduleSimple>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxFixingScheduleSimple>create(fpml.confirmation.validation.datarule.FxFixingScheduleSimpleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxFixingScheduleSimple, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFixingScheduleSimple> validator() {
		return new FxFixingScheduleSimpleValidator();
	}

	@Override
	public Validator<? super FxFixingScheduleSimple> typeFormatValidator() {
		return new FxFixingScheduleSimpleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingScheduleSimple, Set<String>> onlyExistsValidator() {
		return new FxFixingScheduleSimpleOnlyExistsValidator();
	}
}
