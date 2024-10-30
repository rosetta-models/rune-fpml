package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.validation.LenderAndCashDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.LenderAndCashDetailsModelValidator;
import fpml.confirmation.validation.exists.LenderAndCashDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LenderAndCashDetailsModel.class)
public class LenderAndCashDetailsModelMeta implements RosettaMetaData<LenderAndCashDetailsModel> {

	@Override
	public List<Validator<? super LenderAndCashDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LenderAndCashDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LenderAndCashDetailsModel> validator() {
		return new LenderAndCashDetailsModelValidator();
	}

	@Override
	public Validator<? super LenderAndCashDetailsModel> typeFormatValidator() {
		return new LenderAndCashDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LenderAndCashDetailsModel, Set<String>> onlyExistsValidator() {
		return new LenderAndCashDetailsModelOnlyExistsValidator();
	}
}
