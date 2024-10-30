package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EarlyTerminationProvisionSequence;
import fpml.confirmation.validation.EarlyTerminationProvisionSequenceTypeFormatValidator;
import fpml.confirmation.validation.EarlyTerminationProvisionSequenceValidator;
import fpml.confirmation.validation.exists.EarlyTerminationProvisionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EarlyTerminationProvisionSequence.class)
public class EarlyTerminationProvisionSequenceMeta implements RosettaMetaData<EarlyTerminationProvisionSequence> {

	@Override
	public List<Validator<? super EarlyTerminationProvisionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EarlyTerminationProvisionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EarlyTerminationProvisionSequence> validator() {
		return new EarlyTerminationProvisionSequenceValidator();
	}

	@Override
	public Validator<? super EarlyTerminationProvisionSequence> typeFormatValidator() {
		return new EarlyTerminationProvisionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EarlyTerminationProvisionSequence, Set<String>> onlyExistsValidator() {
		return new EarlyTerminationProvisionSequenceOnlyExistsValidator();
	}
}
