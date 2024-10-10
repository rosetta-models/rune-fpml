package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalDeliveryPoint;
import fpml.confirmation.validation.CoalDeliveryPointTypeFormatValidator;
import fpml.confirmation.validation.CoalDeliveryPointValidator;
import fpml.confirmation.validation.exists.CoalDeliveryPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CoalDeliveryPoint.class)
public class CoalDeliveryPointMeta implements RosettaMetaData<CoalDeliveryPoint> {

	@Override
	public List<Validator<? super CoalDeliveryPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalDeliveryPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalDeliveryPoint> validator() {
		return new CoalDeliveryPointValidator();
	}

	@Override
	public Validator<? super CoalDeliveryPoint> typeFormatValidator() {
		return new CoalDeliveryPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalDeliveryPoint, Set<String>> onlyExistsValidator() {
		return new CoalDeliveryPointOnlyExistsValidator();
	}
}
