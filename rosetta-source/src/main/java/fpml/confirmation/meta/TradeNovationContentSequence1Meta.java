package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeNovationContentSequence1;
import fpml.confirmation.validation.TradeNovationContentSequence1TypeFormatValidator;
import fpml.confirmation.validation.TradeNovationContentSequence1Validator;
import fpml.confirmation.validation.exists.TradeNovationContentSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeNovationContentSequence1.class)
public class TradeNovationContentSequence1Meta implements RosettaMetaData<TradeNovationContentSequence1> {

	@Override
	public List<Validator<? super TradeNovationContentSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeNovationContentSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeNovationContentSequence1> validator() {
		return new TradeNovationContentSequence1Validator();
	}

	@Override
	public Validator<? super TradeNovationContentSequence1> typeFormatValidator() {
		return new TradeNovationContentSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNovationContentSequence1, Set<String>> onlyExistsValidator() {
		return new TradeNovationContentSequence1OnlyExistsValidator();
	}
}
