package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeeExpiry;
import fpml.confirmation.validation.AccruingFeeExpiryTypeFormatValidator;
import fpml.confirmation.validation.AccruingFeeExpiryValidator;
import fpml.confirmation.validation.exists.AccruingFeeExpiryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccruingFeeExpiry.class)
public class AccruingFeeExpiryMeta implements RosettaMetaData<AccruingFeeExpiry> {

	@Override
	public List<Validator<? super AccruingFeeExpiry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeExpiry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingFeeExpiry> validator() {
		return new AccruingFeeExpiryValidator();
	}

	@Override
	public Validator<? super AccruingFeeExpiry> typeFormatValidator() {
		return new AccruingFeeExpiryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeExpiry, Set<String>> onlyExistsValidator() {
		return new AccruingFeeExpiryOnlyExistsValidator();
	}
}
