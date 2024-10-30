package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxPerformanceFloatingLeg;
import fpml.confirmation.validation.FxPerformanceFloatingLegTypeFormatValidator;
import fpml.confirmation.validation.FxPerformanceFloatingLegValidator;
import fpml.confirmation.validation.exists.FxPerformanceFloatingLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxPerformanceFloatingLeg.class)
public class FxPerformanceFloatingLegMeta implements RosettaMetaData<FxPerformanceFloatingLeg> {

	@Override
	public List<Validator<? super FxPerformanceFloatingLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPerformanceFloatingLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxPerformanceFloatingLeg> validator() {
		return new FxPerformanceFloatingLegValidator();
	}

	@Override
	public Validator<? super FxPerformanceFloatingLeg> typeFormatValidator() {
		return new FxPerformanceFloatingLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPerformanceFloatingLeg, Set<String>> onlyExistsValidator() {
		return new FxPerformanceFloatingLegOnlyExistsValidator();
	}
}
