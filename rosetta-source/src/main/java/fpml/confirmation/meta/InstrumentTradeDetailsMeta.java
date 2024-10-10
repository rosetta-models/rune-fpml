package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InstrumentTradeDetails;
import fpml.confirmation.validation.InstrumentTradeDetailsTypeFormatValidator;
import fpml.confirmation.validation.InstrumentTradeDetailsValidator;
import fpml.confirmation.validation.exists.InstrumentTradeDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InstrumentTradeDetails.class)
public class InstrumentTradeDetailsMeta implements RosettaMetaData<InstrumentTradeDetails> {

	@Override
	public List<Validator<? super InstrumentTradeDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InstrumentTradeDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InstrumentTradeDetails> validator() {
		return new InstrumentTradeDetailsValidator();
	}

	@Override
	public Validator<? super InstrumentTradeDetails> typeFormatValidator() {
		return new InstrumentTradeDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentTradeDetails, Set<String>> onlyExistsValidator() {
		return new InstrumentTradeDetailsOnlyExistsValidator();
	}
}
