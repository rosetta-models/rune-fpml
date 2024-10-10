package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxExpiryDate;
import fpml.confirmation.validation.FxExpiryDateTypeFormatValidator;
import fpml.confirmation.validation.FxExpiryDateValidator;
import fpml.confirmation.validation.exists.FxExpiryDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxExpiryDate.class)
public class FxExpiryDateMeta implements RosettaMetaData<FxExpiryDate> {

	@Override
	public List<Validator<? super FxExpiryDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxExpiryDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxExpiryDate> validator() {
		return new FxExpiryDateValidator();
	}

	@Override
	public Validator<? super FxExpiryDate> typeFormatValidator() {
		return new FxExpiryDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxExpiryDate, Set<String>> onlyExistsValidator() {
		return new FxExpiryDateOnlyExistsValidator();
	}
}
