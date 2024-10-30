package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeTimestamp;
import fpml.confirmation.validation.TradeTimestampTypeFormatValidator;
import fpml.confirmation.validation.TradeTimestampValidator;
import fpml.confirmation.validation.exists.TradeTimestampOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeTimestamp.class)
public class TradeTimestampMeta implements RosettaMetaData<TradeTimestamp> {

	@Override
	public List<Validator<? super TradeTimestamp>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeTimestamp, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeTimestamp> validator() {
		return new TradeTimestampValidator();
	}

	@Override
	public Validator<? super TradeTimestamp> typeFormatValidator() {
		return new TradeTimestampTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeTimestamp, Set<String>> onlyExistsValidator() {
		return new TradeTimestampOnlyExistsValidator();
	}
}
