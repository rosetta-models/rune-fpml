package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GrossCashflowSequence;
import fpml.confirmation.validation.GrossCashflowSequenceTypeFormatValidator;
import fpml.confirmation.validation.GrossCashflowSequenceValidator;
import fpml.confirmation.validation.exists.GrossCashflowSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GrossCashflowSequence.class)
public class GrossCashflowSequenceMeta implements RosettaMetaData<GrossCashflowSequence> {

	@Override
	public List<Validator<? super GrossCashflowSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GrossCashflowSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GrossCashflowSequence> validator() {
		return new GrossCashflowSequenceValidator();
	}

	@Override
	public Validator<? super GrossCashflowSequence> typeFormatValidator() {
		return new GrossCashflowSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GrossCashflowSequence, Set<String>> onlyExistsValidator() {
		return new GrossCashflowSequenceOnlyExistsValidator();
	}
}
