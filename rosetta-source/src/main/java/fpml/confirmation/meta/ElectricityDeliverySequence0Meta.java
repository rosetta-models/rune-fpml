package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDeliverySequence0;
import fpml.confirmation.validation.ElectricityDeliverySequence0TypeFormatValidator;
import fpml.confirmation.validation.ElectricityDeliverySequence0Validator;
import fpml.confirmation.validation.exists.ElectricityDeliverySequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ElectricityDeliverySequence0.class)
public class ElectricityDeliverySequence0Meta implements RosettaMetaData<ElectricityDeliverySequence0> {

	@Override
	public List<Validator<? super ElectricityDeliverySequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliverySequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityDeliverySequence0> validator() {
		return new ElectricityDeliverySequence0Validator();
	}

	@Override
	public Validator<? super ElectricityDeliverySequence0> typeFormatValidator() {
		return new ElectricityDeliverySequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliverySequence0, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliverySequence0OnlyExistsValidator();
	}
}
