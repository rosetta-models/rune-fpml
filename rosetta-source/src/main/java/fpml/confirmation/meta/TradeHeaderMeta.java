package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeHeader;
import fpml.confirmation.validation.TradeHeaderTypeFormatValidator;
import fpml.confirmation.validation.TradeHeaderValidator;
import fpml.confirmation.validation.exists.TradeHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeHeader.class)
public class TradeHeaderMeta implements RosettaMetaData<TradeHeader> {

	@Override
	public List<Validator<? super TradeHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeHeader> validator() {
		return new TradeHeaderValidator();
	}

	@Override
	public Validator<? super TradeHeader> typeFormatValidator() {
		return new TradeHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeHeader, Set<String>> onlyExistsValidator() {
		return new TradeHeaderOnlyExistsValidator();
	}
}
