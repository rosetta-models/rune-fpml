package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeMaturity;
import fpml.confirmation.validation.TradeMaturityTypeFormatValidator;
import fpml.confirmation.validation.TradeMaturityValidator;
import fpml.confirmation.validation.exists.TradeMaturityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeMaturity.class)
public class TradeMaturityMeta implements RosettaMetaData<TradeMaturity> {

	@Override
	public List<Validator<? super TradeMaturity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeMaturity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeMaturity> validator() {
		return new TradeMaturityValidator();
	}

	@Override
	public Validator<? super TradeMaturity> typeFormatValidator() {
		return new TradeMaturityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeMaturity, Set<String>> onlyExistsValidator() {
		return new TradeMaturityOnlyExistsValidator();
	}
}
