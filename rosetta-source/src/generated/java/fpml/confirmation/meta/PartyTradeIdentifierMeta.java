package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.validation.PartyTradeIdentifierTypeFormatValidator;
import fpml.confirmation.validation.PartyTradeIdentifierValidator;
import fpml.confirmation.validation.exists.PartyTradeIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyTradeIdentifier.class)
public class PartyTradeIdentifierMeta implements RosettaMetaData<PartyTradeIdentifier> {

	@Override
	public List<Validator<? super PartyTradeIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeIdentifier>create(fpml.confirmation.validation.datarule.TradeIdentifierChoice.class),
			factory.<fpml.confirmation.PartyTradeIdentifier>create(fpml.confirmation.validation.datarule.PartyTradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PartyTradeIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyTradeIdentifier> validator() {
		return new PartyTradeIdentifierValidator();
	}

	@Override
	public Validator<? super PartyTradeIdentifier> typeFormatValidator() {
		return new PartyTradeIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeIdentifier, Set<String>> onlyExistsValidator() {
		return new PartyTradeIdentifierOnlyExistsValidator();
	}
}
