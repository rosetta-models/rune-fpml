package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalQuantitySchedule;
import fpml.confirmation.validation.CommodityPhysicalQuantityScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalQuantityScheduleValidator;
import fpml.confirmation.validation.exists.CommodityPhysicalQuantityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPhysicalQuantitySchedule.class)
public class CommodityPhysicalQuantityScheduleMeta implements RosettaMetaData<CommodityPhysicalQuantitySchedule> {

	@Override
	public List<Validator<? super CommodityPhysicalQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalQuantitySchedule> validator() {
		return new CommodityPhysicalQuantityScheduleValidator();
	}

	@Override
	public Validator<? super CommodityPhysicalQuantitySchedule> typeFormatValidator() {
		return new CommodityPhysicalQuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalQuantityScheduleOnlyExistsValidator();
	}
}
