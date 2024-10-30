package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditEntityModel;
import fpml.confirmation.validation.CreditEntityModelTypeFormatValidator;
import fpml.confirmation.validation.CreditEntityModelValidator;
import fpml.confirmation.validation.exists.CreditEntityModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditEntityModel.class)
public class CreditEntityModelMeta implements RosettaMetaData<CreditEntityModel> {

	@Override
	public List<Validator<? super CreditEntityModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CreditEntityModel>create(fpml.confirmation.validation.datarule.CreditEntityModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditEntityModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditEntityModel> validator() {
		return new CreditEntityModelValidator();
	}

	@Override
	public Validator<? super CreditEntityModel> typeFormatValidator() {
		return new CreditEntityModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEntityModel, Set<String>> onlyExistsValidator() {
		return new CreditEntityModelOnlyExistsValidator();
	}
}
