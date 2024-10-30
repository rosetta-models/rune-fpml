package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Party;
import fpml.confirmation.validation.PartyTypeFormatValidator;
import fpml.confirmation.validation.PartyValidator;
import fpml.confirmation.validation.exists.PartyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Party.class)
public class PartyMeta implements RosettaMetaData<Party> {

	@Override
	public List<Validator<? super Party>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Party>create(fpml.confirmation.validation.datarule.PartyChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Party, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Party> validator() {
		return new PartyValidator();
	}

	@Override
	public Validator<? super Party> typeFormatValidator() {
		return new PartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Party, Set<String>> onlyExistsValidator() {
		return new PartyOnlyExistsValidator();
	}
}
