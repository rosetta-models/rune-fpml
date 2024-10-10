package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSingleLeg;
import fpml.confirmation.validation.FxSingleLegTypeFormatValidator;
import fpml.confirmation.validation.FxSingleLegValidator;
import fpml.confirmation.validation.exists.FxSingleLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxSingleLeg.class)
public class FxSingleLegMeta implements RosettaMetaData<FxSingleLeg> {

	@Override
	public List<Validator<? super FxSingleLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxSingleLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSingleLeg> validator() {
		return new FxSingleLegValidator();
	}

	@Override
	public Validator<? super FxSingleLeg> typeFormatValidator() {
		return new FxSingleLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSingleLeg, Set<String>> onlyExistsValidator() {
		return new FxSingleLegOnlyExistsValidator();
	}
}
