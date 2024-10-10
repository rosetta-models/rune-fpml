package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalQuantitySchedule;
import fpml.confirmation.validation.CommodityNotionalQuantityScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommodityNotionalQuantityScheduleValidator;
import fpml.confirmation.validation.exists.CommodityNotionalQuantityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityNotionalQuantitySchedule.class)
public class CommodityNotionalQuantityScheduleMeta implements RosettaMetaData<CommodityNotionalQuantitySchedule> {

	@Override
	public List<Validator<? super CommodityNotionalQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityNotionalQuantitySchedule>create(fpml.confirmation.validation.datarule.CommodityNotionalQuantityScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityNotionalQuantitySchedule> validator() {
		return new CommodityNotionalQuantityScheduleValidator();
	}

	@Override
	public Validator<? super CommodityNotionalQuantitySchedule> typeFormatValidator() {
		return new CommodityNotionalQuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalQuantityScheduleOnlyExistsValidator();
	}
}
