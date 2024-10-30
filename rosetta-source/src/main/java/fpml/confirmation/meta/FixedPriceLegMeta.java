package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedPriceLeg;
import fpml.confirmation.validation.FixedPriceLegTypeFormatValidator;
import fpml.confirmation.validation.FixedPriceLegValidator;
import fpml.confirmation.validation.exists.FixedPriceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FixedPriceLeg.class)
public class FixedPriceLegMeta implements RosettaMetaData<FixedPriceLeg> {

	@Override
	public List<Validator<? super FixedPriceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedPriceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedPriceLeg> validator() {
		return new FixedPriceLegValidator();
	}

	@Override
	public Validator<? super FixedPriceLeg> typeFormatValidator() {
		return new FixedPriceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedPriceLeg, Set<String>> onlyExistsValidator() {
		return new FixedPriceLegOnlyExistsValidator();
	}
}
