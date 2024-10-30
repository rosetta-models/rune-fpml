package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractPartyProfile;
import fpml.confirmation.validation.AbstractPartyProfileTypeFormatValidator;
import fpml.confirmation.validation.AbstractPartyProfileValidator;
import fpml.confirmation.validation.exists.AbstractPartyProfileOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractPartyProfile.class)
public class AbstractPartyProfileMeta implements RosettaMetaData<AbstractPartyProfile> {

	@Override
	public List<Validator<? super AbstractPartyProfile>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractPartyProfile, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractPartyProfile> validator() {
		return new AbstractPartyProfileValidator();
	}

	@Override
	public Validator<? super AbstractPartyProfile> typeFormatValidator() {
		return new AbstractPartyProfileTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractPartyProfile, Set<String>> onlyExistsValidator() {
		return new AbstractPartyProfileOnlyExistsValidator();
	}
}
