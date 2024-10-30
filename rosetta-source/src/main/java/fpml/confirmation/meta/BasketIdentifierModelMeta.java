package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketIdentifierModel;
import fpml.confirmation.validation.BasketIdentifierModelTypeFormatValidator;
import fpml.confirmation.validation.BasketIdentifierModelValidator;
import fpml.confirmation.validation.exists.BasketIdentifierModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BasketIdentifierModel.class)
public class BasketIdentifierModelMeta implements RosettaMetaData<BasketIdentifierModel> {

	@Override
	public List<Validator<? super BasketIdentifierModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.BasketIdentifierModel>create(fpml.confirmation.validation.datarule.BasketIdentifierModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BasketIdentifierModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasketIdentifierModel> validator() {
		return new BasketIdentifierModelValidator();
	}

	@Override
	public Validator<? super BasketIdentifierModel> typeFormatValidator() {
		return new BasketIdentifierModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketIdentifierModel, Set<String>> onlyExistsValidator() {
		return new BasketIdentifierModelOnlyExistsValidator();
	}
}
