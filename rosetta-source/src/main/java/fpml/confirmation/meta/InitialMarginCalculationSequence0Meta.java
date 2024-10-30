package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InitialMarginCalculationSequence0;
import fpml.confirmation.validation.InitialMarginCalculationSequence0TypeFormatValidator;
import fpml.confirmation.validation.InitialMarginCalculationSequence0Validator;
import fpml.confirmation.validation.exists.InitialMarginCalculationSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InitialMarginCalculationSequence0.class)
public class InitialMarginCalculationSequence0Meta implements RosettaMetaData<InitialMarginCalculationSequence0> {

	@Override
	public List<Validator<? super InitialMarginCalculationSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InitialMarginCalculationSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InitialMarginCalculationSequence0> validator() {
		return new InitialMarginCalculationSequence0Validator();
	}

	@Override
	public Validator<? super InitialMarginCalculationSequence0> typeFormatValidator() {
		return new InitialMarginCalculationSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InitialMarginCalculationSequence0, Set<String>> onlyExistsValidator() {
		return new InitialMarginCalculationSequence0OnlyExistsValidator();
	}
}
