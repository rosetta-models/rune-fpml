package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SPKIDataTypeSequence;
import fpml.confirmation.validation.SPKIDataTypeSequenceTypeFormatValidator;
import fpml.confirmation.validation.SPKIDataTypeSequenceValidator;
import fpml.confirmation.validation.exists.SPKIDataTypeSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SPKIDataTypeSequence.class)
public class SPKIDataTypeSequenceMeta implements RosettaMetaData<SPKIDataTypeSequence> {

	@Override
	public List<Validator<? super SPKIDataTypeSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SPKIDataTypeSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SPKIDataTypeSequence> validator() {
		return new SPKIDataTypeSequenceValidator();
	}

	@Override
	public Validator<? super SPKIDataTypeSequence> typeFormatValidator() {
		return new SPKIDataTypeSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SPKIDataTypeSequence, Set<String>> onlyExistsValidator() {
		return new SPKIDataTypeSequenceOnlyExistsValidator();
	}
}
