package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.validation.PartyAndAccountReferencesModelTypeFormatValidator;
import fpml.confirmation.validation.PartyAndAccountReferencesModelValidator;
import fpml.confirmation.validation.exists.PartyAndAccountReferencesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartyAndAccountReferencesModel.class)
public class PartyAndAccountReferencesModelMeta implements RosettaMetaData<PartyAndAccountReferencesModel> {

	@Override
	public List<Validator<? super PartyAndAccountReferencesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyAndAccountReferencesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyAndAccountReferencesModel> validator() {
		return new PartyAndAccountReferencesModelValidator();
	}

	@Override
	public Validator<? super PartyAndAccountReferencesModel> typeFormatValidator() {
		return new PartyAndAccountReferencesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyAndAccountReferencesModel, Set<String>> onlyExistsValidator() {
		return new PartyAndAccountReferencesModelOnlyExistsValidator();
	}
}
