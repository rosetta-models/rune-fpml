package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasDeliveryPoint;
import fpml.confirmation.validation.GasDeliveryPointTypeFormatValidator;
import fpml.confirmation.validation.GasDeliveryPointValidator;
import fpml.confirmation.validation.exists.GasDeliveryPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GasDeliveryPoint.class)
public class GasDeliveryPointMeta implements RosettaMetaData<GasDeliveryPoint> {

	@Override
	public List<Validator<? super GasDeliveryPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GasDeliveryPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasDeliveryPoint> validator() {
		return new GasDeliveryPointValidator();
	}

	@Override
	public Validator<? super GasDeliveryPoint> typeFormatValidator() {
		return new GasDeliveryPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasDeliveryPoint, Set<String>> onlyExistsValidator() {
		return new GasDeliveryPointOnlyExistsValidator();
	}
}
