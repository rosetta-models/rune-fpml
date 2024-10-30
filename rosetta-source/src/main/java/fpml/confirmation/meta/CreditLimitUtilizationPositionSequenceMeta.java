package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditLimitUtilizationPositionSequence;
import fpml.confirmation.validation.CreditLimitUtilizationPositionSequenceTypeFormatValidator;
import fpml.confirmation.validation.CreditLimitUtilizationPositionSequenceValidator;
import fpml.confirmation.validation.exists.CreditLimitUtilizationPositionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditLimitUtilizationPositionSequence.class)
public class CreditLimitUtilizationPositionSequenceMeta implements RosettaMetaData<CreditLimitUtilizationPositionSequence> {

	@Override
	public List<Validator<? super CreditLimitUtilizationPositionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditLimitUtilizationPositionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditLimitUtilizationPositionSequence> validator() {
		return new CreditLimitUtilizationPositionSequenceValidator();
	}

	@Override
	public Validator<? super CreditLimitUtilizationPositionSequence> typeFormatValidator() {
		return new CreditLimitUtilizationPositionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimitUtilizationPositionSequence, Set<String>> onlyExistsValidator() {
		return new CreditLimitUtilizationPositionSequenceOnlyExistsValidator();
	}
}
