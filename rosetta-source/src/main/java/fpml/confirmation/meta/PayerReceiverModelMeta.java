package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.validation.PayerReceiverModelTypeFormatValidator;
import fpml.confirmation.validation.PayerReceiverModelValidator;
import fpml.confirmation.validation.exists.PayerReceiverModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PayerReceiverModel.class)
public class PayerReceiverModelMeta implements RosettaMetaData<PayerReceiverModel> {

	@Override
	public List<Validator<? super PayerReceiverModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PayerReceiverModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PayerReceiverModel> validator() {
		return new PayerReceiverModelValidator();
	}

	@Override
	public Validator<? super PayerReceiverModel> typeFormatValidator() {
		return new PayerReceiverModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PayerReceiverModel, Set<String>> onlyExistsValidator() {
		return new PayerReceiverModelOnlyExistsValidator();
	}
}
