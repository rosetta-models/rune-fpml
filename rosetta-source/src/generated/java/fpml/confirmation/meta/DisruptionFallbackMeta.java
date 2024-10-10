package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DisruptionFallback;
import fpml.confirmation.validation.DisruptionFallbackTypeFormatValidator;
import fpml.confirmation.validation.DisruptionFallbackValidator;
import fpml.confirmation.validation.exists.DisruptionFallbackOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DisruptionFallback.class)
public class DisruptionFallbackMeta implements RosettaMetaData<DisruptionFallback> {

	@Override
	public List<Validator<? super DisruptionFallback>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DisruptionFallback, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DisruptionFallback> validator() {
		return new DisruptionFallbackValidator();
	}

	@Override
	public Validator<? super DisruptionFallback> typeFormatValidator() {
		return new DisruptionFallbackTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DisruptionFallback, Set<String>> onlyExistsValidator() {
		return new DisruptionFallbackOnlyExistsValidator();
	}
}
