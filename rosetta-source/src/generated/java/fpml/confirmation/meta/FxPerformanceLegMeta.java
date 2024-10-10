package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxPerformanceLeg;
import fpml.confirmation.validation.FxPerformanceLegTypeFormatValidator;
import fpml.confirmation.validation.FxPerformanceLegValidator;
import fpml.confirmation.validation.exists.FxPerformanceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxPerformanceLeg.class)
public class FxPerformanceLegMeta implements RosettaMetaData<FxPerformanceLeg> {

	@Override
	public List<Validator<? super FxPerformanceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPerformanceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxPerformanceLeg> validator() {
		return new FxPerformanceLegValidator();
	}

	@Override
	public Validator<? super FxPerformanceLeg> typeFormatValidator() {
		return new FxPerformanceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPerformanceLeg, Set<String>> onlyExistsValidator() {
		return new FxPerformanceLegOnlyExistsValidator();
	}
}
