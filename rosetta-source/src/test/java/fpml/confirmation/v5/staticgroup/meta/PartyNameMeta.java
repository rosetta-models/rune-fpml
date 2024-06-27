package fpml.confirmation.v5.staticgroup.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.v5.staticgroup.PartyName;
import fpml.confirmation.v5.staticgroup.validation.PartyNameTypeFormatValidator;
import fpml.confirmation.v5.staticgroup.validation.PartyNameValidator;
import fpml.confirmation.v5.staticgroup.validation.exists.PartyNameOnlyExistsValidator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0
 */
@RosettaMeta(model= PartyName.class)
public class PartyNameMeta implements RosettaMetaData<PartyName> {

	@Override
	public List<Validator<? super PartyName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyName> validator() {
		return new PartyNameValidator();
	}

	@Override
	public Validator<? super PartyName> typeFormatValidator() {
		return new PartyNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyName, Set<String>> onlyExistsValidator() {
		return new PartyNameOnlyExistsValidator();
	}
}
