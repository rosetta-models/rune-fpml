package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SequencedDisruptionFallback;
import fpml.confirmation.validation.SequencedDisruptionFallbackTypeFormatValidator;
import fpml.confirmation.validation.SequencedDisruptionFallbackValidator;
import fpml.confirmation.validation.exists.SequencedDisruptionFallbackOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SequencedDisruptionFallback.class)
public class SequencedDisruptionFallbackMeta implements RosettaMetaData<SequencedDisruptionFallback> {

	@Override
	public List<Validator<? super SequencedDisruptionFallback>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SequencedDisruptionFallback, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SequencedDisruptionFallback> validator() {
		return new SequencedDisruptionFallbackValidator();
	}

	@Override
	public Validator<? super SequencedDisruptionFallback> typeFormatValidator() {
		return new SequencedDisruptionFallbackTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SequencedDisruptionFallback, Set<String>> onlyExistsValidator() {
		return new SequencedDisruptionFallbackOnlyExistsValidator();
	}
}
