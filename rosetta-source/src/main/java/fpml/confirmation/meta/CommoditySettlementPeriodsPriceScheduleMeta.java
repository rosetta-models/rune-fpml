package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule;
import fpml.confirmation.validation.CommoditySettlementPeriodsPriceScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommoditySettlementPeriodsPriceScheduleValidator;
import fpml.confirmation.validation.exists.CommoditySettlementPeriodsPriceScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommoditySettlementPeriodsPriceSchedule.class)
public class CommoditySettlementPeriodsPriceScheduleMeta implements RosettaMetaData<CommoditySettlementPeriodsPriceSchedule> {

	@Override
	public List<Validator<? super CommoditySettlementPeriodsPriceSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySettlementPeriodsPriceSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySettlementPeriodsPriceSchedule> validator() {
		return new CommoditySettlementPeriodsPriceScheduleValidator();
	}

	@Override
	public Validator<? super CommoditySettlementPeriodsPriceSchedule> typeFormatValidator() {
		return new CommoditySettlementPeriodsPriceScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySettlementPeriodsPriceSchedule, Set<String>> onlyExistsValidator() {
		return new CommoditySettlementPeriodsPriceScheduleOnlyExistsValidator();
	}
}
