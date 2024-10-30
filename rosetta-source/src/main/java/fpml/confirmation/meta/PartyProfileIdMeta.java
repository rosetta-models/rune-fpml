package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyProfileId;
import fpml.confirmation.validation.PartyProfileIdTypeFormatValidator;
import fpml.confirmation.validation.PartyProfileIdValidator;
import fpml.confirmation.validation.exists.PartyProfileIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartyProfileId.class)
public class PartyProfileIdMeta implements RosettaMetaData<PartyProfileId> {

	@Override
	public List<Validator<? super PartyProfileId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyProfileId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyProfileId> validator() {
		return new PartyProfileIdValidator();
	}

	@Override
	public Validator<? super PartyProfileId> typeFormatValidator() {
		return new PartyProfileIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyProfileId, Set<String>> onlyExistsValidator() {
		return new PartyProfileIdOnlyExistsValidator();
	}
}
