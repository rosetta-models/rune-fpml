package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeliveryNearby;
import fpml.confirmation.validation.DeliveryNearbyTypeFormatValidator;
import fpml.confirmation.validation.DeliveryNearbyValidator;
import fpml.confirmation.validation.exists.DeliveryNearbyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DeliveryNearby.class)
public class DeliveryNearbyMeta implements RosettaMetaData<DeliveryNearby> {

	@Override
	public List<Validator<? super DeliveryNearby>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeliveryNearby, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DeliveryNearby> validator() {
		return new DeliveryNearbyValidator();
	}

	@Override
	public Validator<? super DeliveryNearby> typeFormatValidator() {
		return new DeliveryNearbyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliveryNearby, Set<String>> onlyExistsValidator() {
		return new DeliveryNearbyOnlyExistsValidator();
	}
}
