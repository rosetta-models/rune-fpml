package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasDeliverySequence;
import fpml.confirmation.validation.GasDeliverySequenceTypeFormatValidator;
import fpml.confirmation.validation.GasDeliverySequenceValidator;
import fpml.confirmation.validation.exists.GasDeliverySequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GasDeliverySequence.class)
public class GasDeliverySequenceMeta implements RosettaMetaData<GasDeliverySequence> {

	@Override
	public List<Validator<? super GasDeliverySequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GasDeliverySequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasDeliverySequence> validator() {
		return new GasDeliverySequenceValidator();
	}

	@Override
	public Validator<? super GasDeliverySequence> typeFormatValidator() {
		return new GasDeliverySequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasDeliverySequence, Set<String>> onlyExistsValidator() {
		return new GasDeliverySequenceOnlyExistsValidator();
	}
}
