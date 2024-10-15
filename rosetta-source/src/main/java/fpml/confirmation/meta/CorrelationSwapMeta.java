package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationSwap;
import fpml.confirmation.validation.CorrelationSwapTypeFormatValidator;
import fpml.confirmation.validation.CorrelationSwapValidator;
import fpml.confirmation.validation.exists.CorrelationSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CorrelationSwap.class)
public class CorrelationSwapMeta implements RosettaMetaData<CorrelationSwap> {

	@Override
	public List<Validator<? super CorrelationSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CorrelationSwap> validator() {
		return new CorrelationSwapValidator();
	}

	@Override
	public Validator<? super CorrelationSwap> typeFormatValidator() {
		return new CorrelationSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationSwap, Set<String>> onlyExistsValidator() {
		return new CorrelationSwapOnlyExistsValidator();
	}
}
