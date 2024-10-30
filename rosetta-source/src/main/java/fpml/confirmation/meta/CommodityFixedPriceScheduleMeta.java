package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedPriceSchedule;
import fpml.confirmation.validation.CommodityFixedPriceScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommodityFixedPriceScheduleValidator;
import fpml.confirmation.validation.exists.CommodityFixedPriceScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityFixedPriceSchedule.class)
public class CommodityFixedPriceScheduleMeta implements RosettaMetaData<CommodityFixedPriceSchedule> {

	@Override
	public List<Validator<? super CommodityFixedPriceSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityFixedPriceSchedule>create(fpml.confirmation.validation.datarule.CommodityFixedPriceScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFixedPriceSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFixedPriceSchedule> validator() {
		return new CommodityFixedPriceScheduleValidator();
	}

	@Override
	public Validator<? super CommodityFixedPriceSchedule> typeFormatValidator() {
		return new CommodityFixedPriceScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFixedPriceSchedule, Set<String>> onlyExistsValidator() {
		return new CommodityFixedPriceScheduleOnlyExistsValidator();
	}
}
