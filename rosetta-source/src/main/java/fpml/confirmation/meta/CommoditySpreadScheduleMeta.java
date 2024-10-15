package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySpreadSchedule;
import fpml.confirmation.validation.CommoditySpreadScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommoditySpreadScheduleValidator;
import fpml.confirmation.validation.exists.CommoditySpreadScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommoditySpreadSchedule.class)
public class CommoditySpreadScheduleMeta implements RosettaMetaData<CommoditySpreadSchedule> {

	@Override
	public List<Validator<? super CommoditySpreadSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySpreadSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySpreadSchedule> validator() {
		return new CommoditySpreadScheduleValidator();
	}

	@Override
	public Validator<? super CommoditySpreadSchedule> typeFormatValidator() {
		return new CommoditySpreadScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySpreadSchedule, Set<String>> onlyExistsValidator() {
		return new CommoditySpreadScheduleOnlyExistsValidator();
	}
}
