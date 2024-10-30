package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InitialMargin;
import fpml.confirmation.validation.InitialMarginTypeFormatValidator;
import fpml.confirmation.validation.InitialMarginValidator;
import fpml.confirmation.validation.exists.InitialMarginOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InitialMargin.class)
public class InitialMarginMeta implements RosettaMetaData<InitialMargin> {

	@Override
	public List<Validator<? super InitialMargin>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InitialMargin, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InitialMargin> validator() {
		return new InitialMarginValidator();
	}

	@Override
	public Validator<? super InitialMargin> typeFormatValidator() {
		return new InitialMarginTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InitialMargin, Set<String>> onlyExistsValidator() {
		return new InitialMarginOnlyExistsValidator();
	}
}
