package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IdentifiedPayerReceiver;
import fpml.confirmation.validation.IdentifiedPayerReceiverTypeFormatValidator;
import fpml.confirmation.validation.IdentifiedPayerReceiverValidator;
import fpml.confirmation.validation.exists.IdentifiedPayerReceiverOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=IdentifiedPayerReceiver.class)
public class IdentifiedPayerReceiverMeta implements RosettaMetaData<IdentifiedPayerReceiver> {

	@Override
	public List<Validator<? super IdentifiedPayerReceiver>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IdentifiedPayerReceiver, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IdentifiedPayerReceiver> validator() {
		return new IdentifiedPayerReceiverValidator();
	}

	@Override
	public Validator<? super IdentifiedPayerReceiver> typeFormatValidator() {
		return new IdentifiedPayerReceiverTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IdentifiedPayerReceiver, Set<String>> onlyExistsValidator() {
		return new IdentifiedPayerReceiverOnlyExistsValidator();
	}
}
