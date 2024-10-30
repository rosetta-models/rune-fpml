package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InitialMarginCalculationSequence1;
import fpml.confirmation.validation.InitialMarginCalculationSequence1TypeFormatValidator;
import fpml.confirmation.validation.InitialMarginCalculationSequence1Validator;
import fpml.confirmation.validation.exists.InitialMarginCalculationSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InitialMarginCalculationSequence1.class)
public class InitialMarginCalculationSequence1Meta implements RosettaMetaData<InitialMarginCalculationSequence1> {

	@Override
	public List<Validator<? super InitialMarginCalculationSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InitialMarginCalculationSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InitialMarginCalculationSequence1> validator() {
		return new InitialMarginCalculationSequence1Validator();
	}

	@Override
	public Validator<? super InitialMarginCalculationSequence1> typeFormatValidator() {
		return new InitialMarginCalculationSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InitialMarginCalculationSequence1, Set<String>> onlyExistsValidator() {
		return new InitialMarginCalculationSequence1OnlyExistsValidator();
	}
}
