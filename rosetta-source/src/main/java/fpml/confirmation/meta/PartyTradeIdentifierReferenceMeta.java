package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyTradeIdentifierReference;
import fpml.confirmation.validation.PartyTradeIdentifierReferenceTypeFormatValidator;
import fpml.confirmation.validation.PartyTradeIdentifierReferenceValidator;
import fpml.confirmation.validation.exists.PartyTradeIdentifierReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyTradeIdentifierReference.class)
public class PartyTradeIdentifierReferenceMeta implements RosettaMetaData<PartyTradeIdentifierReference> {

	@Override
	public List<Validator<? super PartyTradeIdentifierReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyTradeIdentifierReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyTradeIdentifierReference> validator() {
		return new PartyTradeIdentifierReferenceValidator();
	}

	@Override
	public Validator<? super PartyTradeIdentifierReference> typeFormatValidator() {
		return new PartyTradeIdentifierReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeIdentifierReference, Set<String>> onlyExistsValidator() {
		return new PartyTradeIdentifierReferenceOnlyExistsValidator();
	}
}
