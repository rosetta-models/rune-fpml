package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxBarrierFeatureSequenceSequence;
import fpml.confirmation.validation.FxBarrierFeatureSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxBarrierFeatureSequenceSequenceValidator;
import fpml.confirmation.validation.exists.FxBarrierFeatureSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxBarrierFeatureSequenceSequence.class)
public class FxBarrierFeatureSequenceSequenceMeta implements RosettaMetaData<FxBarrierFeatureSequenceSequence> {

	@Override
	public List<Validator<? super FxBarrierFeatureSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxBarrierFeatureSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxBarrierFeatureSequenceSequence> validator() {
		return new FxBarrierFeatureSequenceSequenceValidator();
	}

	@Override
	public Validator<? super FxBarrierFeatureSequenceSequence> typeFormatValidator() {
		return new FxBarrierFeatureSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxBarrierFeatureSequenceSequence, Set<String>> onlyExistsValidator() {
		return new FxBarrierFeatureSequenceSequenceOnlyExistsValidator();
	}
}
