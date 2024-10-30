package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAsianFeatureSequence;
import fpml.confirmation.validation.FxAsianFeatureSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxAsianFeatureSequenceValidator;
import fpml.confirmation.validation.exists.FxAsianFeatureSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAsianFeatureSequence.class)
public class FxAsianFeatureSequenceMeta implements RosettaMetaData<FxAsianFeatureSequence> {

	@Override
	public List<Validator<? super FxAsianFeatureSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAsianFeatureSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAsianFeatureSequence> validator() {
		return new FxAsianFeatureSequenceValidator();
	}

	@Override
	public Validator<? super FxAsianFeatureSequence> typeFormatValidator() {
		return new FxAsianFeatureSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAsianFeatureSequence, Set<String>> onlyExistsValidator() {
		return new FxAsianFeatureSequenceOnlyExistsValidator();
	}
}
