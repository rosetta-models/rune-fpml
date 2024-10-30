package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExpiryBase;
import fpml.confirmation.validation.OptionExpiryBaseTypeFormatValidator;
import fpml.confirmation.validation.OptionExpiryBaseValidator;
import fpml.confirmation.validation.exists.OptionExpiryBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExpiryBase.class)
public class OptionExpiryBaseMeta implements RosettaMetaData<OptionExpiryBase> {

	@Override
	public List<Validator<? super OptionExpiryBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionExpiryBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExpiryBase> validator() {
		return new OptionExpiryBaseValidator();
	}

	@Override
	public Validator<? super OptionExpiryBase> typeFormatValidator() {
		return new OptionExpiryBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExpiryBase, Set<String>> onlyExistsValidator() {
		return new OptionExpiryBaseOnlyExistsValidator();
	}
}
