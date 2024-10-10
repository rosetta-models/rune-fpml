package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyId;
import fpml.confirmation.validation.PartyIdTypeFormatValidator;
import fpml.confirmation.validation.PartyIdValidator;
import fpml.confirmation.validation.exists.PartyIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyId.class)
public class PartyIdMeta implements RosettaMetaData<PartyId> {

	@Override
	public List<Validator<? super PartyId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyId> validator() {
		return new PartyIdValidator();
	}

	@Override
	public Validator<? super PartyId> typeFormatValidator() {
		return new PartyIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyId, Set<String>> onlyExistsValidator() {
		return new PartyIdOnlyExistsValidator();
	}
}
