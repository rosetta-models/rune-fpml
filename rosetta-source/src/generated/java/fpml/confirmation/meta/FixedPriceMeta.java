package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.validation.FixedPriceTypeFormatValidator;
import fpml.confirmation.validation.FixedPriceValidator;
import fpml.confirmation.validation.exists.FixedPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FixedPrice.class)
public class FixedPriceMeta implements RosettaMetaData<FixedPrice> {

	@Override
	public List<Validator<? super FixedPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedPrice> validator() {
		return new FixedPriceValidator();
	}

	@Override
	public Validator<? super FixedPrice> typeFormatValidator() {
		return new FixedPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedPrice, Set<String>> onlyExistsValidator() {
		return new FixedPriceOnlyExistsValidator();
	}
}
