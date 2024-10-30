package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.validation.CommodityCalculationPeriodsScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommodityCalculationPeriodsScheduleValidator;
import fpml.confirmation.validation.exists.CommodityCalculationPeriodsScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityCalculationPeriodsSchedule.class)
public class CommodityCalculationPeriodsScheduleMeta implements RosettaMetaData<CommodityCalculationPeriodsSchedule> {

	@Override
	public List<Validator<? super CommodityCalculationPeriodsSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityCalculationPeriodsSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityCalculationPeriodsSchedule> validator() {
		return new CommodityCalculationPeriodsScheduleValidator();
	}

	@Override
	public Validator<? super CommodityCalculationPeriodsSchedule> typeFormatValidator() {
		return new CommodityCalculationPeriodsScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityCalculationPeriodsSchedule, Set<String>> onlyExistsValidator() {
		return new CommodityCalculationPeriodsScheduleOnlyExistsValidator();
	}
}
