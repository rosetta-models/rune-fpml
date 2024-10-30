package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TransactionClassificationModel;
import fpml.confirmation.validation.TransactionClassificationModelTypeFormatValidator;
import fpml.confirmation.validation.TransactionClassificationModelValidator;
import fpml.confirmation.validation.exists.TransactionClassificationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TransactionClassificationModel.class)
public class TransactionClassificationModelMeta implements RosettaMetaData<TransactionClassificationModel> {

	@Override
	public List<Validator<? super TransactionClassificationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransactionClassificationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TransactionClassificationModel> validator() {
		return new TransactionClassificationModelValidator();
	}

	@Override
	public Validator<? super TransactionClassificationModel> typeFormatValidator() {
		return new TransactionClassificationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransactionClassificationModel, Set<String>> onlyExistsValidator() {
		return new TransactionClassificationModelOnlyExistsValidator();
	}
}
