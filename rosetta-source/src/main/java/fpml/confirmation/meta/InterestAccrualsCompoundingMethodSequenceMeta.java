package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestAccrualsCompoundingMethodSequence;
import fpml.confirmation.validation.InterestAccrualsCompoundingMethodSequenceTypeFormatValidator;
import fpml.confirmation.validation.InterestAccrualsCompoundingMethodSequenceValidator;
import fpml.confirmation.validation.exists.InterestAccrualsCompoundingMethodSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InterestAccrualsCompoundingMethodSequence.class)
public class InterestAccrualsCompoundingMethodSequenceMeta implements RosettaMetaData<InterestAccrualsCompoundingMethodSequence> {

	@Override
	public List<Validator<? super InterestAccrualsCompoundingMethodSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestAccrualsCompoundingMethodSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestAccrualsCompoundingMethodSequence> validator() {
		return new InterestAccrualsCompoundingMethodSequenceValidator();
	}

	@Override
	public Validator<? super InterestAccrualsCompoundingMethodSequence> typeFormatValidator() {
		return new InterestAccrualsCompoundingMethodSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAccrualsCompoundingMethodSequence, Set<String>> onlyExistsValidator() {
		return new InterestAccrualsCompoundingMethodSequenceOnlyExistsValidator();
	}
}
