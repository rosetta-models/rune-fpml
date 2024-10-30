package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnLegValuationPrice;
import fpml.confirmation.validation.ReturnLegValuationPriceTypeFormatValidator;
import fpml.confirmation.validation.ReturnLegValuationPriceValidator;
import fpml.confirmation.validation.exists.ReturnLegValuationPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReturnLegValuationPrice.class)
public class ReturnLegValuationPriceMeta implements RosettaMetaData<ReturnLegValuationPrice> {

	@Override
	public List<Validator<? super ReturnLegValuationPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Price>create(fpml.confirmation.validation.datarule.PriceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnLegValuationPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnLegValuationPrice> validator() {
		return new ReturnLegValuationPriceValidator();
	}

	@Override
	public Validator<? super ReturnLegValuationPrice> typeFormatValidator() {
		return new ReturnLegValuationPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnLegValuationPrice, Set<String>> onlyExistsValidator() {
		return new ReturnLegValuationPriceOnlyExistsValidator();
	}
}
