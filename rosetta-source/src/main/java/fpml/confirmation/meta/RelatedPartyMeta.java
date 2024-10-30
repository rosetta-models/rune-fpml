package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.validation.RelatedPartyTypeFormatValidator;
import fpml.confirmation.validation.RelatedPartyValidator;
import fpml.confirmation.validation.exists.RelatedPartyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RelatedParty.class)
public class RelatedPartyMeta implements RosettaMetaData<RelatedParty> {

	@Override
	public List<Validator<? super RelatedParty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelatedParty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RelatedParty> validator() {
		return new RelatedPartyValidator();
	}

	@Override
	public Validator<? super RelatedParty> typeFormatValidator() {
		return new RelatedPartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelatedParty, Set<String>> onlyExistsValidator() {
		return new RelatedPartyOnlyExistsValidator();
	}
}
