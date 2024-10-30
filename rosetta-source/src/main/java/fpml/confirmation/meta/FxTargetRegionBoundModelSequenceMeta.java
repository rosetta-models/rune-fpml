package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetRegionBoundModelSequence;
import fpml.confirmation.validation.FxTargetRegionBoundModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxTargetRegionBoundModelSequenceValidator;
import fpml.confirmation.validation.exists.FxTargetRegionBoundModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetRegionBoundModelSequence.class)
public class FxTargetRegionBoundModelSequenceMeta implements RosettaMetaData<FxTargetRegionBoundModelSequence> {

	@Override
	public List<Validator<? super FxTargetRegionBoundModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetRegionBoundModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetRegionBoundModelSequence> validator() {
		return new FxTargetRegionBoundModelSequenceValidator();
	}

	@Override
	public Validator<? super FxTargetRegionBoundModelSequence> typeFormatValidator() {
		return new FxTargetRegionBoundModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetRegionBoundModelSequence, Set<String>> onlyExistsValidator() {
		return new FxTargetRegionBoundModelSequenceOnlyExistsValidator();
	}
}
