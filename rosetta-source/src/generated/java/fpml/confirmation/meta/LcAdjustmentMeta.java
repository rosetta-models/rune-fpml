package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcAdjustment;
import fpml.confirmation.validation.LcAdjustmentTypeFormatValidator;
import fpml.confirmation.validation.LcAdjustmentValidator;
import fpml.confirmation.validation.exists.LcAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LcAdjustment.class)
public class LcAdjustmentMeta implements RosettaMetaData<LcAdjustment> {

	@Override
	public List<Validator<? super LcAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcAdjustment> validator() {
		return new LcAdjustmentValidator();
	}

	@Override
	public Validator<? super LcAdjustment> typeFormatValidator() {
		return new LcAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcAdjustment, Set<String>> onlyExistsValidator() {
		return new LcAdjustmentOnlyExistsValidator();
	}
}
