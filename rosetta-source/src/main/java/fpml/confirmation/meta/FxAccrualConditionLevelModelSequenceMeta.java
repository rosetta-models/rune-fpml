package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualConditionLevelModelSequence;
import fpml.confirmation.validation.FxAccrualConditionLevelModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualConditionLevelModelSequenceValidator;
import fpml.confirmation.validation.exists.FxAccrualConditionLevelModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualConditionLevelModelSequence.class)
public class FxAccrualConditionLevelModelSequenceMeta implements RosettaMetaData<FxAccrualConditionLevelModelSequence> {

	@Override
	public List<Validator<? super FxAccrualConditionLevelModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualConditionLevelModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualConditionLevelModelSequence> validator() {
		return new FxAccrualConditionLevelModelSequenceValidator();
	}

	@Override
	public Validator<? super FxAccrualConditionLevelModelSequence> typeFormatValidator() {
		return new FxAccrualConditionLevelModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualConditionLevelModelSequence, Set<String>> onlyExistsValidator() {
		return new FxAccrualConditionLevelModelSequenceOnlyExistsValidator();
	}
}
