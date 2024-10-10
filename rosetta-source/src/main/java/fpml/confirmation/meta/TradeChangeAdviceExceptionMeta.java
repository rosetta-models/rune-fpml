package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeChangeAdviceException;
import fpml.confirmation.validation.TradeChangeAdviceExceptionTypeFormatValidator;
import fpml.confirmation.validation.TradeChangeAdviceExceptionValidator;
import fpml.confirmation.validation.exists.TradeChangeAdviceExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeChangeAdviceException.class)
public class TradeChangeAdviceExceptionMeta implements RosettaMetaData<TradeChangeAdviceException> {

	@Override
	public List<Validator<? super TradeChangeAdviceException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeChangeAdviceException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeChangeAdviceException> validator() {
		return new TradeChangeAdviceExceptionValidator();
	}

	@Override
	public Validator<? super TradeChangeAdviceException> typeFormatValidator() {
		return new TradeChangeAdviceExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeAdviceException, Set<String>> onlyExistsValidator() {
		return new TradeChangeAdviceExceptionOnlyExistsValidator();
	}
}
