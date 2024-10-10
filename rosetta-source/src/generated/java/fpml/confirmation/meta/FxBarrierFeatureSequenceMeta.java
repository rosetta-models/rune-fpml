package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxBarrierFeatureSequence;
import fpml.confirmation.validation.FxBarrierFeatureSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxBarrierFeatureSequenceValidator;
import fpml.confirmation.validation.exists.FxBarrierFeatureSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxBarrierFeatureSequence.class)
public class FxBarrierFeatureSequenceMeta implements RosettaMetaData<FxBarrierFeatureSequence> {

	@Override
	public List<Validator<? super FxBarrierFeatureSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxBarrierFeatureSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxBarrierFeatureSequence> validator() {
		return new FxBarrierFeatureSequenceValidator();
	}

	@Override
	public Validator<? super FxBarrierFeatureSequence> typeFormatValidator() {
		return new FxBarrierFeatureSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxBarrierFeatureSequence, Set<String>> onlyExistsValidator() {
		return new FxBarrierFeatureSequenceOnlyExistsValidator();
	}
}
