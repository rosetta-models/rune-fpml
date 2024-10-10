package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerAmounts;
import fpml.confirmation.validation.BuyerSellerAmountsTypeFormatValidator;
import fpml.confirmation.validation.BuyerSellerAmountsValidator;
import fpml.confirmation.validation.exists.BuyerSellerAmountsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BuyerSellerAmounts.class)
public class BuyerSellerAmountsMeta implements RosettaMetaData<BuyerSellerAmounts> {

	@Override
	public List<Validator<? super BuyerSellerAmounts>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BuyerSellerAmounts, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BuyerSellerAmounts> validator() {
		return new BuyerSellerAmountsValidator();
	}

	@Override
	public Validator<? super BuyerSellerAmounts> typeFormatValidator() {
		return new BuyerSellerAmountsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BuyerSellerAmounts, Set<String>> onlyExistsValidator() {
		return new BuyerSellerAmountsOnlyExistsValidator();
	}
}
