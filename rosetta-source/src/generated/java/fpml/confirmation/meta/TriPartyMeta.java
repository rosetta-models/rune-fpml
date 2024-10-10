package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TriParty;
import fpml.confirmation.validation.TriPartyTypeFormatValidator;
import fpml.confirmation.validation.TriPartyValidator;
import fpml.confirmation.validation.exists.TriPartyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TriParty.class)
public class TriPartyMeta implements RosettaMetaData<TriParty> {

	@Override
	public List<Validator<? super TriParty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TriParty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TriParty> validator() {
		return new TriPartyValidator();
	}

	@Override
	public Validator<? super TriParty> typeFormatValidator() {
		return new TriPartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TriParty, Set<String>> onlyExistsValidator() {
		return new TriPartyOnlyExistsValidator();
	}
}
