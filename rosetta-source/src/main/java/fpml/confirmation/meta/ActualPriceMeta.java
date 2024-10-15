package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ActualPrice;
import fpml.confirmation.validation.ActualPriceTypeFormatValidator;
import fpml.confirmation.validation.ActualPriceValidator;
import fpml.confirmation.validation.exists.ActualPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ActualPrice.class)
public class ActualPriceMeta implements RosettaMetaData<ActualPrice> {

	@Override
	public List<Validator<? super ActualPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActualPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ActualPrice> validator() {
		return new ActualPriceValidator();
	}

	@Override
	public Validator<? super ActualPrice> typeFormatValidator() {
		return new ActualPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActualPrice, Set<String>> onlyExistsValidator() {
		return new ActualPriceOnlyExistsValidator();
	}
}
