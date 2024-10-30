package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityStrikeSchedule;
import fpml.confirmation.validation.CommodityStrikeScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommodityStrikeScheduleValidator;
import fpml.confirmation.validation.exists.CommodityStrikeScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityStrikeSchedule.class)
public class CommodityStrikeScheduleMeta implements RosettaMetaData<CommodityStrikeSchedule> {

	@Override
	public List<Validator<? super CommodityStrikeSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityStrikeSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityStrikeSchedule> validator() {
		return new CommodityStrikeScheduleValidator();
	}

	@Override
	public Validator<? super CommodityStrikeSchedule> typeFormatValidator() {
		return new CommodityStrikeScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityStrikeSchedule, Set<String>> onlyExistsValidator() {
		return new CommodityStrikeScheduleOnlyExistsValidator();
	}
}
