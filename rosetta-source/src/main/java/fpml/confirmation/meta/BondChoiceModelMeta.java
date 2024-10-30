package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondChoiceModel;
import fpml.confirmation.validation.BondChoiceModelTypeFormatValidator;
import fpml.confirmation.validation.BondChoiceModelValidator;
import fpml.confirmation.validation.exists.BondChoiceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BondChoiceModel.class)
public class BondChoiceModelMeta implements RosettaMetaData<BondChoiceModel> {

	@Override
	public List<Validator<? super BondChoiceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.BondChoiceModel>create(fpml.confirmation.validation.datarule.BondChoiceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BondChoiceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BondChoiceModel> validator() {
		return new BondChoiceModelValidator();
	}

	@Override
	public Validator<? super BondChoiceModel> typeFormatValidator() {
		return new BondChoiceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondChoiceModel, Set<String>> onlyExistsValidator() {
		return new BondChoiceModelOnlyExistsValidator();
	}
}
