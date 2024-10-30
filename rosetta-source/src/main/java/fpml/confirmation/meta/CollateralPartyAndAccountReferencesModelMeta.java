package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralPartyAndAccountReferencesModel;
import fpml.confirmation.validation.CollateralPartyAndAccountReferencesModelTypeFormatValidator;
import fpml.confirmation.validation.CollateralPartyAndAccountReferencesModelValidator;
import fpml.confirmation.validation.exists.CollateralPartyAndAccountReferencesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CollateralPartyAndAccountReferencesModel.class)
public class CollateralPartyAndAccountReferencesModelMeta implements RosettaMetaData<CollateralPartyAndAccountReferencesModel> {

	@Override
	public List<Validator<? super CollateralPartyAndAccountReferencesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralPartyAndAccountReferencesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralPartyAndAccountReferencesModel> validator() {
		return new CollateralPartyAndAccountReferencesModelValidator();
	}

	@Override
	public Validator<? super CollateralPartyAndAccountReferencesModel> typeFormatValidator() {
		return new CollateralPartyAndAccountReferencesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralPartyAndAccountReferencesModel, Set<String>> onlyExistsValidator() {
		return new CollateralPartyAndAccountReferencesModelOnlyExistsValidator();
	}
}
