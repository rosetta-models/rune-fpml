package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyTradeIdentifiers;
import fpml.confirmation.validation.PartyTradeIdentifiersTypeFormatValidator;
import fpml.confirmation.validation.PartyTradeIdentifiersValidator;
import fpml.confirmation.validation.exists.PartyTradeIdentifiersOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyTradeIdentifiers.class)
public class PartyTradeIdentifiersMeta implements RosettaMetaData<PartyTradeIdentifiers> {

	@Override
	public List<Validator<? super PartyTradeIdentifiers>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyTradeIdentifiers, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyTradeIdentifiers> validator() {
		return new PartyTradeIdentifiersValidator();
	}

	@Override
	public Validator<? super PartyTradeIdentifiers> typeFormatValidator() {
		return new PartyTradeIdentifiersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeIdentifiers, Set<String>> onlyExistsValidator() {
		return new PartyTradeIdentifiersOnlyExistsValidator();
	}
}
