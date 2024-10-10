package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceAmount;
import fpml.confirmation.validation.ReferenceAmountTypeFormatValidator;
import fpml.confirmation.validation.ReferenceAmountValidator;
import fpml.confirmation.validation.exists.ReferenceAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReferenceAmount.class)
public class ReferenceAmountMeta implements RosettaMetaData<ReferenceAmount> {

	@Override
	public List<Validator<? super ReferenceAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceAmount> validator() {
		return new ReferenceAmountValidator();
	}

	@Override
	public Validator<? super ReferenceAmount> typeFormatValidator() {
		return new ReferenceAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceAmount, Set<String>> onlyExistsValidator() {
		return new ReferenceAmountOnlyExistsValidator();
	}
}
