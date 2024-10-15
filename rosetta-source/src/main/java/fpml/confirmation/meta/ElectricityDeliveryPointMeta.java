package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDeliveryPoint;
import fpml.confirmation.validation.ElectricityDeliveryPointTypeFormatValidator;
import fpml.confirmation.validation.ElectricityDeliveryPointValidator;
import fpml.confirmation.validation.exists.ElectricityDeliveryPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ElectricityDeliveryPoint.class)
public class ElectricityDeliveryPointMeta implements RosettaMetaData<ElectricityDeliveryPoint> {

	@Override
	public List<Validator<? super ElectricityDeliveryPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliveryPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityDeliveryPoint> validator() {
		return new ElectricityDeliveryPointValidator();
	}

	@Override
	public Validator<? super ElectricityDeliveryPoint> typeFormatValidator() {
		return new ElectricityDeliveryPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliveryPoint, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryPointOnlyExistsValidator();
	}
}
