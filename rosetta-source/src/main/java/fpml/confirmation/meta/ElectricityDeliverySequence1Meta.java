package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDeliverySequence1;
import fpml.confirmation.validation.ElectricityDeliverySequence1TypeFormatValidator;
import fpml.confirmation.validation.ElectricityDeliverySequence1Validator;
import fpml.confirmation.validation.exists.ElectricityDeliverySequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ElectricityDeliverySequence1.class)
public class ElectricityDeliverySequence1Meta implements RosettaMetaData<ElectricityDeliverySequence1> {

	@Override
	public List<Validator<? super ElectricityDeliverySequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliverySequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityDeliverySequence1> validator() {
		return new ElectricityDeliverySequence1Validator();
	}

	@Override
	public Validator<? super ElectricityDeliverySequence1> typeFormatValidator() {
		return new ElectricityDeliverySequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliverySequence1, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliverySequence1OnlyExistsValidator();
	}
}
