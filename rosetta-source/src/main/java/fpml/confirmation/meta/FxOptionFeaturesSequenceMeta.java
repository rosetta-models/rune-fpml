package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxOptionFeaturesSequence;
import fpml.confirmation.validation.FxOptionFeaturesSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxOptionFeaturesSequenceValidator;
import fpml.confirmation.validation.exists.FxOptionFeaturesSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxOptionFeaturesSequence.class)
public class FxOptionFeaturesSequenceMeta implements RosettaMetaData<FxOptionFeaturesSequence> {

	@Override
	public List<Validator<? super FxOptionFeaturesSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxOptionFeaturesSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxOptionFeaturesSequence> validator() {
		return new FxOptionFeaturesSequenceValidator();
	}

	@Override
	public Validator<? super FxOptionFeaturesSequence> typeFormatValidator() {
		return new FxOptionFeaturesSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOptionFeaturesSequence, Set<String>> onlyExistsValidator() {
		return new FxOptionFeaturesSequenceOnlyExistsValidator();
	}
}
