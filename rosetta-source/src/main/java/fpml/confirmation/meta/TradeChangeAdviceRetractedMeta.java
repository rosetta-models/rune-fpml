package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeChangeAdviceRetracted;
import fpml.confirmation.validation.TradeChangeAdviceRetractedTypeFormatValidator;
import fpml.confirmation.validation.TradeChangeAdviceRetractedValidator;
import fpml.confirmation.validation.exists.TradeChangeAdviceRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeChangeAdviceRetracted.class)
public class TradeChangeAdviceRetractedMeta implements RosettaMetaData<TradeChangeAdviceRetracted> {

	@Override
	public List<Validator<? super TradeChangeAdviceRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeChangeAdviceRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeChangeAdviceRetracted> validator() {
		return new TradeChangeAdviceRetractedValidator();
	}

	@Override
	public Validator<? super TradeChangeAdviceRetracted> typeFormatValidator() {
		return new TradeChangeAdviceRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeAdviceRetracted, Set<String>> onlyExistsValidator() {
		return new TradeChangeAdviceRetractedOnlyExistsValidator();
	}
}
