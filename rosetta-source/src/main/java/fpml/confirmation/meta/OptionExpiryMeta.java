package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExpiry;
import fpml.confirmation.validation.OptionExpiryTypeFormatValidator;
import fpml.confirmation.validation.OptionExpiryValidator;
import fpml.confirmation.validation.exists.OptionExpiryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExpiry.class)
public class OptionExpiryMeta implements RosettaMetaData<OptionExpiry> {

	@Override
	public List<Validator<? super OptionExpiry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionExpiry>create(fpml.confirmation.validation.datarule.OptionExpiryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExpiry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExpiry> validator() {
		return new OptionExpiryValidator();
	}

	@Override
	public Validator<? super OptionExpiry> typeFormatValidator() {
		return new OptionExpiryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExpiry, Set<String>> onlyExistsValidator() {
		return new OptionExpiryOnlyExistsValidator();
	}
}
