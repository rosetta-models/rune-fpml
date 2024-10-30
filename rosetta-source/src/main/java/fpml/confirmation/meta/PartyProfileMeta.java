package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyProfile;
import fpml.confirmation.validation.PartyProfileTypeFormatValidator;
import fpml.confirmation.validation.PartyProfileValidator;
import fpml.confirmation.validation.exists.PartyProfileOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartyProfile.class)
public class PartyProfileMeta implements RosettaMetaData<PartyProfile> {

	@Override
	public List<Validator<? super PartyProfile>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyProfile, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyProfile> validator() {
		return new PartyProfileValidator();
	}

	@Override
	public Validator<? super PartyProfile> typeFormatValidator() {
		return new PartyProfileTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyProfile, Set<String>> onlyExistsValidator() {
		return new PartyProfileOnlyExistsValidator();
	}
}
