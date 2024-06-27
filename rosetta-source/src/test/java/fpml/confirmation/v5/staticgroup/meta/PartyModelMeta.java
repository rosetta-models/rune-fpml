package fpml.confirmation.v5.staticgroup.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.v5.staticgroup.PartyModel;
import fpml.confirmation.v5.staticgroup.validation.PartyModelTypeFormatValidator;
import fpml.confirmation.v5.staticgroup.validation.PartyModelValidator;
import fpml.confirmation.v5.staticgroup.validation.exists.PartyModelOnlyExistsValidator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0
 */
@RosettaMeta(model= PartyModel.class)
public class PartyModelMeta implements RosettaMetaData<PartyModel> {

	@Override
	public List<Validator<? super PartyModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyModel> validator() {
		return new PartyModelValidator();
	}

	@Override
	public Validator<? super PartyModel> typeFormatValidator() {
		return new PartyModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyModel, Set<String>> onlyExistsValidator() {
		return new PartyModelOnlyExistsValidator();
	}
}
