package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StockLoanModel;
import fpml.confirmation.validation.StockLoanModelTypeFormatValidator;
import fpml.confirmation.validation.StockLoanModelValidator;
import fpml.confirmation.validation.exists.StockLoanModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StockLoanModel.class)
public class StockLoanModelMeta implements RosettaMetaData<StockLoanModel> {

	@Override
	public List<Validator<? super StockLoanModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StockLoanModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StockLoanModel> validator() {
		return new StockLoanModelValidator();
	}

	@Override
	public Validator<? super StockLoanModel> typeFormatValidator() {
		return new StockLoanModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StockLoanModel, Set<String>> onlyExistsValidator() {
		return new StockLoanModelOnlyExistsValidator();
	}
}
