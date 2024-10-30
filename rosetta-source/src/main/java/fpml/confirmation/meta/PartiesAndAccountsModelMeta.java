package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.validation.PartiesAndAccountsModelTypeFormatValidator;
import fpml.confirmation.validation.PartiesAndAccountsModelValidator;
import fpml.confirmation.validation.exists.PartiesAndAccountsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartiesAndAccountsModel.class)
public class PartiesAndAccountsModelMeta implements RosettaMetaData<PartiesAndAccountsModel> {

	@Override
	public List<Validator<? super PartiesAndAccountsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartiesAndAccountsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartiesAndAccountsModel> validator() {
		return new PartiesAndAccountsModelValidator();
	}

	@Override
	public Validator<? super PartiesAndAccountsModel> typeFormatValidator() {
		return new PartiesAndAccountsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartiesAndAccountsModel, Set<String>> onlyExistsValidator() {
		return new PartiesAndAccountsModelOnlyExistsValidator();
	}
}
