package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendAdjustment;
import fpml.confirmation.validation.DividendAdjustmentTypeFormatValidator;
import fpml.confirmation.validation.DividendAdjustmentValidator;
import fpml.confirmation.validation.exists.DividendAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DividendAdjustment.class)
public class DividendAdjustmentMeta implements RosettaMetaData<DividendAdjustment> {

	@Override
	public List<Validator<? super DividendAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendAdjustment> validator() {
		return new DividendAdjustmentValidator();
	}

	@Override
	public Validator<? super DividendAdjustment> typeFormatValidator() {
		return new DividendAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendAdjustment, Set<String>> onlyExistsValidator() {
		return new DividendAdjustmentOnlyExistsValidator();
	}
}
