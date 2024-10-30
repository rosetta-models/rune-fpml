package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MandatoryCostRateExpiry;
import fpml.confirmation.validation.MandatoryCostRateExpiryTypeFormatValidator;
import fpml.confirmation.validation.MandatoryCostRateExpiryValidator;
import fpml.confirmation.validation.exists.MandatoryCostRateExpiryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MandatoryCostRateExpiry.class)
public class MandatoryCostRateExpiryMeta implements RosettaMetaData<MandatoryCostRateExpiry> {

	@Override
	public List<Validator<? super MandatoryCostRateExpiry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MandatoryCostRateExpiry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MandatoryCostRateExpiry> validator() {
		return new MandatoryCostRateExpiryValidator();
	}

	@Override
	public Validator<? super MandatoryCostRateExpiry> typeFormatValidator() {
		return new MandatoryCostRateExpiryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryCostRateExpiry, Set<String>> onlyExistsValidator() {
		return new MandatoryCostRateExpiryOnlyExistsValidator();
	}
}
