package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantitySchedule;
import fpml.confirmation.validation.ElectricityPhysicalDeliveryQuantityScheduleTypeFormatValidator;
import fpml.confirmation.validation.ElectricityPhysicalDeliveryQuantityScheduleValidator;
import fpml.confirmation.validation.exists.ElectricityPhysicalDeliveryQuantityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ElectricityPhysicalDeliveryQuantitySchedule.class)
public class ElectricityPhysicalDeliveryQuantityScheduleMeta implements RosettaMetaData<ElectricityPhysicalDeliveryQuantitySchedule> {

	@Override
	public List<Validator<? super ElectricityPhysicalDeliveryQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityPhysicalDeliveryQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantitySchedule> validator() {
		return new ElectricityPhysicalDeliveryQuantityScheduleValidator();
	}

	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantitySchedule> typeFormatValidator() {
		return new ElectricityPhysicalDeliveryQuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityPhysicalDeliveryQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new ElectricityPhysicalDeliveryQuantityScheduleOnlyExistsValidator();
	}
}
