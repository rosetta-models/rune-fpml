package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Adjustment;
import fpml.confirmation.validation.AdjustmentTypeFormatValidator;
import fpml.confirmation.validation.AdjustmentValidator;
import fpml.confirmation.validation.exists.AdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Adjustment.class)
public class AdjustmentMeta implements RosettaMetaData<Adjustment> {

	@Override
	public List<Validator<? super Adjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Adjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Adjustment> validator() {
		return new AdjustmentValidator();
	}

	@Override
	public Validator<? super Adjustment> typeFormatValidator() {
		return new AdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Adjustment, Set<String>> onlyExistsValidator() {
		return new AdjustmentOnlyExistsValidator();
	}
}
