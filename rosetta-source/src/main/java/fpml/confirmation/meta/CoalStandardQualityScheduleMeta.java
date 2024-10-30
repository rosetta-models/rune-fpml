package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalStandardQualitySchedule;
import fpml.confirmation.validation.CoalStandardQualityScheduleTypeFormatValidator;
import fpml.confirmation.validation.CoalStandardQualityScheduleValidator;
import fpml.confirmation.validation.exists.CoalStandardQualityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalStandardQualitySchedule.class)
public class CoalStandardQualityScheduleMeta implements RosettaMetaData<CoalStandardQualitySchedule> {

	@Override
	public List<Validator<? super CoalStandardQualitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalStandardQualitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalStandardQualitySchedule> validator() {
		return new CoalStandardQualityScheduleValidator();
	}

	@Override
	public Validator<? super CoalStandardQualitySchedule> typeFormatValidator() {
		return new CoalStandardQualityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalStandardQualitySchedule, Set<String>> onlyExistsValidator() {
		return new CoalStandardQualityScheduleOnlyExistsValidator();
	}
}
