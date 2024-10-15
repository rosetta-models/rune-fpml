package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyProfileIdentifier;
import fpml.confirmation.validation.PartyProfileIdentifierTypeFormatValidator;
import fpml.confirmation.validation.PartyProfileIdentifierValidator;
import fpml.confirmation.validation.exists.PartyProfileIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyProfileIdentifier.class)
public class PartyProfileIdentifierMeta implements RosettaMetaData<PartyProfileIdentifier> {

	@Override
	public List<Validator<? super PartyProfileIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyProfileIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyProfileIdentifier> validator() {
		return new PartyProfileIdentifierValidator();
	}

	@Override
	public Validator<? super PartyProfileIdentifier> typeFormatValidator() {
		return new PartyProfileIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyProfileIdentifier, Set<String>> onlyExistsValidator() {
		return new PartyProfileIdentifierOnlyExistsValidator();
	}
}
