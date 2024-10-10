package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantitySchedule;
import fpml.confirmation.validation.CommoditySettlementPeriodsNotionalQuantityScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommoditySettlementPeriodsNotionalQuantityScheduleValidator;
import fpml.confirmation.validation.exists.CommoditySettlementPeriodsNotionalQuantityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommoditySettlementPeriodsNotionalQuantitySchedule.class)
public class CommoditySettlementPeriodsNotionalQuantityScheduleMeta implements RosettaMetaData<CommoditySettlementPeriodsNotionalQuantitySchedule> {

	@Override
	public List<Validator<? super CommoditySettlementPeriodsNotionalQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySettlementPeriodsNotionalQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySettlementPeriodsNotionalQuantitySchedule> validator() {
		return new CommoditySettlementPeriodsNotionalQuantityScheduleValidator();
	}

	@Override
	public Validator<? super CommoditySettlementPeriodsNotionalQuantitySchedule> typeFormatValidator() {
		return new CommoditySettlementPeriodsNotionalQuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySettlementPeriodsNotionalQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new CommoditySettlementPeriodsNotionalQuantityScheduleOnlyExistsValidator();
	}
}
