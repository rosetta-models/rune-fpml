package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TransactionCharacteristic;
import fpml.confirmation.validation.TransactionCharacteristicTypeFormatValidator;
import fpml.confirmation.validation.TransactionCharacteristicValidator;
import fpml.confirmation.validation.exists.TransactionCharacteristicOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TransactionCharacteristic.class)
public class TransactionCharacteristicMeta implements RosettaMetaData<TransactionCharacteristic> {

	@Override
	public List<Validator<? super TransactionCharacteristic>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransactionCharacteristic, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TransactionCharacteristic> validator() {
		return new TransactionCharacteristicValidator();
	}

	@Override
	public Validator<? super TransactionCharacteristic> typeFormatValidator() {
		return new TransactionCharacteristicTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransactionCharacteristic, Set<String>> onlyExistsValidator() {
		return new TransactionCharacteristicOnlyExistsValidator();
	}
}
